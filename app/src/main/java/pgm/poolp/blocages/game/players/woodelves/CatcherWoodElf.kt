package pgm.poolp.blocages.game.players.woodelves

import pgm.poolp.blocages.game.params.WoodElf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class CatcherWoodElf : WoodElf {
    override val name: String
        get() = Jobs.CATCHER.description
    override val move: Int
        get() = 8
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 6
    override val capacity: String?
        get() = Capacities.CATCHERS_INSTINCT.description
    override val cardUrl: String
        get() = "catcherwoodelf.png"
}
