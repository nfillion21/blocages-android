package pgm.poolp.blocages.game.players.woodelves

import pgm.poolp.blocages.game.params.WoodElf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class WardancerWoodElf : WoodElf {
    override val name: String
        get() = Jobs.WARDANCER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.WARDANCE.description
    override val cardUrl: String
        get() = "wardancerwoodelf.png"
}