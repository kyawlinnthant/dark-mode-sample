package mdy.klt.darkmodesample.data

import kotlinx.coroutines.flow.Flow

interface DataStoreSource {
    suspend fun storeMode(mode : String)
    suspend fun getMode(): Flow<String>
}