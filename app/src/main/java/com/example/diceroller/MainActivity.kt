package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDice: Dice = Dice(6)
        findViewById<Button>(R.id.rollButton).setOnClickListener {
            myDice.roll()
            Toast.makeText(
                this,
                "You rolled ${myDice.currentRoll} and your previous was ${myDice.previousRoll}!",
                Toast.LENGTH_SHORT
            ).show()
            findViewById<TextView>(R.id.currentRoll).text = myDice.currentRoll.toString()
            val diceImage: ImageView = findViewById(R.id.diceImage)
            when (myDice.currentRoll) {
                1 -> diceImage.setImageResource(R.drawable.dice_1)
                2 -> diceImage.setImageResource(R.drawable.dice_2)
                3 -> diceImage.setImageResource(R.drawable.dice_3)
                4 -> diceImage.setImageResource(R.drawable.dice_4)
                5 -> diceImage.setImageResource(R.drawable.dice_5)
                6 -> diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    }
}

class Dice(val sides: Int) {
    public var currentRoll = 1
    public var previousRoll = 1

    fun roll() {
        previousRoll = currentRoll
        currentRoll = (1..sides).random()
    }
}