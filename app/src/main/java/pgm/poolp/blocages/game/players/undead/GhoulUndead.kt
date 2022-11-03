package pgm.poolp.blocages.game.players.undead

import pgm.poolp.infinity.game.params.Undead
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class GhoulUndead : Undead {
    override val name: String
        get() = Jobs.GHOUL.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 4
    override val capacity: String?
        get() = Capacities.FLESH_HUNGRY_HORROR.description
    override val cardUrl: String
        get() = "ghoulundead.png"
}
