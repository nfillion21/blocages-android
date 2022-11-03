package pgm.poolp.blocages.game.players.orcs

import pgm.poolp.infinity.game.params.Orc
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class BlackOrcBlockerOrc : Orc {
    override val name: String
        get() = Jobs.BLACK_ORC_BLOCKER.description
    override val move: Int
        get() = 4
    override val throwBall: Int
        get() = 5
    override val armour: Int
        get() = 2
    override val capacity: String?
        get() = Capacities.HULKING_BRUTE.description
    override val cardUrl: String
        get() = "blackorcblockerorc.png"
}