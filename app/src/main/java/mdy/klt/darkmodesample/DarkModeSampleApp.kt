package mdy.klt.darkmodesample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import mdy.klt.darkmodesample.data.DataStoreSource
import mdy.klt.darkmodesample.helper.ThemeHelper
import javax.inject.Inject

@HiltAndroidApp
class DarkModeSampleApp : Application() {

    @Inject lateinit var dataStoreSource: DataStoreSource
    //we want to use theme setting change with another scope of Dispatchers Main with Job.
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        initTheme()
    }

    private fun initTheme() {

        applicationScope.launch {

            val appTheme = dataStoreSource.getMode()
            appTheme.collect {
                ThemeHelper.applyTheme(it)
            }

        }
    }

}