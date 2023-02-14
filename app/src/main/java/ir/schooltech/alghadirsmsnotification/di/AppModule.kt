package ir.schooltech.alghadirsmsnotification.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.schooltech.alghadirsmsnotification.data.AppDatabase
import ir.schooltech.alghadirsmsnotification.data.DatabaseDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
	@Provides
	@Singleton
	fun provideDao(appDatabase: AppDatabase): DatabaseDao {
		return appDatabase.databaseDao()
	}
	
	@Provides
	@Singleton
	fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
		return Room.databaseBuilder(
			context = context,
			klass = AppDatabase::class.java,
			name = "alghadir_sms_system_database"
		).fallbackToDestructiveMigration()
			.build()
	}
	
	
}