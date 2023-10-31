package com.microblink.blinkid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.microblink.blinkid.activity.result.ResultStatus
import com.microblink.blinkid.activity.result.ScanResult
import com.microblink.blinkid.activity.result.contract.MbScan
import com.microblink.blinkid.entities.recognizers.RecognizerBundle
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer
import com.microblink.blinkid.uisettings.BlinkIdUISettings
import com.microblink.blinkid.uisettings.UISettings

class MainActivity : AppCompatActivity() {

    private lateinit var recognizer: BlinkIdMultiSideRecognizer
    private lateinit var recognizerBundle: RecognizerBundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // we'll use Machine Readable Travel Document recognizer
        recognizer = BlinkIdMultiSideRecognizer()

        // put our recognizer in bundle so that it can be sent via intent
        recognizerBundle = RecognizerBundle(recognizer)
    }

    fun onScanButtonClick() {
        // use default UI for scanning documents
        val uiSettings = BlinkIdUISettings(recognizerBundle)

        // start scan activity based on UI settings
        blinkIdScanLauncher.launch(uiSettings)
    }

    private val blinkIdScanLauncher = registerForActivityResult<UISettings<*>, ScanResult>(
        MbScan()
    ) { mbScanResult: ScanResult ->
        when (mbScanResult.resultStatus) {
            ResultStatus.FINISHED -> {
                // OK result code means scan was successful
                mbScanResult.result?.let { onScanSuccess(it) }
            }

            ResultStatus.EXCEPTION -> {
                // code after a failed scan
                Toast.makeText(
                    this@MainActivity,
                    "Scan failed: ${mbScanResult.exception?.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {
                // code after a cancelled scan
                onScanCanceled()
            }
        }
    }

    private fun onScanSuccess(data: Intent) {
        recognizerBundle.loadFromIntent(data)
        val result: BlinkIdMultiSideRecognizer.Result = recognizer.result
        val name = result.firstName?.value()
        Toast.makeText(this, "Name: $name", Toast.LENGTH_LONG).show()
    }

    private fun onScanCanceled() {
        Toast.makeText(this, "Scan cancelled!", Toast.LENGTH_SHORT).show()
    }

}