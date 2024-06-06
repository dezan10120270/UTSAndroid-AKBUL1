package com.example.utsandroid_akbul1_10120270_dezandaffa

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog

    //6 Juni 2024
    //10120270
    //Dezan Daffa Ramadhan
    //AKBUL1

class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val jenisTes = intent.getStringExtra("JENIS_TES")
        val tanggalTerkonfirmasi = intent.getStringExtra("TANGGAL_TERKONFIRMASI")
        val nik = intent.getStringExtra("NIK")
        val nama = intent.getStringExtra("NAMA")
        val tanggalLahir = intent.getStringExtra("TANGGAL_LAHIR")
        val jenisKelamin = intent.getStringExtra("JENIS_KELAMIN")
        val hubunganDenganAnda = intent.getStringExtra("HUBUNGAN_DENGAN_ANDA")

        findViewById<TextView>(R.id.tvJenisTesValue).text = jenisTes
        findViewById<TextView>(R.id.tvTanggalTerkonfirmasiValue).text = tanggalTerkonfirmasi
        findViewById<TextView>(R.id.tvNikValue).text = nik
        findViewById<TextView>(R.id.tvNamaValue).text = nama
        findViewById<TextView>(R.id.tvTanggalLahirValue).text = tanggalLahir
        findViewById<TextView>(R.id.tvJenisKelaminValue).text = jenisKelamin
        findViewById<TextView>(R.id.tvHubunganDenganAndaValue).text = hubunganDenganAnda

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        btnSimpan.setOnClickListener {
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(this)
        val bottomSheetView = layoutInflater.inflate(R.layout.activity_berhasil, null)

        val btnOk = bottomSheetView.findViewById<Button>(R.id.buttonOk)
        btnOk.setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }
}
