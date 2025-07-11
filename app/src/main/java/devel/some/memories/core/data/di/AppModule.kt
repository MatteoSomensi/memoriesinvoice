package devel.some.memories.core.data.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import devel.some.memories.echos.data.EchoDatabase
import devel.some.memories.echos.data.audio.AndroidAudioPlayer
import devel.some.memories.echos.data.echo.RoomEchoDataSource
import devel.some.memories.echos.data.recording.AndroidVoiceRecorder
import devel.some.memories.echos.data.recording.InternalRecordingStorage
import devel.some.memories.echos.data.settings.DataStoreSettings
import devel.some.memories.echos.domain.audio.AudioPlayer
import devel.some.memories.echos.domain.echo.EchoDataSource
import devel.some.memories.echos.domain.recording.RecordingStorage
import devel.some.memories.echos.domain.recording.VoiceRecorder
import devel.some.memories.echos.domain.settings.SettingsPreferences
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Module
    @InstallIn(SingletonComponent::class)
    object WithProvides {

        private val TAG = AppModule::class.simpleName

        private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
            Timber.tag(TAG!!).e(exception, "CoroutineExceptionHandler got ${exception.localizedMessage}")
        }

        private val appCoroutineScope =
            CoroutineScope(context = SupervisorJob() + Dispatchers.IO + exceptionHandler)

        @Provides
        fun provideCoroutineScope(): CoroutineScope = appCoroutineScope

        @Provides
        @Singleton
        fun provideEchoDatabase(@ApplicationContext appContext: Context): EchoDatabase = Room.databaseBuilder(
                appContext,
                EchoDatabase::class.java,
                "echos.db"
            ).fallbackToDestructiveMigration(dropAllTables = true).build()

        @Provides
        fun provideEchoDao(echoDatabase: EchoDatabase) = echoDatabase.echoDao
    }

    @Binds
    abstract fun provideVoiceRecorder(impl: AndroidVoiceRecorder): VoiceRecorder

    @Binds
    abstract fun provideRecordingStorage(impl: InternalRecordingStorage): RecordingStorage

    @Binds
    abstract fun provideAudioPlayer(impl: AndroidAudioPlayer): AudioPlayer

    @Binds
    abstract  fun provideEchoDataSource(impl: RoomEchoDataSource): EchoDataSource

    @Binds
    abstract fun provideSettingsPreferences(impl: DataStoreSettings): SettingsPreferences
}
