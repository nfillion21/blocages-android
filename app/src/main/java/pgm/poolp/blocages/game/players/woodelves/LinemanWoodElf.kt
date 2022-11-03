package pgm.poolp.blocages.game.players.woodelves

import pgm.poolp.blocages.game.params.WoodElf
import pgm.poolp.blocages.game.utils.Jobs

class LinemanWoodElf : WoodElf {
    override val name: String
        get() = Jobs.LINEMAN.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 6
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "linemanwoodelf.png"
}
