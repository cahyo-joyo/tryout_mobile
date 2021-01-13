package com.example.tryout_mobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var kuis: TextView? = null
    var rg: RadioGroup? = null
    var PilihanA: RadioButton? = null
    var PilihanB: RadioButton? = null
    var PilihanC: RadioButton? = null
    var PilihanD: RadioButton? = null
    var nomor = 0

    //pertanyaan
    var pertanyaan_kuis = arrayOf(
        "1. Presiden Indonesia yang keenam adalah",
        "2. Lambang Negara Indonesia adalah",
        "3. Ibukota Indonesia adalah",
        "4. Lagu Kebangsaan Indonesia adalah",
        "5. Bendera Negara Indonesia adalah"
    )

    //pilihan jawaban a, b, c, d
    var pilihan_jawaban = arrayOf(
        "Soekarno", "Habibie", "Susilo Bambang Yudhoyono", "Joko Widodo",
        "Gajah Putih", "Garuda", "Macan", "Elang",
        "Jakarta", "Bogor", "Tangerang", "Bekasi",
        "Indonesia Raya", "Tanah Airku", "Indonesia Pusaka", "Indonesia Merdeka",
        "Merah Biru Putih", "Merah Putih", "Putih Merah", "Belang-belang"
    )

    //jawaban benar
    var jawaban_benar = arrayOf(
        "Susilo Bambang Yudhoyono",
        "Garuda",
        "Jakarta",
        "Indonesia Raya",
        "Merah Putih"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kuis = findViewById(R.id.kuis) as TextView?
        rg = findViewById(R.id.pilihan) as RadioGroup?
        PilihanA = findViewById(R.id.pilihanA) as RadioButton?
        PilihanB = findViewById(R.id.pilihanB) as RadioButton?
        PilihanC = findViewById(R.id.pilihanC) as RadioButton?
        PilihanD = findViewById(R.id.pilihanD) as RadioButton?
        kuis!!.text = pertanyaan_kuis[nomor]
        PilihanA!!.text = pilihan_jawaban[0]
        PilihanB!!.text = pilihan_jawaban[1]
        PilihanC!!.text = pilihan_jawaban[2]
        PilihanD!!.text = pilihan_jawaban[3]
        rg!!.check(0)
        benar = 0
        salah = 0
    }

    fun next(view: View?) {
        if (PilihanA!!.isChecked || PilihanB!!.isChecked || PilihanC!!.isChecked || PilihanD!!.isChecked) {
            val jawaban_user =
                findViewById(rg!!.checkedRadioButtonId) as RadioButton
            val ambil_jawaban_user = jawaban_user.text.toString()
            rg!!.check(0)
            if (ambil_jawaban_user.equals(
                    jawaban_benar[nomor],
                    ignoreCase = true
                )
            ) benar++ else salah++
            nomor++
            if (nomor < pertanyaan_kuis.size) {
                kuis!!.text = pertanyaan_kuis[nomor]
                PilihanA!!.text = pilihan_jawaban[nomor * 4 + 0]
                PilihanB!!.text = pilihan_jawaban[nomor * 4 + 1]
                PilihanC!!.text = pilihan_jawaban[nomor * 4 + 2]
                PilihanD!!.text = pilihan_jawaban[nomor * 4 + 3]
            } else {
                hasil = benar * 20
                val selesai = Intent(getApplicationContext(), HasilKuis::class.java)
                startActivity(selesai)
            }
        } else {
            Toast.makeText(this, "Kamu Jawab Dulu", Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        var hasil = 0
        var benar = 0
        var salah = 0
    }
}