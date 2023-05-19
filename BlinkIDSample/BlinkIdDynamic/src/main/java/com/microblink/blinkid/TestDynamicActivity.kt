package com.microblink.blinkid

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.launch
import androidx.appcompat.app.AppCompatActivity
import com.microblink.blinkid.dynamic.R
import com.microblink.blinkid.intent.IntentDataTransferMode
import com.microblink.blinkid.activity.result.ResultStatus
import com.microblink.blinkid.activity.result.TwoSideScanResult
import com.microblink.blinkid.activity.result.contract.TwoSideDocumentScan


class TestDynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MicroblinkSDK.setLicenseFile("com.microblink.blinkid.mblic", this)

        // use optimised way for transferring RecognizerBundle between activities, while ensuring
        // data does not get lost when Android restarts the scanning activity
        MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED)
        setContentView(R.layout.dynamic_activity_main)
    }


    fun onScanButtonClick(view: View) {
        // start scan activity
        resultLauncher.launch()
    }

    private val resultLauncher = registerForActivityResult(TwoSideDocumentScan()) { twoSideScanResult: TwoSideScanResult ->
            when (twoSideScanResult.resultStatus) {
                ResultStatus.FINISHED -> {
                    // code after a successful scan
                    // use twoSideScanResult.result for fetching results, for example:
                    val firstName = twoSideScanResult.result?.firstName?.value()
                    Toast.makeText(this@TestDynamicActivity, "Name: $firstName", Toast.LENGTH_SHORT).show()
                }

                ResultStatus.EXCEPTION -> {
                    // code after a failed scan
                    Toast.makeText(
                        this@TestDynamicActivity,
                        "Scan failed: ${twoSideScanResult.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    // code after a cancelled scan
                    Toast.makeText(this@TestDynamicActivity, "Scan canceled!", Toast.LENGTH_SHORT).show()
                }
            }
        }
}