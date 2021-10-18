package mdy.klt.darkmodesample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mdy.klt.darkmodesample.data.DataStoreSource
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStoreSource: DataStoreSource) : ViewModel(){

    fun saveMode(mode : String){
        viewModelScope.launch {
            dataStoreSource.storeMode(mode)
        }
    }
}