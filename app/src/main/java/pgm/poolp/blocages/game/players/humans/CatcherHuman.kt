package pgm.poolp.blocages.game.players.humans

import pgm.poolp.infinity.game.params.Human
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class CatcherHuman : Human {
    override val name: String
        get() = Jobs.CATCHER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.CATCHERS_INSTINCT.description
    override val cardUrl: String
        get() = "catcherhuman.png"
}