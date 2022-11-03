package pgm.poolp.blocages.game.players.chaos

import pgm.poolp.blocages.game.params.Chaos
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BlockerChaos : Chaos {
    override val name: String
        get() = Jobs.BLOCKER.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 3
    override val capacity: String?
        get() = Capacities.INDOMITABLE.description
    override val cardUrl: String
        get() = "blockerchaos.png"
}