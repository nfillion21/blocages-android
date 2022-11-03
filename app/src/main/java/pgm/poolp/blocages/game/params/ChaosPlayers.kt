package pgm.poolp.infinity.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class ChaosPlayers {
    BEASTMAN_RUNNER,
    BLOCKER
}
interface Chaos : Player {
    override val icon: Int
        get() = R.drawable.chaos

    override val race: String
        get() = "Chaos"
}
