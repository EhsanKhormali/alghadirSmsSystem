package ir.schooltech.alghadirsmsnotification.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_student_class")
data class StudentsClass(
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "class_id")
	val classId : Int,
	@ColumnInfo(name = "class_number")
	val classNumber:Int,
	@ColumnInfo(name = "class_name")
	val className:String
)
