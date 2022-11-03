package pgm.poolp.blocages.game.players.dwarves

import pgm.poolp.infinity.game.params.Dwarf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BlitzerDwarf : Dwarf {
    override val name: String
        get() = Jobs.BLITZER.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 5
    override val armour: Int
        get() = 2
    override val capacity: String?
        get() = Capacities.OFFENSIVE_SPECIALIST.description
    override val cardUrl: String
        get() = "blitzerdwarf.png"
}
