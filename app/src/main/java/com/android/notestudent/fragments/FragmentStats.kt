package com.android.notestudent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentStats : Fragment() {

    private var statistics: MutableMap<String, Int> = mutableMapOf(
        "students" to Functions.getAll().size,
        "approvedStudents" to 0,
        "opportune" to 0,
        "reprovedStudents" to 0
    )
    var processed:TextView? = null
    var approved:TextView? = null
    var reproved:TextView? = null
    var opportune:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponents()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onStart() {
        super.onStart()
        initComponents()
        showStats()
        processed?.text = statistics["students"].toString()
        approved?.text = statistics["approvedStudents"].toString()
        opportune?.text = statistics["opportune"].toString()
        reproved?.text = statistics["reprovedStudents"].toString()
    }

    fun showStats() {
        for (student: Student in Functions.getAll()) {
            var average = Functions.calcAverage(student)
            if (average > 3.6 && average < 5.0) {
                statistics["approvedStudents"] = statistics["approvedStudents"]!!.plus(1)
            } else if(average > 2.5 && average < 3.6) {
                statistics["opportune"] = statistics["opportune"]!!.plus(1)
            } else if(average > 0 && average < 2.5){
                statistics["reprovedStudents"] = statistics["reprovedStudents"]!!.plus(1)
            }
        }
    }

    private fun initComponents() {
        processed = view?.findViewById(R.id.studentsProcessed)
        approved = view?.findViewById(R.id.studentsApproved)
        reproved = view?.findViewById(R.id.studentsReproved)
        opportune = view?.findViewById(R.id.studentsOpportune)

    }
}