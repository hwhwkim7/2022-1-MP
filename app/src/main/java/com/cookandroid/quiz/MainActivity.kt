package com.cookandroid.quiz

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "수시 1"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.cal -> {
                var intent = Intent(applicationContext, CalcActivity::class.java)
                startActivity(intent)
            }
            R.id.pick -> {
                intent = Intent(applicationContext, PickActivity::class.java)
                startActivityForResult(intent, 0)
            }
            R.id.end -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            var id = data!!.getStringExtra("ID")

            when(id) {
                "cat" -> mainImage.setImageResource(R.drawable.cat)
                "dog" -> mainImage.setImageResource(R.drawable.dog)
                "rabbit" -> mainImage.setImageResource(R.drawable.rabbit)
            }
        }
    }
}