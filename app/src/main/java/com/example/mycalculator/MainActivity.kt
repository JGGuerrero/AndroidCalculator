package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.mycalculator.databinding.ActivityMainBinding
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {

//    private var strNumber = StringBuilder()
//    private lateinit var numberButtons: Array<Button>

    var lastNumeric: Boolean = false
    var lastDot: Boolean = false
    var isPositive: Boolean = true

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        binding.tvResult.text = ""

//        numberButtons = arrayOf(binding.button1, binding.button2, binding.button3, binding.button4, binding.button5, binding.button6, binding.button7, binding.button8, binding.button9)
//        for (i in numberButtons){
//            i.setOnClickListener { numberButtonClicked(i) }
//        }
//        binding.button1.setOnClickListener { button1Clicked() }
//        binding.button2.setOnClickListener { button2Clicked() }



    }

//    private fun button2Clicked() {
//        strNumber.append("2")
//        binding.tvResult.text = strNumber
//    }

//    private fun numberButtonClicked(num: Button) {
//        strNumber.append(num.text)
//        binding.tvResult.text = strNumber
//    }


    fun onDigit(view: View){
        binding.tvResult.append((view as Button).text)
        lastNumeric = true

    }

    fun onClear(view: View){
        binding.tvResult.text = ""
        lastDot = false
        lastNumeric = false
    }

    fun onDecimalPoint(view: View) {
        if (!lastDot) {
            binding.tvResult.append((view as Button).text)
            lastDot = true

        }
    }

    fun onNegative(view: View){
        if (isPositive && !lastNumeric) {
            binding.tvResult.append("-")
            lastNumeric = true
            isPositive = false
        }


    }

    fun onOperator(view: View){
        if (lastNumeric && !isOperatorAdded(binding.tvResult.text.toString())) {
            binding.tvResult.append((view as Button).text)
            lastNumeric = false

        }
    }

    private fun isOperatorAdded(value: String) : Boolean{
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("-") || value.contains("+")
        }
    }

}