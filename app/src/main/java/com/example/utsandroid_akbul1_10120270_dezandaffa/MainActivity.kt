package com.example.utsandroid_akbul1_10120270_dezandaffa

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import java.util.*

    //6 Juni 2024
    //10120270
    //Dezan Daffa Ramadhan
    //AKBUL1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitButton: Button = findViewById(R.id.submit_button)

        val tanggalTerkonfirmasi: EditText = findViewById(R.id.tanggal_terkonfirmasi)
        val tanggalLahir: EditText = findViewById(R.id.tanggal_lahir)

        tanggalTerkonfirmasi.setOnClickListener {
            showDatePickerDialog(tanggalTerkonfirmasi)
        }

        tanggalLahir.setOnClickListener {
            showDatePickerDialog(tanggalLahir)
        }

        submitButton.setOnClickListener {
            val jenisTesGroup: RadioGroup = findViewById(R.id.jenis_tes_group)
            val jenisTesId = jenisTesGroup.checkedRadioButtonId
            val jenisTes = findViewById<RadioButton>(jenisTesId)?.text.toString()

            val nik: EditText = findViewById(R.id.nik)
            val nama: EditText = findViewById(R.id.nama)
            val tanggalLahir: EditText = findViewById(R.id.tanggal_lahir)
            val jenisKelaminGroup: RadioGroup = findViewById(R.id.jenis_kelamin_group)
            val jenisKelaminId = jenisKelaminGroup.checkedRadioButtonId
            val jenisKelamin = findViewById<RadioButton>(jenisKelaminId)?.text.toString()
            val hubunganDenganAndaGroup: RadioGroup = findViewById(R.id.hubungan_dengan_anda_group)
            val hubunganDenganAndaId = hubunganDenganAndaGroup.checkedRadioButtonId
            val hubunganDenganAnda = findViewById<RadioButton>(hubunganDenganAndaId)?.text.toString()

            val confirmationCheckbox: CheckBox = findViewById(R.id.confirmation_checkbox)

            if (jenisTes.isEmpty() || tanggalTerkonfirmasi.text.isEmpty() || nik.text.isEmpty() ||
                nama.text.isEmpty() || tanggalLahir.text.isEmpty() || jenisKelamin.isEmpty() ||
                hubunganDenganAnda.isEmpty() || !confirmationCheckbox.isChecked) {
                Toast.makeText(this, "Harap lengkapi semua data dan setujui checkbox", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ReviewActivity::class.java)
                intent.putExtra("JENIS_TES", jenisTes)
                intent.putExtra("TANGGAL_TERKONFIRMASI", tanggalTerkonfirmasi.text.toString())
                intent.putExtra("NIK", nik.text.toString())
                intent.putExtra("NAMA", nama.text.toString())
                intent.putExtra("TANGGAL_LAHIR", tanggalLahir.text.toString())
                intent.putExtra("JENIS_KELAMIN", jenisKelamin)
                intent.putExtra("HUBUNGAN_DENGAN_ANDA", hubunganDenganAnda)
                startActivity(intent)
            }
        }
    }

    private fun showDatePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay ${getMonthName(selectedMonth)} $selectedYear"
                editText.setText(selectedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun getMonthName(month: Int): String {
        val monthNames = arrayOf("Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember")
        return monthNames[month]
    }
}
