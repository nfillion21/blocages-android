package pgm.poolp.blocages.game.players.dwarves

import pgm.poolp.blocages.game.params.Dwarf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class TrollSlayerDwarf : Dwarf {
    override val name: String
        get() = Jobs.TROLL_SLAYER.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 5
    override val armour: Int
        get() = 4
    override val capacity: String?
        get() = Capacities.FRENZIED.description
    override val cardUrl: String
        get() = "trollslayerdwarf.png"
}
