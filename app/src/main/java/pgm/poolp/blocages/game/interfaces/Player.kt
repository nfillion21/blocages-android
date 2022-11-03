package pgm.poolp.blocages.game.interfaces

interface Player {
    val name : String
    val move : Int
    val throwBall : Int
    val armour : Int
    val capacity : String?
    val icon: Int
    val race: String
    val cardUrl: String
}