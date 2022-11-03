package pgm.poolp.infinity.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class LizardmenPlayers {
    CHAMELEON_SKINK,
    SAURUS_BLOCKER,
    SKINK_RUNNER
}
interface Lizardmen : Player {
    override val icon: Int
        get() = R.drawable.lizardmen

    override val race: String
        get() = "Lizardmen"
}
