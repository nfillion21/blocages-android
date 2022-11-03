package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class HumanPlayers {
    BLITZER,
    CATCHER,
    LINEMAN,
    THROWER
}
interface Human : Player {
    override val icon: Int
        get() = R.drawable.humans

    override val race: String
        get() = "Human"
}
