package pgm.poolp.blocages.game.players.elves

import pgm.poolp.infinity.game.params.Elf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class ThrowerElf : Elf {
    override val name: String
        get() = Jobs.THROWER.description
    override val move : Int
        get() = 6
    override val throwBall: Int
        get() = 2
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.HANDLING_SKILLS.description
    override val cardUrl: String
        get() = "throwerelf.png"
}