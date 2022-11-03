package pgm.poolp.blocages.game.players.skaven

import pgm.poolp.blocages.game.params.Skaven
import pgm.poolp.blocages.game.utils.Jobs

class LinemanSkaven : Skaven {
    override val name: String
        get() = Jobs.LINEMAN.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "linemanskaven.png"
}