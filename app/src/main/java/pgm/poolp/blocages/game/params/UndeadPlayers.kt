package pgm.poolp.infinity.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class UndeadPlayers {
    GHOUL,
    MUMMY,
    SKELETON,
    WIGHT_BLITZER,
    ZOMBIE
}
interface Undead : Player {
    override val icon: Int
        get() = R.drawable.undead

    override val race: String
        get() = "Undead"
}
