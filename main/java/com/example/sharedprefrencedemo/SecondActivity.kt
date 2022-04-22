package com.example.sharedprefrencedemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    lateinit var preferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        preferences=getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        val name=preferences.getString("NAME","")
        nameTv.text=name

        val age=preferences.getString("AGE","")
        ageTv.text=age

        logout.setOnClickListener {
            val editor:SharedPreferences.Editor=preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}
