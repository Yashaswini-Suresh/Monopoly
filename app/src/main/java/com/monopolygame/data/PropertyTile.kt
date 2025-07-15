class PropertyTile(
    name: String,
    position: Int,
    val cost: Int,
    val rent: Int,
    var owner: Player? = null
) : Tile(name, position)
