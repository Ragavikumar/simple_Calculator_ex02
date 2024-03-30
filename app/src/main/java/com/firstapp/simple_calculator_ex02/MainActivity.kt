package com.firstapp.simple_calculator_ex02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val add:Button = findViewById(R.id.add)
        val sub:Button = findViewById(R.id.sub)
        val mul:Button = findViewById(R.id.mul)
        val div:Button = findViewById(R.id.div)
        val mod:Button = findViewById(R.id.mod)

        val clr:Button = findViewById(R.id.clr)
        val n1:EditText = findViewById(R.id.t1)
        val n2:EditText = findViewById(R.id.t2)
        val res:TextView = findViewById(R.id.result)

        add.setOnClickListener {
            val result = n1.text.toString().toDouble() + n2.text.toString().toDouble()
            res.text = "Result: $result"
        }
        sub.setOnClickListener {
            val result = n1.text.toString().toDouble() - n2.text.toString().toDouble()
            res.text = "Result: $result"
        }
        mul.setOnClickListener {
            val result = n1.text.toString().toDouble() * n2.text.toString().toDouble()
            res.text = "Result: $result"
        }
        div.setOnClickListener {
            val divisor = n1.text.toString().toDouble()
            if (divisor != 0.0) {
                val result = n2.text.toString().toDouble() / divisor
                res.text = "Result: $result"
            } else {
                res.text = "Cannot divide by zero"
            }
        }
        mod.setOnClickListener {
            val result = n1.text.toString().toDouble() % n2.text.toString().toDouble()
            res.text = "Result: $result"
        }
        clr.setOnClickListener {
            res.text = null
            n1.text = null
            n2.text = null
        }
    }
}