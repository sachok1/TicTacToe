package com.example.chuprovkirillisp191ramalloh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Field

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var player = "X"
    private val game: Game = GameImp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1_1).setOnClickListener(this)
        findViewById<Button>(R.id.button1_2).setOnClickListener(this)
        findViewById<Button>(R.id.button1_3).setOnClickListener(this)
        findViewById<Button>(R.id.button2_1).setOnClickListener(this)
        findViewById<Button>(R.id.button2_2).setOnClickListener(this)
        findViewById<Button>(R.id.button2_3).setOnClickListener(this)
        findViewById<Button>(R.id.button3_1).setOnClickListener(this)
        findViewById<Button>(R.id.button3_2).setOnClickListener(this)
        findViewById<Button>(R.id.button3_3).setOnClickListener(this)
        findViewById<Button>(R.id.restart).setOnClickListener{
            findViewById<Button>(R.id.button1_1).text = ""
            findViewById<Button>(R.id.button2_1).text = ""
            findViewById<Button>(R.id.button2_2).text = ""
            findViewById<Button>(R.id.button2_3).text = ""
            findViewById<Button>(R.id.button3_1).text = ""
            findViewById<Button>(R.id.button3_2).text = ""
            findViewById<Button>(R.id.button1_2).text = ""
            findViewById<Button>(R.id.button1_3).text = ""
            findViewById<Button>(R.id.button3_3).text = ""
            player = "X"
        }
    }

    override fun onClick(v: View) {
        if ((v as Button).text === "") {
            (v as Button).text = player
            if (player === "X") {
                player = "0"
            }
            else {
                player = "X"
            }
        }
    }
}

