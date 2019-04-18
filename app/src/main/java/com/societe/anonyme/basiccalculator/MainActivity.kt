package com.societe.anonyme.basiccalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Calc(v: View){
        //relate the XML with kotlin code
        val n1 = findViewById<EditText>(R.id.ednum1)as EditText
        val n2 = findViewById<EditText>(R.id.ednum2)as EditText
        val res = findViewById<TextView>(R.id.result)as TextView
        //Variable to save number from EditText
        val number1 : Float
        val number2 : Float
        val result : Float
        //verify that The user enter some number
        if(TextUtils.isEmpty(n1.text.toString())){
            n1.error= "Entrer Some Number ..."
            return
        }else{
            number1 = n1.text.toString().toFloat()
        }
        if(TextUtils.isEmpty(n2.text.toString())){
            n2.error= "Entrer Some Number ..."
            return
        }else{
            number2 = n2.text.toString().toFloat()
        }

        when(v.id){
            //Check the id of button to make the appropriate operation
            R.id.btnplus -> {
                result = number1+number2
                res.text = result.toString()
            }
            R.id.btnmines -> {
                result = number1-number2
                res.text = result.toString()
            }
            R.id.btnmultiple -> {
                result = number1*number2
                res.text = result.toString()
            }
            R.id.btndivide -> {
                if (number2 == 0.0F){
                    Toast.makeText(this@MainActivity,"Divide By Zero Error",Toast.LENGTH_SHORT).show()
                }else{
                    result = number1/number2
                    res.text = result.toString()

                }
            }
        }
    }
}
