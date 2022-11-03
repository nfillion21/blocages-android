package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class HalflingPlayers {
    HEFTY,
    HOPEFUL,
    RUNNER
}
interface Halfling : Player {
    override val icon: Int
        get() = R.drawable.halflings

    override val race: String
        get() = "Halfling"
}
