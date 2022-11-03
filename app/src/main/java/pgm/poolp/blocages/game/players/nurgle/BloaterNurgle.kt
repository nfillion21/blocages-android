package pgm.poolp.blocages.game.players.nurgle

import pgm.poolp.infinity.game.params.Nurgle
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BloaterNurgle : Nurgle {
    override val name: String
        get() = Jobs.BLOATER.description
    override val move: Int
        get() = 4
    override val throwBall: Int
        get() = 5
    override val armour: Int
        get() = 2
    override val capacity: String?
        get() = Capacities.IMMOVABLE_BULK.description
    override val cardUrl: String
        get() = "bloaternurgle.png"
}