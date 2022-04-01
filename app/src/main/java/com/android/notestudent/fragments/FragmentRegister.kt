package com.android.notestudent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentRegister : Fragment() {
    var dni: EditText? = null
    var name: EditText? = null
    var age: EditText? = null
    var phoneNumber: EditText? = null
    var address: EditText? = null

    var subject1: EditText? = null
    var subject2: EditText? = null
    var subject3: EditText? = null
    var subject4: EditText? = null
    var subject5: EditText? = null

    var note1: EditText? = null
    var note2: EditText? = null
    var note3: EditText? = null
    var note4: EditText? = null
    var note5: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onStart() {
        super.onStart()
        initViewComponents()
        val submitButton: Button? = view?.findViewById(R.id.submit)
        submitButton?.setOnClickListener {
            this.onSubmit()
        }
    }

    private fun initViewComponents() {
        dni = view?.findViewById(R.id.textDNI)
        name = view?.findViewById(R.id.textName)
        age = view?.findViewById(R.id.textAge)
        phoneNumber = view?.findViewById(R.id.textPhoneNumber)
        address = view?.findViewById(R.id.textAddress)

        subject1 = view?.findViewById(R.id.textSubject1)
        subject2 = view?.findViewById(R.id.textSubject2)
        subject3 = view?.findViewById(R.id.textSubject3)
        subject4 = view?.findViewById(R.id.textSubject4)
        subject5 = view?.findViewById(R.id.textSubject5)
        note1 = view?.findViewById(R.id.textNote1)
        note2 = view?.findViewById(R.id.textNote2)
        note3 = view?.findViewById(R.id.textNote3)
        note4 = view?.findViewById(R.id.textNote4)
        note5 = view?.findViewById(R.id.textNote5)

    }

    private fun onSubmit() {
        try {
            val student = initStudentData()

            var notes = arrayListOf(student.note1, student.note2, student.note3, student.note4, student.note5)

            //Validación de que la nota esté en el rango aceptado.
            if(validate(notes)){
                Functions.registerStudent(student)
                student.average = Functions.calcAverage(student)

                Toast.makeText(
                    context,
                    "El estudiante ${student.name} ha sido registrado correctamente.",
                    Toast.LENGTH_SHORT
                ).show()

                val results = Intent(activity, ResultActivity::class.java)
                results.putExtra("dni", student.dni)
                results.putExtra("name", student.name)
                results.putExtra("age", student.age)
                results.putExtra("phoneNumber", student.phoneNumber)
                results.putExtra("address", student.address)

                results.putExtra("subject1", student.subject1)
                results.putExtra("subject2", student.subject2)
                results.putExtra("subject3", student.subject3)
                results.putExtra("subject4", student.subject4)
                results.putExtra("subject5", student.subject5)

                results.putExtra("note1", student.note1)
                results.putExtra("note2", student.note2)
                results.putExtra("note3", student.note3)
                results.putExtra("note4", student.note4)
                results.putExtra("note5", student.note5)

                results.putExtra("average", student.average)

                startActivity(results)
            }
            else {
                Toast.makeText(context, "Las notas ingresadas deben ser entre 0 y 5", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(context, "Verifica los campos.", Toast.LENGTH_LONG).show()
        }
    }

    private fun validate(notes: List<Double> ): Boolean {
        for(note: Double in notes){
            if(note > 5 || note < 0){
                return false
            }
        }
        return true
    }

    private fun initStudentData(): Student{
        val student = Student()
        student.dni = dni?.text.toString()
        student.name = name?.text.toString()
        student.age = age?.text.toString().toInt()
        student.address = address?.text.toString()
        student.phoneNumber = phoneNumber?.text.toString()

        student.subject1 = subject1?.text.toString()
        student.subject2 = subject2?.text.toString()
        student.subject3 = subject3?.text.toString()
        student.subject4 = subject4?.text.toString()
        student.subject5 = subject5?.text.toString()

        student.note1 = note1?.text.toString().toDouble()
        student.note2 = note2?.text.toString().toDouble()
        student.note3 = note3?.text.toString().toDouble()
        student.note4 = note4?.text.toString().toDouble()
        student.note5 = note5?.text.toString().toDouble()
        return student
    }
}
