package pgm.poolp.blocages.game.players.skaven

import pgm.poolp.infinity.game.params.Skaven
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BlitzerSkaven : Skaven {
    override val name: String
        get() = Jobs.BLITZER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 4
    override val capacity: String?
        get() = Capacities.OFFENSIVE_SPECIALIST.description
    override val cardUrl: String
        get() = "blitzerskaven.png"
}