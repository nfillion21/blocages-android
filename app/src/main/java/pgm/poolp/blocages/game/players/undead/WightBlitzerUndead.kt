package pgm.poolp.blocages.game.players.undead

import pgm.poolp.infinity.game.params.Undead
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class WightBlitzerUndead : Undead {
    override val name: String
        get() = Jobs.WIGHT_BLITZER.description
    override val move: Int
        get() = 6
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 3
    override val capacity: String?
        get() = Capacities.OFFENSIVE_SPECIALIST.description
    override val cardUrl: String
        get() = "wightblitzerundead.png"
}
