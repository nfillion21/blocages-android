package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class DwarfPlayers {
    BLITZER,
    LINEMAN,
    RUNNER,
    TROLL_SLAYER
}
interface Dwarf : Player {
    override val icon: Int
        get() = R.drawable.dwarves

    override val race: String
        get() = "Dwarf"
}