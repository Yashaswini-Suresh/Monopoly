class GameEngine(private val players: List<Player>, private val board: Board) {
    private var currentPlayerIndex = 0

    fun nextTurn() {
        val player = players[currentPlayerIndex]
        val roll = Dice.roll()
        player.position = (player.position + roll) % board.tiles.size

        val tile = board.tiles[player.position]
        println("${player.name} rolled a $roll and landed on ${tile.name}")

        if (tile is PropertyTile && tile.owner == null) {
            if (player.money >= tile.cost) {
                player.money -= tile.cost
                tile.owner = player
                player.properties.add(tile)
                println("${player.name} bought ${tile.name}")
            }
        } else if (tile is PropertyTile && tile.owner != player) {
            player.money -= tile.rent
            tile.owner?.money = tile.owner?.money?.plus(tile.rent) ?: 0
            println("${player.name} paid rent to ${tile.owner?.name}")
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size
    }
}
