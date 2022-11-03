package pgm.poolp.blocages.game.players.lizardmen

import pgm.poolp.infinity.game.params.Lizardmen
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class ChameleonSkinkLizardmen : Lizardmen {
    override val name: String
        get() = Jobs.CHAMELEON_SKINK.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.CANNY_TRACKER.description
    override val cardUrl: String
        get() = "chameleonskinklizardmen.png"
}