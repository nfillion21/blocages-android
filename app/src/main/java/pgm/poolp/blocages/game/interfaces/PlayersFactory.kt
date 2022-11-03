package pgm.poolp.blocages.game.interfaces

interface PlayersFactory<in T, out P> where T : Enum<*>, P: Player {
    fun build(type: T) : P
    fun randomPlayer() : P
}