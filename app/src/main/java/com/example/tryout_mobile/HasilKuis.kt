package com.example.tryout_mobile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView


class HasilKuis : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hasil_kuis)
        val hasil = findViewById<View>(R.id.hasil) as TextView
        val nilai = findViewById<View>(R.id.nilai) as TextView
        hasil.text = """
            Jawaban Benar :${MainActivity.benar}
            Jawaban Salah :${MainActivity.salah}
            """.trimIndent()
        nilai.text = "" + MainActivity.hasil
    }

    fun ulangi(view: View?) {
        finish()
        val a = Intent(applicationContext, MainActivity::class.java)
        startActivity(a)
    }
}