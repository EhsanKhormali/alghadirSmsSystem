package ir.schooltech.alghadirsmsnotification.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.schooltech.alghadirsmsnotification.model.Contact
import ir.schooltech.alghadirsmsnotification.model.StudentsClass

@Database(entities = [Contact::class,StudentsClass::class], version = 1, exportSchema = false)
abstract class AppDatabase (appDatabase: AppDatabase):RoomDatabase(){
	abstract fun databaseDao():DatabaseDao
}