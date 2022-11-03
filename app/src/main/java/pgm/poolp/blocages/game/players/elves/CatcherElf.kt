package pgm.poolp.blocages.game.players.elves

import pgm.poolp.infinity.game.params.Elf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class CatcherElf : Elf {
    override val name: String
        get() = Jobs.CATCHER.description
    override val move : Int
        get() = 7
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 6
    override val capacity: String?
        get() = Capacities.CATCHERS_INSTINCT.description
    override val cardUrl: String
        get() = "catcherelf.png"
}