package pgm.poolp.blocages.game.players.woodelves

import pgm.poolp.blocages.game.params.WoodElf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class ThrowerWoodElf : WoodElf {
    override val name: String
        get() = Jobs.THROWER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 2
    override val armour: Int
        get() = 6
    override val capacity: String?
        get() = Capacities.HANDLING_SKILLS.description
    override val cardUrl: String
        get() = "throwerwoodelf.png"
}