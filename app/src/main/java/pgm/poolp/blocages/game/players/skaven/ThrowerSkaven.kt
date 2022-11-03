package pgm.poolp.blocages.game.players.skaven

import pgm.poolp.infinity.game.params.Skaven
import pgm.poolp.blocages.game.utils.Capacities
import pgm.poolp.blocages.game.utils.Jobs

class ThrowerSkaven : Skaven {
    override val name: String
        get() = Jobs.THROWER.description
    override val move: Int
        get() = 7
    override val throwBall: Int
        get() = 3
    override val armour: Int
        get() = 5
    override val capacity: String?
        get() = Capacities.HANDLING_SKILLS.description
    override val cardUrl: String
        get() = "throwerskaven.png"
}