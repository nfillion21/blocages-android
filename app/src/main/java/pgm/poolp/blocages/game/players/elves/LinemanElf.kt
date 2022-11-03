package pgm.poolp.blocages.game.players.elves

import pgm.poolp.infinity.game.params.Elf
import pgm.poolp.blocages.game.utils.Jobs

class LinemanElf : Elf {
    override val name: String
        get() = Jobs.LINEMAN.description
    override val move : Int
        get() = 6
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "linemanelf.png"
}