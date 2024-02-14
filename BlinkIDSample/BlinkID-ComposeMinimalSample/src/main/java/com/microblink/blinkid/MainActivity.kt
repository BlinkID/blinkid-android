package com.microblink.blinkid

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.launch
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.microblink.blinkid.activity.result.ResultStatus
import com.microblink.blinkid.activity.result.contract.MbScan
import com.microblink.blinkid.activity.result.contract.TwoSideDocumentScan
import com.microblink.blinkid.entities.recognizers.Recognizer
import com.microblink.blinkid.entities.recognizers.RecognizerBundle
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer
import com.microblink.blinkid.entities.recognizers.blinkid.idbarcode.IdBarcodeRecognizer
import com.microblink.blinkid.uisettings.BlinkIdUISettings

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val mButtonColors: ButtonColors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.mb_lime),
                    contentColor = colorResource(
                        id = R.color.mb_blue_deep
                    )
                )
                val blinkIdSimpleLauncher = createBlinkIdSimpleLauncher(this)
                val blinkIdCustomLauncher = createBlinkIdCustomLauncher(this)
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { blinkIdSimpleLauncher() },
                        colors = mButtonColors
                    ) {
                        Text("Simple scan")
                    }
                    Button(
                        onClick = { blinkIdCustomLauncher() },
                        colors = mButtonColors
                    ) {
                        Text("Custom scan")
                    }
                }
            }
        }
}

@Composable
fun createBlinkIdSimpleLauncher(context: Context): () -> Unit {
    // TwoSideDocumentScan() can also be replaced with OneSideDocumentScan() for simple single-side scanning
    val launcher = rememberLauncherForActivityResult(TwoSideDocumentScan()) { blinkIdResult ->
        if (blinkIdResult.resultStatus == ResultStatus.FINISHED && blinkIdResult.result != null) {
            Toast.makeText(
                context,
                "The name is " + (blinkIdResult.result?.firstName?.value()
                    ?: blinkIdResult.result?.fullName?.value()),
                Toast.LENGTH_SHORT
            ).show()
        } else if (blinkIdResult.resultStatus == ResultStatus.CANCELLED) {
            Toast.makeText(
                context,
                "Scan has been cancelled",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    return { launcher.launch() }
}

@Composable
fun createBlinkIdCustomLauncher(context: Context): () -> Unit {
    val barcodeRecognizer = IdBarcodeRecognizer()
    val multiSideRecognizer = BlinkIdMultiSideRecognizer().apply {
        setSaveCameraFrames(true)
    }
    val recognizerBundle = RecognizerBundle(barcodeRecognizer, multiSideRecognizer)
    var name = ""
    var source = ""
    // add more than one recognizer by using MbScan()
    val launcher = rememberLauncherForActivityResult(MbScan()) { blinkIdResult ->
        if (blinkIdResult.resultStatus == ResultStatus.FINISHED && blinkIdResult.result != null) {
            recognizerBundle.loadFromIntent(blinkIdResult.result!!)
            recognizerBundle.recognizers.forEach {
                if (it.result.resultState != Recognizer.Result.State.Empty) {
                    when (it.result) {
                        is BlinkIdMultiSideRecognizer.Result -> {
                            val result = it.result as BlinkIdMultiSideRecognizer.Result
                            name = (result.firstName?.value() ?: (result.fullName?.value() ?: ""))
                            source = " - MultiSide"
                        }

                        is IdBarcodeRecognizer.Result -> {
                            val result = it.result as IdBarcodeRecognizer.Result
                            name =
                                (if (result.firstName != "") result.firstName else result.lastName)
                            source = " - Barcode"
                        }

                        else -> {}
                    }
                }
            }

            Toast.makeText(
                context,
                "The name is $name $source",
                Toast.LENGTH_SHORT
            ).show()

        } else if (blinkIdResult.resultStatus == ResultStatus.CANCELLED) {
            Toast.makeText(
                context,
                "Scan has been cancelled",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    val uiSettings = BlinkIdUISettings(recognizerBundle).apply {
        setDocumentDataMatchRequired(true)
    }

    return { launcher.launch(uiSettings) }
}