package pgm.poolp.blocages.game.players.undead

import pgm.poolp.infinity.game.params.Undead
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class MummyUndead : Undead {
    override val name: String
        get() = Jobs.MUMMY.description
    override val move: Int
        get() = 3
    override val throwBall: Int
        get() = 6
    override val armour: Int
        get() = 2
    override val capacity: String?
        get() = Capacities.UNDEAD_JUGGERNAUT.description
    override val cardUrl: String
        get() = "mummyundead.png"
}
