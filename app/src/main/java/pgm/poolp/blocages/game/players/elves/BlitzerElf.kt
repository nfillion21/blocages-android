package pgm.poolp.blocages.game.players.elves

import pgm.poolp.infinity.game.params.Elf
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BlitzerElf : Elf {
    override val name: String
        get() = Jobs.BLITZER.description
    override val move : Int
        get() = 6
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.OFFENSIVE_SPECIALIST.description
    override val cardUrl: String
        get() = "blitzerelf.png"
}