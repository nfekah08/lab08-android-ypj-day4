package com.exercise.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exercise.lab08.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val pizzaSize = arrayOf("Please Select Size","Small",
        "Medium","Large","Extra Large")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.scheduleBtn.setOnClickListener {
            val intent = Intent(this,ThanksActivity::class.java)

            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("phone", binding.phoneNoEditText.text.toString())
            intent.putExtra("size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())


            startActivity(intent)
        }

        binding.sizeSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.sizeTextView.text = pizzaSize[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                binding.sizeTextView.text = "Seekbar mula ditekan" //kalau taknak pakai, boleh padam(todo)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.dateBtn.setOnClickListener {

            //get the current date
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker = DatePickerDialog(this,
                android.R.style.ThemeOverlay,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                                                   binding.dateTextView.text = "$dayOfMonth/${month+1}/$year"
                },
                year,
                month,
                day)
            myDatePicker.show()
        }

        binding.timeBtn.setOnClickListener {

            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                                                    val hourFormatted = String.format("%02d",hourOfDay)
                                                    val minuteFormatted = String.format("%02d",minute)
                                                   binding.timeTextView.text = "$hourFormatted:$minuteFormatted";
                },
                hour,
                minute,
                true)
            myTimePicker.show()
        }


    }
}