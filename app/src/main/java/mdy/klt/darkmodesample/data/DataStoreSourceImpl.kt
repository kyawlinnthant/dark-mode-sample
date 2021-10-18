package mdy.klt.darkmodesample.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mdy.klt.darkmodesample.helper.ThemeHelper

class DataStoreSourceImpl(private val ds: DataStore<Preferences>):DataStoreSource {

    companion object{
        val MODE_STATUS = stringPreferencesKey("MODE_STATUS")
    }

    override suspend fun storeMode(mode: String) {
        ds.edit {
            it[MODE_STATUS] = mode
        }
    }

    override suspend fun getMode(): Flow<String> {
        return ds.data.map {
            it[MODE_STATUS] ?: ThemeHelper.DEFAULT //Default of Android Q , without this code, Android Q can use this also
        }
    }

}