package com.microblink.blinkid

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.microblink.blinkid.databinding.RecognizerRunnerLayoutBinding
import com.microblink.blinkid.entities.recognizers.RecognizerBundle
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdMultiSideRecognizer
import com.microblink.blinkid.entities.recognizers.blinkid.generic.BlinkIdSingleSideRecognizer
import com.microblink.blinkid.fragment.RecognizerRunnerFragment
import com.microblink.blinkid.fragment.overlay.ScanningOverlay
import com.microblink.blinkid.fragment.overlay.blinkid.BlinkIdOverlayController
import com.microblink.blinkid.fragment.overlay.blinkid.BlinkIdOverlaySettings
import com.microblink.blinkid.fragment.overlay.blinkid.BlinkIdOverlayView
import com.microblink.blinkid.fragment.overlay.blinkid.reticleui.ReticleOverlayStrings
import com.microblink.blinkid.fragment.overlay.blinkid.reticleui.ReticleOverlayView
import com.microblink.blinkid.recognition.RecognitionSuccessType
import com.microblink.blinkid.uisettings.BlinkIdUISettings
import com.microblink.blinkid.view.recognition.ScanResultListener

class MainActivity : AppCompatActivity(), RecognizerRunnerFragment.ScanningOverlayBinder {

    var mRecognizerRunnerFragment: RecognizerRunnerFragment? = null
    private var mScanOverlay: BlinkIdOverlayController? = null
    lateinit var mRecognizerBundle: RecognizerBundle
    private lateinit var showScanning: MutableState<Int>

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setting the license key has to be done in the Application class (in this example it is done through the com.microblink.BlinkIdSampleApp)

        this.run {
            setContent {
                supportActionBar?.setShowHideAnimationEnabled(false)
                showScanning =
                    rememberSaveable { mutableIntStateOf(0) }
                when (showScanning.value) {
                    0 -> {
                        LaunchedEffect(supportActionBar?.isShowing) {
                            if (supportActionBar?.isShowing == false) supportActionBar?.show()
                        }
                        MainMenu()
                    }

                    1 -> {
                        AndroidViewBindingBlinkIdFragment()
                    }

                    2 -> {
                        LaunchedEffect(supportActionBar?.isShowing) {
                            if (supportActionBar?.isShowing == false) supportActionBar?.show()
                        }
                        ResultScreen()
                    }
                }
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (supportFragmentManager.fragments.contains(mRecognizerRunnerFragment)) {
            supportFragmentManager.beginTransaction().apply {
                mRecognizerRunnerFragment?.recognizerRunnerView?.pauseScanning()
                super.onConfigurationChanged(newConfig)
                mRecognizerRunnerFragment?.recognizerRunnerView?.changeConfiguration(newConfig)
                mRecognizerRunnerFragment?.recognizerRunnerView?.resumeScanning(false)
            }.commitNow()
        } else super.onConfigurationChanged(newConfig)
    }

    override fun getScanningOverlay(): ScanningOverlay {
        if (mScanOverlay == null) {
            mScanOverlay = createOverlayController(this, mRecognizerBundle, mScanResultListener)
        }
        return mScanOverlay as BlinkIdOverlayController
    }

    private val mScanResultListener: ScanResultListener = object : ScanResultListener {
        override fun onScanningDone(recognitionSuccessType: RecognitionSuccessType) {
            // pause scanning to prevent new results while fragment is being removed
            mRecognizerRunnerFragment?.recognizerRunnerView?.pauseScanning()

            when (recognitionSuccessType) {
                RecognitionSuccessType.UNSUCCESSFUL -> {
                    Toast.makeText(this@MainActivity, "Unsuccessful scan", Toast.LENGTH_SHORT)
                        .show()
                }

                RecognitionSuccessType.SUCCESSFUL -> {
                    when (mRecognizerBundle.recognizers[0].result) {
                        is BlinkIdSingleSideRecognizer.Result -> {
                            val result =
                                mRecognizerBundle.recognizers[0].result as BlinkIdSingleSideRecognizer.Result
                            Toast.makeText(
                                this@MainActivity,
                                "The name is " + (result.firstName?.value()
                                    ?: result.fullName?.value()),
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        is BlinkIdMultiSideRecognizer.Result -> {
                            val result =
                                mRecognizerBundle.recognizers[0].result as BlinkIdMultiSideRecognizer.Result
                            Toast.makeText(
                                this@MainActivity,
                                "The name is " + (result.firstName?.value()
                                    ?: result.fullName?.value()),
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        else -> {
                            Toast.makeText(
                                this@MainActivity,
                                "Successful scan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                RecognitionSuccessType.STAGE_SUCCESSFUL -> Toast.makeText(
                    this@MainActivity,
                    "Stage success",
                    Toast.LENGTH_SHORT
                ).show()

                RecognitionSuccessType.PARTIAL -> Toast.makeText(
                    this@MainActivity,
                    "Partial success",
                    Toast.LENGTH_SHORT
                ).show()
            }

            supportFragmentManager.beginTransaction().apply {
                mScanOverlay = null
                showScanning.value = 2
            }.commit()

        }

        override fun onUnrecoverableError(throwable: Throwable) {}
    }

    private fun createOverlayController(
        context: Context,
        recognizerBundle: RecognizerBundle,
        scanResultListener: ScanResultListener,
    ): BlinkIdOverlayController {
        val overlaySettings = BlinkIdOverlaySettings.Builder(recognizerBundle).build()
        val overlayStrings = ReticleOverlayStrings.Builder(context).build()
        val customStyle = R.style.CustomStyle
        val reticleOverlay: BlinkIdOverlayView =
            ReticleOverlayView(true, true, true, false, true, true, overlayStrings, customStyle)
        return BlinkIdOverlayController(overlaySettings, scanResultListener, reticleOverlay)
    }

    // can be used just like the previous function
    private fun createOverlayController(
        recognizerBundle: RecognizerBundle,
        scanResultListener: ScanResultListener
    ): BlinkIdOverlayController {
        val overlayStrings = ReticleOverlayStrings.Builder(this@MainActivity).build()
        val settings = BlinkIdUISettings(recognizerBundle).also {
            it.setShowFlashlightWarning(true)
            it.setShowIntroductionDialog(true)
            it.setShowOnboardingInfo(true)
            it.setShowMandatoryFieldsMissing(true)
            it.setAllowHapticFeedback(true)
            it.setStrings(overlayStrings)
            it.setOverlayViewStyle(R.style.CustomStyle)
        }
        return settings.createOverlayController(this, scanResultListener)
    }

    @Composable
    fun MainMenu() {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val mButtonColors: ButtonColors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.mb_lime), contentColor = colorResource(
                    id = R.color.mb_blue_deep
                )
            )
            Button(colors = mButtonColors, onClick = {
                supportActionBar?.hide()
                mRecognizerBundle = RecognizerBundle(BlinkIdSingleSideRecognizer())
                showScanning.value = 1
            }) {
                Text("SingleSide Scan")
            }
            Button(colors = mButtonColors, onClick = {
                supportActionBar?.hide()
                mRecognizerBundle = RecognizerBundle(BlinkIdMultiSideRecognizer())
                showScanning.value = 1
            }) {
                Text("MultiSide Scan")
            }

        }
    }

    @Composable
    fun ResultScreen() {
        val result =
            mRecognizerRunnerFragment?.recognizerRunnerView?.recognizerBundle?.recognizers?.get(0)
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                result?.name?.let {
                    Text(
                        it,
                        color = colorResource(id = R.color.mb_lime),
                        fontSize = 20.sp
                    )
                }
            }

            if (result != null) {
                when (result.result) {

                    is BlinkIdSingleSideRecognizer.Result -> {
                        val resultValues = result.result as BlinkIdSingleSideRecognizer.Result
                        ResultRow(
                            fieldName = "First name",
                            result = resultValues.firstName?.value() ?: ""
                        )
                        ResultRow(
                            fieldName = "Last name",
                            result = resultValues.lastName?.value() ?: ""
                        )
                        ResultRow(
                            fieldName = "Full name",
                            result = resultValues.fullName?.value() ?: ""
                        )
                        ResultRow(
                            fieldName = "Date of birth",
                            result = resultValues.dateOfBirth?.date.toString()
                        )
                    }

                    is BlinkIdMultiSideRecognizer.Result -> {
                        val resultValues = result.result as BlinkIdMultiSideRecognizer.Result
                        ResultRow(
                            fieldName = "First name",
                            result = resultValues.firstName?.value() ?: ""
                        )
                        ResultRow(
                            fieldName = "Last name",
                            result = resultValues.lastName?.value() ?: ""
                        )
                        ResultRow(
                            fieldName = "Date of issue",
                            result = resultValues.dateOfIssue?.date.toString()
                        )
                        ResultRow(
                            fieldName = "Date of expiry",
                            result = resultValues.dateOfExpiry?.date.toString()
                        )
                    }
                }
            }
        }
        BackHandler(true) {
            showScanning.value = 0
        }
    }

    @Composable
    fun ResultRow(fieldName: String, result: String) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 10.dp)
        ) {
            Text("$fieldName: $result", color = Color.White)
        }
    }

    @Composable
    fun AndroidViewBindingBlinkIdFragment() {
        AndroidViewBinding(RecognizerRunnerLayoutBinding::inflate) {
            mRecognizerRunnerFragment =
                fragmentContainerView.getFragment<RecognizerRunnerFragment>()
        }

        BackHandler(true) {
            showScanning.value = 0
            // this is done to reinit overlay when re-starting the scanning (so the introduction dialog is shown again)
            mScanOverlay = null
        }
    }
}
