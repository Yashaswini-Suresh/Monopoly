import kotlin.random.Random

object Dice {
    fun roll(): Int = Random.nextInt(1, 7)
}
