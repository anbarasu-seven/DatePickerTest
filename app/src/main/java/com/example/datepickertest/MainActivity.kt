package com.example.datepickertest

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datePicker = findViewById<DatePicker>(R.id.date_pickerId)
        val today = Calendar.getInstance()

        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.onlyCalendar).setOnClickListener {
            datePicker.calendarViewShown = true
            datePicker.spinnersShown = false
        }

        findViewById<Button>(R.id.onlySpinner).setOnClickListener {
            datePicker.calendarViewShown = false
            datePicker.spinnersShown = true
        }

        findViewById<Button>(R.id.both).setOnClickListener {
            datePicker.calendarViewShown = true
            datePicker.spinnersShown = true
        }

        findViewById<Button>(R.id.popupCal).setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePikcerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            datePikcerDialog.show()
        }

        findViewById<Button>(R.id.popupSpinner).setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePikcerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            datePikcerDialog.datePicker.calendarViewShown = false
            datePikcerDialog.datePicker.spinnersShown = true
            datePikcerDialog.show()
        }

        //create custom dialog
        //shot custom layout + spinner date picker
    }
}