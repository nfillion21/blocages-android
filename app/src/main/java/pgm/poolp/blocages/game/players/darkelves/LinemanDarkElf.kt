package pgm.poolp.blocages.game.players.darkelves

import pgm.poolp.infinity.game.params.DarkElf
import pgm.poolp.blocages.game.utils.Jobs

class LinemanDarkElf : DarkElf {
    override val name: String
        get() = Jobs.LINEMAN.description
    override val move: Int
        get() = 6
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 4
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "linemandarkelf.png"
}
