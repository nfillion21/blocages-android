package pgm.poolp.blocages.game.players.halflings

import pgm.poolp.infinity.game.params.Halfling
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class HopefulHalfling : Halfling {
    override val name: String
        get() = Jobs.HOPEFUL.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 6
    override val capacity: String?
        get() = Capacities.QUANTITY_OVER_QUALITY.description
    override val cardUrl: String
        get() = "hopefulhalfling.png"
}