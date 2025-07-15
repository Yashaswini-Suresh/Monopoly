class Board {
    val tiles: List<Tile> = List(40) { index ->
        when (index) {
            0 -> Tile("GO", 0)
            4 -> Tile("Income Tax", 4)
            10 -> Tile("Jail", 10)
            30 -> Tile("Go to Jail", 30)
            else -> PropertyTile("Property $index", index, 100 + (index * 10), 20 + (index * 2))
        }
    }
}
