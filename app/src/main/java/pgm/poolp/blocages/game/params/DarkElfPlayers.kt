package pgm.poolp.infinity.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class DarkElfPlayers {
    BLITZER,
    LINEMAN,
    RUNNER,
    WITCH_ELF
}
interface DarkElf : Player {
    override val icon: Int
        get() = R.drawable.darkelves

    override val race: String
        get() = "Dark Elf"
}
