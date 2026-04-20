package com.abdi.t3_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        val etName = findViewById<EditText>(R.id.etName)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val rbLaki = findViewById<RadioButton>(R.id.rbLaki)
        val rbPerempuan = findViewById<RadioButton>(R.id.rbPerempuan)

        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)

        val btnTampil = findViewById<Button>(R.id.btnTampil)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        btnTampil.setOnClickListener {
            val nama = etName.text.toString().trim()
            // Validasi nama
            if (nama.isEmpty()) {
                Toast.makeText(this, "Nama Tidak Boleh Kosong!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi gender
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val gender = when (selectedGenderId) {
                R.id.rbLaki -> "Laki-laki"
                R.id.rbPerempuan -> "Perempuan"
                else -> "-"
            }

            // Ambil hobi
            val listHobi = mutableListOf<String>()
            if (cbMembaca.isChecked) listHobi.add("Membaca")
            if (cbCoding.isChecked) listHobi.add("Coding")
            if (cbOlahraga.isChecked) listHobi.add("Olahraga")

            // validasi minimal 1 hobi
            if (listHobi.isEmpty()) {
                Toast.makeText(this, "Pilih minimal 1 hobi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val hobi = listHobi.joinToString(", ")

            // Tampilkan hasil
            val hasil = """
                Nama    : $nama
                Kelamin : $gender
                Hobi    : $hobi
            """.trimIndent()
            tvHasil.text = hasil
        }
    }
}