package pgm.poolp.blocages.game.players.lizardmen

import pgm.poolp.infinity.game.params.Lizardmen
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class SaurusBlockerLizardmen : Lizardmen {
    override val name: String
        get() = Jobs.SAURUS_BLOCKER.description
    override val move: Int
        get() = 5
    override val throwBall: Int
        get() = 6
    override val armour: Int
        get() = 2
    override val capacity: String?
        get() = Capacities.HULKING_BRUTE.description
    override val cardUrl: String
        get() = "saurusblockerlizardmen.png"
}