package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class OrcPlayers {
    BLACK_ORC_BLOCKER,
    BLITZER,
    LINEMAN,
    THROWER
}
interface Orc : Player {
    override val icon: Int
        get() = R.drawable.orcs

    override val race: String
        get() = "Orc"
}
