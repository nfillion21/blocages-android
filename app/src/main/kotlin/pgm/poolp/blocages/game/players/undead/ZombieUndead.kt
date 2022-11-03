package pgm.poolp.blocages.game.players.undead

import pgm.poolp.blocages.game.params.Undead
import pgm.poolp.blocages.game.utils.Jobs

class ZombieUndead : Undead {
    override val name: String
        get() = Jobs.ZOMBIE.description
    override val move: Int
        get() = 4
    override val throwBall: Int
        get() = 6
    override val armour: Int
        get() = 3
    override val capacity: String?
        get() = null
    override val cardUrl: String
        get() = "zombieundead.png"
}
