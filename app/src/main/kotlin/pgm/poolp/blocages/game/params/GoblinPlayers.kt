package pgm.poolp.blocages.game.params

import pgm.poolp.blocages.R
import pgm.poolp.blocages.game.interfaces.Player

enum class GoblinPlayers {
    LINEMAN
}
interface Goblin : Player {
    override val icon: Int
        get() = R.drawable.goblins

    override val race: String
        get() = "Goblin"
}
