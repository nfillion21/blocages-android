package pgm.poolp.blocages.game.players.darkelves

import pgm.poolp.blocages.game.params.DarkElf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class RunnerDarkElf : DarkElf {
    override val name: String
        get() = Jobs.RUNNER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 4
    override val capacity: String?
        get() = Capacities.SAFE_HANDS.description
    override val cardUrl: String
        get() = "runnerdarkelf.png"
}
