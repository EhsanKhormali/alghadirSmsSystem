package ir.schooltech.alghadirsmsnotification.data

import androidx.room.*
import ir.schooltech.alghadirsmsnotification.model.Contact
import ir.schooltech.alghadirsmsnotification.model.StudentsClass
import kotlinx.coroutines.flow.Flow
import java.util.UUID


@Dao
interface DatabaseDao {
	
	//Contact table operations
	@Query(value = "SELECT * from tbl_contacts")
	fun getAllContacts():Flow<List<Contact>>
	
	@Query(value = "SELECT * from tbl_contacts where id= :id")
	suspend fun getContactById(id:UUID):Contact
	
	@Delete
	suspend fun deleteContact(contact: Contact)
	
	@Update(onConflict = OnConflictStrategy.REPLACE)
	suspend fun updateContact(contact: Contact)
	
	//StudentClass table operations
	@Query(value = "SELECT * from tbl_contacts where class_id= :classId")
	fun getClassStudents(classId:Int):Flow<List<Contact>>
	
	@Query(value = "SELECT * from tbl_student_class")
	fun getAllClasses():Flow<List<StudentsClass>>
	
	@Delete
	suspend fun deleteClass(studentClass:StudentsClass)
	
	@Update(onConflict = OnConflictStrategy.REPLACE)
	suspend fun updateStudentClass(studentClass: StudentsClass)
	
	
}