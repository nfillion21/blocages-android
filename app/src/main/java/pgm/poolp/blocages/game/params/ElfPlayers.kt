package pgm.poolp.infinity.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class ElfPlayers {
    BLITZER,
    CATCHER,
    LINEMAN,
    THROWER
}
interface Elf : Player {
    override val icon: Int
        get() = R.drawable.elves

    override val race: String
        get() = "Elf"
}
