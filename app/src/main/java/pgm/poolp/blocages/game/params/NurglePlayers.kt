package pgm.poolp.infinity.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class NurglePlayers {
    BLOATER,
    PESTIGOR,
    ROTTER
}
interface Nurgle : Player {
    override val icon: Int
        get() = R.drawable.nurgle

    override val race: String
        get() = "Nurgle"
}
