package pgm.poolp.blocages.game.players.humans

import pgm.poolp.blocages.game.params.Human
import pgm.poolp.blocages.game.utils.Jobs

class LinemanHuman : Human {
    override val name: String
        get() = Jobs.LINEMAN.description
    override val move: Int
        get() = 6
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 4
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "linemanhuman.png"
}