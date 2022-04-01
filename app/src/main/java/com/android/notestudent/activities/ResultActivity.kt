package com.android.notestudent

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {

    var dni: TextView? = null
    var name: TextView? = null
    var age: TextView? = null
    var phoneNumber: TextView? = null
    var address: TextView? = null

    var subject1: TextView? = null
    var subject2: TextView? = null
    var subject3: TextView? = null
    var subject4: TextView? = null
    var subject5: TextView? = null

    var note1: TextView? = null
    var note2: TextView? = null
    var note3: TextView? = null
    var note4: TextView? = null
    var note5: TextView? = null

    var average: TextView? = null
    var status: TextView? = null

    //GETTING VALUES
    var dniValue: String? = null
    var nameValue: String? = null
    var ageValue: Int? = null
    var phoneNumberValue: String? = null
    var addressValue: String? = null

    var subject1Value: String? = null
    var subject2Value: String? = null
    var subject3Value: String? = null
    var subject4Value: String? = null
    var subject5Value: String? = null

    var note1Value: Double? = null
    var note2Value: Double? = null
    var note3Value: Double? = null
    var note4Value: Double? = null
    var note5Value: Double? = null

    var averageValue: Double? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        /*val submitButton: Button? = this.findViewById(R.id.proccess)
        submitButton?.setOnClickListener {
            this.onSubmit()
        }*/
        initComponents()
    }

    override fun onStart(){
        super.onStart()
        showStudentResults()
    }

    private fun showStudentResults() {
        try{
            var student = Functions.getOne(dniValue)
            //var average = Functions.calcAverage(student!!)

            var bundle: Bundle? = this.intent.extras
            dniValue = bundle?.getString("dni")
            nameValue = bundle?.getString("name")
            ageValue = bundle?.getInt("age")
            phoneNumberValue = bundle?.getString("phoneNumber")
            addressValue = bundle?.getString("address")

            subject1Value = bundle?.getString("subject1")
            subject2Value = bundle?.getString("subject2")
            subject3Value = bundle?.getString("subject3")
            subject4Value = bundle?.getString("subject4")
            subject5Value = bundle?.getString("subject5")

            note1Value = bundle?.getDouble("note1")
            note2Value = bundle?.getDouble("note2")
            note3Value = bundle?.getDouble("note3")
            note4Value = bundle?.getDouble("note4")
            note5Value = bundle?.getDouble("note5")

            averageValue = bundle?.getDouble("average")


            //SETTING VALUES ON TEXTVIEWS
            dni?.setText(dniValue.toString())
            name?.setText(nameValue)
            age?.setText(ageValue.toString())
            phoneNumber?.setText(phoneNumberValue.toString())
            address?.setText(addressValue)

            subject1?.setText(subject1Value)
            subject2?.setText(subject2Value)
            subject3?.setText(subject3Value)
            subject4?.setText(subject4Value)
            subject5?.setText(subject5Value)

            note1?.setText(note1Value.toString())
            note2?.setText(note2Value.toString())
            note3?.setText(note3Value.toString())
            note4?.setText(note4Value.toString())
            note5?.setText(note5Value.toString())

            this.average?.text = averageValue.toString()

            /*if (average > 3.5) {
                status?.text = "Gana el periodo"
            }
            else if (average > 2.5){
                status?.text = "Pierde con posibilidad de recuperacion"
            } else
            {
                status?.text = "Perdio el periodo"
            }*/

        }
        catch (e: Exception) {
            Toast.makeText(this, "Hubo un error al cargar los datos", Toast.LENGTH_LONG).show()
        }
    }

    private fun initComponents(){
        //GETTING TEXTVIEW ID
        dni = this.findViewById(R.id.showDNI)
        name = this.findViewById(R.id.showName)
        age = this.findViewById(R.id.showAge)
        phoneNumber = this.findViewById(R.id.showPhoneNumber)
        address = this.findViewById(R.id.showAddress)

        subject1 = this.findViewById(R.id.showSubject1)
        subject2 = this.findViewById(R.id.showSubject2)
        subject3 = this.findViewById(R.id.showSubject3)
        subject4 = this.findViewById(R.id.showSubject4)
        subject5 = this.findViewById(R.id.showSubject5)

        note1 = this.findViewById(R.id.showNote1)
        note2 = this.findViewById(R.id.showNote2)
        note3 = this.findViewById(R.id.showNote3)
        note4 = this.findViewById(R.id.showNote4)
        note5 = this.findViewById(R.id.showNote5)

        average = this.findViewById(R.id.showAverage)
        status = this.findViewById(R.id.status)
    }

   /* override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            onSubmit()
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun onSubmit(){
        Toast.makeText(
            this,
            "Lista de estudiantes ${Functions.getAll().size}.",
            Toast.LENGTH_SHORT
        ).show()
    }*/
}