package com.yashaswini.monopolygame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yashaswini.monopolygame.data.Board
import com.yashaswini.monopolygame.data.Player
import com.yashaswini.monopolygame.engine.GameEngine

class MainActivity : AppCompatActivity() {

    private lateinit var gameEngine: GameEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val players = listOf(Player("Player 1"), Player("Player 2"))
        val board = Board()
        gameEngine = GameEngine(players, board)

        val rollButton = findViewById<Button>(R.id.rollButton)
        val gameText = findViewById<TextView>(R.id.textView)

        rollButton.setOnClickListener {
            val result = gameEngine.nextTurn()
            gameText.text = result
        }
    }
}
