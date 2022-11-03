package pgm.poolp.blocages.game.players.orcs

import pgm.poolp.blocages.game.params.Orc
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BlitzerOrc : Orc {
    override val name: String
        get() = Jobs.BLITZER.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 3
    override val capacity: String?
        get() = Capacities.OFFENSIVE_SPECIALIST.description
    override val cardUrl: String
        get() = "blitzerorc.png"
}