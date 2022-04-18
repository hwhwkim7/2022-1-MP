package com.cookandroid.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calc.*

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        title = "계산기"

        var nums = arrayOf(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9)
        var calcs = arrayOf(add, sub, mul, div)
        var num1 = ""
        var num2 = ""
        var op = ""

        returnCalc.setOnClickListener {
            finish()
        }

        clear.setOnClickListener {
            equation.setText("")
            equation.setHint("Equation")
            num1 = ""
            num2 = ""
            op = ""
        }

        result.setOnClickListener {
            var tmp = equation.text.toString().split(" ")
            num1 = tmp[(tmp.size)-3]
            num2 = tmp[(tmp.size)-1]
            when(op) {
                " + " -> equation.text = equation.text.toString() + " = ${num1.toInt()+num2.toInt()}"
                " - " -> equation.text = equation.text.toString() + " = ${num1.toInt()-num2.toInt()}"
                " * " -> equation.text = equation.text.toString() + " = ${num1.toInt()*num2.toInt()}"
                " / " -> equation.text = equation.text.toString() + " = ${num1.toInt()/num2.toInt()}"
            }
        }

        for(btnNum in nums) {
            btnNum.setOnClickListener {
                equation.text = equation.text.toString() + btnNum.text.toString()
            }
        }

        for(btnCalc in calcs) {
            btnCalc.setOnClickListener {
                equation.text = equation.text.toString() + btnCalc.text.toString()
                op = btnCalc.text.toString()
            }
        }
    }
}