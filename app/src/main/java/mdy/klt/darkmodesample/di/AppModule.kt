package mdy.klt.darkmodesample.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mdy.klt.darkmodesample.data.DataStoreSource
import mdy.klt.darkmodesample.data.DataStoreSourceImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //datastore module

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) : DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile("DS_NAME")
            }
        )

    @Provides
    @Singleton
    fun provideDataStoreSource(ds: DataStore<Preferences>) : DataStoreSource = DataStoreSourceImpl(ds)
}