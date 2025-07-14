 package com.yashaswinimonopolygame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yashaswinimonopolygame.ui.theme.MonopolyGameTheme

 class MainActivity : AppCompatActivity() {

     private lateinit var game: GameEngine

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val players = listOf(Player("Player 1"), Player("Player 2"))
         val board = Board()
         game = GameEngine(players, board)

         val rollButton = findViewById<Button>(R.id.rollButton)
         val textView = findViewById<TextView>(R.id.textView)

         rollButton.setOnClickListener {
             game.nextTurn()
             textView.text = "Turn completed. Check logs for actions."
         }
     }
 }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MonopolyGameTheme {
        Greeting("Android")
    }
}