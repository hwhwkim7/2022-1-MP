package com.cookandroid.quiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pick.*

class PickActivity : AppCompatActivity() {
    lateinit var id : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)

        title = "선택"

        radioG.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.cat -> {
                    pickImage.setImageResource(R.drawable.cat)
                    id = "cat"
                }
                R.id.dog -> {
                    pickImage.setImageResource(R.drawable.dog)
                    id = "dog"
                }
                R.id.rabbit -> {
                    pickImage.setImageResource(R.drawable.rabbit)
                    id = "rabbit"
                }
            }
        }

        returnPick.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("ID", id)
            //아마 id에 null값 들어가는 듯
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }

    }
}