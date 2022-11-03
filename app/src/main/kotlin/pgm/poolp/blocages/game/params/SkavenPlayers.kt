package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class SkavenPlayers {
    BLITZER,
    GUTTER_RUNNER,
    LINEMAN,
    THROWER
}
interface Skaven : Player {
    override val icon: Int
        get() = R.drawable.skaven

    override val race: String
        get() = "Skaven"
}
