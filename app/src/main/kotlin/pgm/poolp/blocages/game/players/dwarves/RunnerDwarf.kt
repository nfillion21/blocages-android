package pgm.poolp.blocages.game.players.dwarves

import pgm.poolp.blocages.game.params.Dwarf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class RunnerDwarf : Dwarf {
    override val name: String
        get() = Jobs.RUNNER.description
    override val move: Int
        get() = 6
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 3
    override val capacity: String?
        get() = Capacities.SAFE_HANDS.description
    override val cardUrl: String
        get() = "runnerdwarf.png"
}
