package com.yashaswini.monopolygame.engine

import com.monopolygame.data

class GameEngine(
    private val players: List<Player>,
    private val board: Board
) {
    private var currentPlayerI ndex = 0

    fun nextTurn(): String {
        val player = players[currentPlayerIndex]
        val roll = Dice.roll()
        player.position = (player.position + roll) % board.tiles.size
        val tile = board.tiles[player.position]

        val output = StringBuilder()
        output.append("${player.name} rolled a $roll and landed on ${tile.name}.\n")

        if (tile is PropertyTile) {
            when {
                tile.owner == null && player.money >= tile.cost -> {
                    player.money -= tile.cost
                    tile.owner = player
                    player.properties.add(tile)
                    output.append("${player.name} bought ${tile.name} for \$${tile.cost}.")
                }

                tile.owner != player -> {
                    player.money -= tile.rent
                    tile.owner?.money = tile.owner?.money?.plus(tile.rent) ?: 0
                    output.append("${player.name} paid \$${tile.rent} rent to ${tile.owner?.name}.")
                }

                tile.owner == player -> {
                    output.append("${player.name} landed on their own property.")
                }
            }
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size
        return output.toString()
    }
}
