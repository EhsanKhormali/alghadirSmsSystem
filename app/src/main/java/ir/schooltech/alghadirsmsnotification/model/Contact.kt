package ir.schooltech.alghadirsmsnotification.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tbl_contacts")
data class Contact(
	@PrimaryKey
	val id: UUID = UUID.randomUUID(),
	@ColumnInfo(name = "first_name")
	val firstName:String,
	@ColumnInfo(name = "last_name")
	val lastName:String,
	@ColumnInfo(name = "mobile_number")
	val mobileNumber:String,
	@ColumnInfo(name = "class_id")
	val classId:Int
	)
