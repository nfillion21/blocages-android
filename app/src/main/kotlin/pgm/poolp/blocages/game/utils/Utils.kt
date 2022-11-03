package pgm.poolp.blocages.game.utils

object Utils {
    const val baseImagesUrl:String = "https://www.ug-data.xyz/infinity/images/"
}

enum class Capacities(val description:String) {
    CATCHERS_INSTINCT("Catcher's instincts. If this player catches a thrown ball (not a hand-off or bouncing ball), roll a six-sided dice. This player can make a free Run action up to that many squares."),
    HEADBUTT("Headbutt. If this player makes a Mark action and they have already made a Run action this turn, they can immediately make a free Block action."),
    INDOMITABLE("Indomitable. This player cannot be Knocked Down. If this player would be, and this player is carrying the ball, the ball bounces. Then, make an Armour check for this player - if it is passed, there is no further effect. If it is failed, this player is injured."),
    OFFENSIVE_SPECIALIST("Offensive specialist. Whenever this player makes a Block action, their coach can choose to re-roll the dice."),
    SAFE_HANDS("Safe hands. If this player is Knocked Down while holding the ball, you can choose which adjacent square the ball bounces into instead of rolling the eight-sided dice."),
    FRENZIED("Frenzied. After this player makes a Mark action, they can immediately make a free Block action."),
    HANDLING_SKILLS("Handling skills. Whenever this player moves into a square containing the ball, they pick it up as though they were making a Run action."),
    WARDANCE("Wardance. When this player makes a Run action, they can move adjacent to opponents, but doing so ends the action."),
    SMALL_AND_SHIFTY("Small and shifty. When this player makes a Run action they can move adjacents to opponents, but must end the action Openm not Marked."),
    VERY_WELL_FED("Very well fed. In your turn, if this player is on the pitch, this player can make one free Block or Mark action."),
    QUANTITY_OVER_QUALITY("Quantity over quality. In your turn, if this player is on the pitchm this player can make one free Block or Mark action."),
    SLIPPERY_LITTLE_RUNT("Slippery little runt. When this player is the target of a Block action, and the result of that Block is a Miss, Shove or Tackle, their coach can choose to ignore the result and this player can make a free Sidestep action."),
    CANNY_TRACKER("Canny tracker. The first time in a turn that an opponent adjacent to this player makes a Sidestep action, this player can be moved into the square that opponent moved from."),
    HULKING_BRUTE("Hulking brute. All Block actions made by this player count as having an assist."),
    FLIGHTY("Flighty. This player can move up to two squares instead of one when they make the Sidestep action. They must finish this move Open, not Marked."),
    FLESH_HUNGRY_HORROR("Flesh-hungry horror. When this player makes a Mark action, they can move up to 3 squares instead of 2."),
    UNDEAD_JUGGERNAUT("Undead juggernaut. If this player makes a Mark action, treat the Shove result as the Knocked Down result for the next block this player makes this turn."),
    IMMOVABLE_BULK("Immovable bulk. If this player is the target of a Block action, the Shove result is treated as the Miss result."),
    SNEAKY_STABBER("Sneaky stabber. If this player makes a Block action with an assist, roll a six-sided dice as well as the two Block dice. If that dice roll is a 6, the target is automatically injured - do not resolve the block.")
}

enum class Jobs (val description: String) {
    BEASTMAN_RUNNER("Beastman runner"),
    BLOCKER("Blocker"),
    BLITZER("Blitzer"),
    LINEMAN("Lineman"),
    RUNNER("Runner"),
    WITCH_ELF("Witch elf"),
    TROLL_SLAYER("Troll slayer"),
    CATCHER("Catcher"),
    THROWER("Thrower"),
    WARDANCER("Wardancer"),
    HEFTY("Hefty"),
    HOPEFUL("Hopeful"),
    CHAMELEON_SKINK("Chameleon skink"),
    SAURUS_BLOCKER("Saurus blocker"),
    SKINK_RUNNER("Skink runner"),
    GHOUL("Ghoul"),
    MUMMY("Mummy"),
    SKELETON("Skeleton"),
    WIGHT_BLITZER("Wight blitzer"),
    ZOMBIE("Zombie"),
    BLOATER("Bloater"),
    PESTIGOR("Pestigor"),
    ROTTER("Rotter"),
    BLACK_ORC_BLOCKER("Black orc blocker"),
    GUTTER_RUNNER("Gutter runner")
}