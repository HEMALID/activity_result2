package com.example.result_activity1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var txt: TextView?=null
    var No1:EditText?=null
    var No2:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt=findViewById(R.id.txt)
        No1=findViewById(R.id.edNo1)
        No2=findViewById(R.id.edNo2)

        var btnsend=findViewById<Button>(R.id.btnSend)
        btnsend.setOnClickListener {
            if(No1?.text.toString().equals(" ") || (No2?.text.toString().equals(" "))){
                Toast.makeText(applicationContext,"Plase insert Number",Toast.LENGTH_LONG).show()
            }
            else
            {
                var No1 = Integer.parseInt(No1?.text.toString())
                var No2 = Integer.parseInt(No2?.text.toString())

                var i = Intent(applicationContext,ResualtActivity::class.java)
                i.putExtra("No1",No1)
                i.putExtra("No2",No2)
                startActivityForResult(i,1)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( requestCode == 1  ){
            if( resultCode == RESULT_OK  ){
                var res = data?.getIntExtra("Result",0)
                txt?.text = res.toString()

            }
            if( resultCode == RESULT_CANCELED ){
                Toast.makeText(applicationContext," Nothing selected ",Toast.LENGTH_LONG).show()
            }
        }

    }
}