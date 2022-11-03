package pgm.poolp.blocages.game.players.halflings

import pgm.poolp.blocages.game.params.Halfling
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class HeftyHalfling : Halfling {
    override val name: String
        get() = Jobs.HEFTY.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.VERY_WELL_FED.description
    override val cardUrl: String
        get() = "heftyhalfling.png"
}
