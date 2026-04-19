package com.abdi.t3_mobile

import com.abdi.t3_mobile.R
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var etName: EditText? = null
    var rgGender: RadioGroup? = null
    var rbLaki: RadioButton? = null
    var rbPerempuan: RadioButton? = null
    var cbMembaca: CheckBox? = null
    var cbCoding: CheckBox? = null
    var cbOlahraga: CheckBox? = null
    var btnTampil: Button? = null
    var tvHasil: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi
        etName = findViewById<EditText?>(R.id.etName)
        rgGender = findViewById<RadioGroup?>(R.id.rgGender)
        rbLaki = findViewById<RadioButton?>(R.id.rbLaki)
        rbPerempuan = findViewById<RadioButton?>(R.id.rbPerempuan)
        cbMembaca = findViewById<CheckBox?>(R.id.cbMembaca)
        cbCoding = findViewById<CheckBox?>(R.id.cbCoding)
        cbOlahraga = findViewById<CheckBox?>(R.id.cbOlahraga)
        btnTampil = findViewById<Button?>(R.id.btnTampil)
        tvHasil = findViewById<TextView?>(R.id.tvHasil)

        btnTampil!!.setOnClickListener(View.OnClickListener setOnClickListener@{ v: View? ->
            val nama = etName!!.getText().toString().trim { it <= ' ' }
            // VALIDASI NAMA
            if (TextUtils.isEmpty(nama)) {
                etName!!.setError("Nama tidak boleh kosong")
                Toast.makeText(this@MainActivity, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // VALIDASI GENDER
            val selectedId = rgGender!!.getCheckedRadioButtonId()
            if (selectedId == -1) {
                Toast.makeText(this@MainActivity, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var gender = ""
            if (selectedId == R.id.rbLaki) {
                gender = "Laki-laki"
            } else if (selectedId == R.id.rbPerempuan) {
                gender = "Perempuan"
            }

            // HOBI
            val hobi = StringBuilder()

            if (cbMembaca!!.isChecked()) {
                hobi.append("Membaca, ")
            }
            if (cbCoding!!.isChecked()) {
                hobi.append("Coding, ")
            }
            if (cbOlahraga!!.isChecked()) {
                hobi.append("Olahraga, ")
            }

            // Kalau tidak pilih hobi
            val hasilHobi: String?
            if (hobi.length > 0) {
                hasilHobi = hobi.substring(0, hobi.length - 2) // hapus koma terakhir
            } else {
                hasilHobi = "Tidak ada"
            }

            // HASIL
            val hasil = "Nama: " + nama +
                    "\nJenis Kelamin: " + gender +
                    "\nHobi: " + hasilHobi
            tvHasil!!.setText(hasil)
        })
    }
}