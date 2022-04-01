package com.android.notestudent

import android.util.Log
import android.widget.Toast
import java.io.Serializable

class Functions {
    companion object{
        private var students: MutableList<Student> = mutableListOf()

        fun registerStudent (student: Student){
            students.add(student)
        }

        fun calcAverage(student: Student): Double {

            var average = (student?.note1+student.note2+student.note3+student.note4+student.note5)/5

            return average
        }

        fun getOne(dni: String?): Student? {
            return students.find { student ->  student.dni == dni }
        }

        fun getAll(): MutableList<Student> = this.students;

    }
}