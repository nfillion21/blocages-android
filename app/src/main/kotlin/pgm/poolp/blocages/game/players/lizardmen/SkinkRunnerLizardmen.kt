package pgm.poolp.blocages.game.players.lizardmen

import pgm.poolp.blocages.game.params.Lizardmen
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class SkinkRunnerLizardmen : Lizardmen {
    override val name: String
        get() = Jobs.SKINK_RUNNER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 4
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.FLIGHTY.description
    override val cardUrl: String
        get() = "skinkrunnerlizardmen.png"
}