package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class WoodElfPlayers {
    CATCHER,
    LINEMAN,
    THROWER,
    WARDANCER
}
interface WoodElf : Player {
    override val icon: Int
        get() = R.drawable.woodelves

    override val race: String
        get() = "Wood Elf"
}
