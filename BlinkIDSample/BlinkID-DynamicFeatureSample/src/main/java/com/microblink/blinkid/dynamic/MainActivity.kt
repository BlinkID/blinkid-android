package com.microblink.blinkid.dynamic

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

const val LOG_TEST = "LOG_DynamicModule"

class MainActivity : AppCompatActivity() {

    private lateinit var dynamicModulePackageName: String
    private lateinit var dynamicModuleActivityName: String
    private lateinit var dynamicModuleClassname: String

    // Used for local testing
    private lateinit var manager: FakeSplitInstallManager
    // Used for Google Play testing
    // private lateinit var manager: SplitInstallManager

    private val blinkIdDynamicModule by lazy { getString(R.string.dynamic_feature_name) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dynamicModulePackageName = getString(R.string.dynamic_feature_classname)
        dynamicModuleActivityName = getString(R.string.dynamic_feature_activity_name)
        dynamicModuleClassname = "$dynamicModulePackageName.$dynamicModuleActivityName"
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        SplitCompat.installActivity(this)
        manager = FakeSplitInstallManagerFactory.createNewInstance(
            this,
            getExternalFilesDir("local_testing")
        )
    // manager = SplitInstallManagerFactory.create(this)
    }

    fun onDownloadButtonClick(view: View) {
        installDynamicModule()
    }

    fun onStartButtonClick(view: View) {
        startDynamicModule()
    }

    // uninstall is not supported when locally testing
    // enable the button in activity_main.xml if testing on Google Play
    fun onUninstallButtonClick(view: View) {
        uninstallDynamicModule()
    }

    private fun uninstallDynamicModule() {
        Log.i("DynamicModule", "Installed dynamic modules: ")
        var list: MutableList<String> = emptyList<String>().toMutableList()
        manager.installedModules.forEach {
            Log.i("DynamicModule", it)
            list.add(it)
        }

        // Once called, the Play Store will try to eventually remove those modules in the background.
        // The module is not always immediately uninstalled.
        manager.deferredUninstall(list)
            .addOnCompleteListener {
                Log.i(
                    LOG_TEST,
                    "Module $blinkIdDynamicModule uninstallation"
                )
            }
            .addOnSuccessListener { Log.i(LOG_TEST, "Deleted $blinkIdDynamicModule") }
            .addOnFailureListener {
                Log.i(
                    LOG_TEST,
                    "Error deleting $blinkIdDynamicModule ${it.message}"
                )
            }
    }

    private fun launchActivity(className: String) {
        Intent().setClassName(packageName, className)
            .also {
                startActivity(it)
            }
    }

    private fun installDynamicModule() {
        val request = SplitInstallRequest.newBuilder()
            .addModule(blinkIdDynamicModule)
            .build()

        manager.startInstall(request)
            .addOnCompleteListener { Log.i(LOG_TEST, "Module $blinkIdDynamicModule installed") }
            .addOnSuccessListener { Log.i(LOG_TEST, "Loading $blinkIdDynamicModule") }
            .addOnFailureListener {
                Log.i(
                    LOG_TEST,
                    "Error Loading $blinkIdDynamicModule ${it.message}"
                )
            }
    }

    private fun startDynamicModule() {
        if (manager.installedModules.contains(blinkIdDynamicModule)) {
            Log.i(LOG_TEST, "The dynamic module is installed")

            onSuccessfulLoad(blinkIdDynamicModule)

        } else {
            Log.i(LOG_TEST, "The dynamic module is not installed")

            val request = SplitInstallRequest.newBuilder()
                .addModule(blinkIdDynamicModule)
                .build()

            manager.startInstall(request)
                .addOnCompleteListener { Log.i(LOG_TEST, "Module $blinkIdDynamicModule installed") }
                .addOnSuccessListener {
                    Log.i(LOG_TEST, "Loading $blinkIdDynamicModule")
                    onSuccessfulLoad(blinkIdDynamicModule)
                }
                .addOnFailureListener {
                    Log.i(
                        LOG_TEST,
                        "Error Loading $blinkIdDynamicModule ${it.message}"
                    )
                }
        }
    }

    private fun onSuccessfulLoad(moduleName: String) {
        when (moduleName) {
            blinkIdDynamicModule -> launchActivity(dynamicModuleClassname)
        }
    }

}