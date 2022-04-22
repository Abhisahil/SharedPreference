package com.example.sharedprefrencedemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRememberd = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRememberd = sharedPreferences.getBoolean("CHEKBOX", false)


        if (isRememberd) {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
        login.setOnClickListener{
            val name:String=nameEt.text.toString()
            val age:String= ageEt.text.toString()
            val checked:Boolean=CheckBox.isChecked()


            val editor:SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putString("AGE",age)
            editor.putBoolean("CHEKBOX",checked)
            editor.apply()

            Toast.makeText(this,"information saved",
            Toast.LENGTH_LONG).show()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}

