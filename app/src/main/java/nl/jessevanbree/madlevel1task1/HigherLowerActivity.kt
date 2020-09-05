package nl.jessevanbree.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nl.jessevanbree.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    fun initViews() {
        binding.lowerButton.setOnClickListener { onLowerClick() }
        binding.equalsButton.setOnClickListener { onEqualClick() }
        binding.higherButton.setOnClickListener { onHigherClick() }
        updateUI()
    }

    fun updateUI() {
        binding.tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> binding.diceImage.setImageResource(R.drawable.dice1)
            2 -> binding.diceImage.setImageResource(R.drawable.dice2)
            3 -> binding.diceImage.setImageResource(R.drawable.dice3)
            4 -> binding.diceImage.setImageResource(R.drawable.dice4)
            5 -> binding.diceImage.setImageResource(R.drawable.dice5)
            6 -> binding.diceImage.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if(currentThrow > lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if(currentThrow < lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()
        if(currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerIncorrect() {
        binding.tvFeedback.text = getString(R.string.incorrect_guess)
    }

    private fun onAnswerCorrect() {
        binding.tvFeedback.text = getString(R.string.correct_guess)
    }
}