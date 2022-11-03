package pgm.poolp.blocages.game.players.dwarves

import pgm.poolp.infinity.game.params.Dwarf
import pgm.poolp.blocages.game.utils.Jobs

class LinemanDwarf : Dwarf {
    override val name: String
        get() = Jobs.LINEMAN.description
    override val move: Int
        get() = 4
    override val throwBall: Int
        get() = 5
    override val armour: Int
        get() = 2
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "linemandwarf.png"
}
