package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Roll the dice when the app starts
        rollDice()
    }

    /**
     * Create a private function that creates an object instance of Dice with
     * sides set to 6. Call the 'roll' function in the class 'Dice' and save the result
     * into 'diceRoll'
     *
     * The result is displayed with 'resultTextView'
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}

/**
 * Create a Dice class that has a roll method for generating the random
 * number simulating a dice roll
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
