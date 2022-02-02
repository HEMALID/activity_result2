package com.example.result_activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResualtActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resualt)

        var i =intent

        var no1 = intent.getIntExtra("No1",0)
        var no2 = intent.getIntExtra("No2",0)

        var txt = findViewById<TextView>(R.id.txt)
        txt.setText("No: "+ no1 + " " + no2)

        var btn1=findViewById<Button>(R.id.btn)
        btn1.setOnClickListener {

            var res = no1+no2

            var i=Intent(applicationContext,MainActivity::class.java)
            i.putExtra("Result",res)
            setResult(RESULT_OK, i)
            finish()

        }

        var btn2=findViewById<Button>(R.id.btn1)
        btn2.setOnClickListener {

            var res = no1-no2

            val i=Intent(applicationContext,MainActivity::class.java)
            i.putExtra("Result", res)
            setResult(RESULT_OK, i)
            finish()

        }

    }
}