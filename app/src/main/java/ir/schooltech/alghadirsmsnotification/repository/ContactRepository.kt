package ir.schooltech.alghadirsmsnotification.repository

import ir.schooltech.alghadirsmsnotification.data.DatabaseDao
import ir.schooltech.alghadirsmsnotification.model.Contact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactRepository @Inject constructor(private val databaseDao: DatabaseDao) {

fun getAllContacts():Flow<List<Contact>> = databaseDao.getAllContacts()

}