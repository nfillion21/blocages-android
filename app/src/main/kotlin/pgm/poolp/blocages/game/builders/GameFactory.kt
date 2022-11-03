package pgm.poolp.blocages.game.builders

import pgm.poolp.blocages.game.interfaces.Player
import pgm.poolp.blocages.game.interfaces.PlayersFactory
import pgm.poolp.blocages.game.params.*
import pgm.poolp.blocages.game.players.chaos.BeastmanRunnerChaos
import pgm.poolp.blocages.game.players.chaos.BlockerChaos
import pgm.poolp.blocages.game.players.darkelves.BlitzerDarkElf
import pgm.poolp.blocages.game.players.darkelves.LinemanDarkElf
import pgm.poolp.blocages.game.players.darkelves.RunnerDarkElf
import pgm.poolp.blocages.game.players.darkelves.WitchElfDarkElf
import pgm.poolp.blocages.game.players.dwarves.BlitzerDwarf
import pgm.poolp.blocages.game.players.dwarves.LinemanDwarf
import pgm.poolp.blocages.game.players.dwarves.RunnerDwarf
import pgm.poolp.blocages.game.players.dwarves.TrollSlayerDwarf
import pgm.poolp.blocages.game.players.elves.BlitzerElf
import pgm.poolp.blocages.game.players.elves.CatcherElf
import pgm.poolp.blocages.game.players.elves.LinemanElf
import pgm.poolp.blocages.game.players.elves.ThrowerElf
import pgm.poolp.blocages.game.players.goblins.LinemanGoblin
import pgm.poolp.blocages.game.players.halflings.HeftyHalfling
import pgm.poolp.blocages.game.players.halflings.HopefulHalfling
import pgm.poolp.blocages.game.players.halflings.RunnerHalfling
import pgm.poolp.blocages.game.players.humans.BlitzerHuman
import pgm.poolp.blocages.game.players.humans.CatcherHuman
import pgm.poolp.blocages.game.players.humans.LinemanHuman
import pgm.poolp.blocages.game.players.humans.ThrowerHuman
import pgm.poolp.blocages.game.players.lizardmen.ChameleonSkinkLizardmen
import pgm.poolp.blocages.game.players.lizardmen.SaurusBlockerLizardmen
import pgm.poolp.blocages.game.players.lizardmen.SkinkRunnerLizardmen
import pgm.poolp.blocages.game.players.nurgle.BloaterNurgle
import pgm.poolp.blocages.game.players.nurgle.PestigorNurgle
import pgm.poolp.blocages.game.players.nurgle.RotterNurgle
import pgm.poolp.blocages.game.players.orcs.BlackOrcBlockerOrc
import pgm.poolp.blocages.game.players.orcs.BlitzerOrc
import pgm.poolp.blocages.game.players.orcs.LinemanOrc
import pgm.poolp.blocages.game.players.orcs.ThrowerOrc
import pgm.poolp.blocages.game.players.skaven.BlitzerSkaven
import pgm.poolp.blocages.game.players.skaven.GutterRunnerSkaven
import pgm.poolp.blocages.game.players.skaven.LinemanSkaven
import pgm.poolp.blocages.game.players.skaven.ThrowerSkaven
import pgm.poolp.blocages.game.players.undead.*
import pgm.poolp.blocages.game.players.woodelves.CatcherWoodElf
import pgm.poolp.blocages.game.players.woodelves.LinemanWoodElf
import pgm.poolp.blocages.game.players.woodelves.ThrowerWoodElf
import pgm.poolp.blocages.game.players.woodelves.WardancerWoodElf

class GameFactory {

    private val playersFactories: List<PlayersFactory<*, Player>> =
        listOf(

            // DWARVES PLAYERS
            object : PlayersFactory<DwarfPlayers, Dwarf> {
                override fun build(type: DwarfPlayers): Dwarf {
                    return when (type) {
                        DwarfPlayers.BLITZER -> BlitzerDwarf()
                        DwarfPlayers.LINEMAN -> LinemanDwarf()
                        DwarfPlayers.RUNNER -> RunnerDwarf()
                        DwarfPlayers.TROLL_SLAYER -> TrollSlayerDwarf()
                    }
                }

                override fun randomPlayer(): Dwarf {
                    return build(DwarfPlayers.values().random())
                }
            },

            // ELVES PLAYERS
            object : PlayersFactory<ElfPlayers, Elf> {
                override fun build(type: ElfPlayers): Elf {
                    return when (type) {
                        ElfPlayers.BLITZER -> BlitzerElf()
                        ElfPlayers.CATCHER -> CatcherElf()
                        ElfPlayers.LINEMAN -> LinemanElf()
                        ElfPlayers.THROWER -> ThrowerElf()
                    }
                }

                override fun randomPlayer(): Elf {
                    return build(ElfPlayers.values().random())
                }
            },

            // CHAOS PLAYERS
            object : PlayersFactory<ChaosPlayers, Chaos> {
                override fun build(type: ChaosPlayers): Chaos {
                    return when (type) {
                        ChaosPlayers.BEASTMAN_RUNNER -> BeastmanRunnerChaos()
                        ChaosPlayers.BLOCKER -> BlockerChaos()
                    }
                }

                override fun randomPlayer(): Chaos {
                    return build(ChaosPlayers.values().random())
                }
            },

            // DARK ELVES PLAYERS
            object : PlayersFactory<DarkElfPlayers, DarkElf> {
                override fun build(type: DarkElfPlayers): DarkElf {
                    return when (type) {
                        DarkElfPlayers.BLITZER -> BlitzerDarkElf()
                        DarkElfPlayers.LINEMAN -> LinemanDarkElf()
                        DarkElfPlayers.RUNNER -> RunnerDarkElf()
                        DarkElfPlayers.WITCH_ELF -> WitchElfDarkElf()
                    }
                }

                override fun randomPlayer(): DarkElf {
                    return build(DarkElfPlayers.values().random())
                }
            },

            // WOOD ELVES PLAYERS
            object : PlayersFactory<WoodElfPlayers, WoodElf> {
                override fun build(type: WoodElfPlayers): WoodElf {
                    return when (type) {
                        WoodElfPlayers.CATCHER -> CatcherWoodElf()
                        WoodElfPlayers.LINEMAN -> LinemanWoodElf()
                        WoodElfPlayers.THROWER -> ThrowerWoodElf()
                        WoodElfPlayers.WARDANCER -> WardancerWoodElf()
                    }
                }

                override fun randomPlayer(): WoodElf {
                    return build(WoodElfPlayers.values().random())
                }
            },

            // GOBLINS PLAYERS
            object : PlayersFactory<GoblinPlayers, Goblin> {
                override fun build(type: GoblinPlayers): Goblin {
                    return when (type) {
                        GoblinPlayers.LINEMAN -> LinemanGoblin()
                    }
                }

                override fun randomPlayer(): Goblin {
                    return build(GoblinPlayers.values().random())
                }
            },

            // HALFLINGS PLAYERS
            object : PlayersFactory<HalflingPlayers, Halfling> {
                override fun build(type: HalflingPlayers): Halfling {
                    return when (type) {
                        HalflingPlayers.HEFTY -> HeftyHalfling()
                        HalflingPlayers.HOPEFUL -> HopefulHalfling()
                        HalflingPlayers.RUNNER -> RunnerHalfling()
                    }
                }

                override fun randomPlayer(): Halfling {
                    return build(HalflingPlayers.values().random())
                }
            },

            // LIZARDMEN PLAYERS
            object : PlayersFactory<LizardmenPlayers, Lizardmen> {
                override fun build(type: LizardmenPlayers): Lizardmen {
                    return when (type) {
                        LizardmenPlayers.CHAMELEON_SKINK -> ChameleonSkinkLizardmen()
                        LizardmenPlayers.SAURUS_BLOCKER -> SaurusBlockerLizardmen()
                        LizardmenPlayers.SKINK_RUNNER -> SkinkRunnerLizardmen()
                    }
                }

                override fun randomPlayer(): Lizardmen {
                    return build(LizardmenPlayers.values().random())
                }
            },

            // HUMAN PLAYERS
            object : PlayersFactory<HumanPlayers, Human> {
                override fun build(type: HumanPlayers): Human {
                    return when (type) {
                        HumanPlayers.BLITZER -> BlitzerHuman()
                        HumanPlayers.CATCHER -> CatcherHuman()
                        HumanPlayers.LINEMAN -> LinemanHuman()
                        HumanPlayers.THROWER -> ThrowerHuman()
                    }
                }

                override fun randomPlayer(): Human {
                    return build(HumanPlayers.values().random())
                }
            },

            // ZOMBIE PLAYERS
            object : PlayersFactory<UndeadPlayers, Undead> {
                override fun build(type: UndeadPlayers): Undead {
                    return when (type) {
                        UndeadPlayers.GHOUL -> GhoulUndead()
                        UndeadPlayers.MUMMY -> MummyUndead()
                        UndeadPlayers.SKELETON -> SkeletonUndead()
                        UndeadPlayers.WIGHT_BLITZER -> WightBlitzerUndead()
                        UndeadPlayers.ZOMBIE -> ZombieUndead()
                    }
                }

                override fun randomPlayer(): Undead {
                    return build(UndeadPlayers.values().random())
                }
            },

            // NURGLE PLAYERS
            object : PlayersFactory<NurglePlayers, Nurgle> {
                override fun build(type: NurglePlayers): Nurgle {
                    return when (type) {
                        NurglePlayers.BLOATER -> BloaterNurgle()
                        NurglePlayers.PESTIGOR -> PestigorNurgle()
                        NurglePlayers.ROTTER -> RotterNurgle()
                    }
                }

                override fun randomPlayer(): Nurgle {
                    return build(NurglePlayers.values().random())
                }
            },

            // ORC PLAYERS
            object : PlayersFactory<OrcPlayers, Orc> {
                override fun build(type: OrcPlayers): Orc {
                    return when (type) {
                        OrcPlayers.BLACK_ORC_BLOCKER -> BlackOrcBlockerOrc()
                        OrcPlayers.BLITZER -> BlitzerOrc()
                        OrcPlayers.LINEMAN -> LinemanOrc()
                        OrcPlayers.THROWER -> ThrowerOrc()
                    }
                }

                override fun randomPlayer(): Orc {
                    return build(OrcPlayers.values().random())
                }
            },

            // SKAVEN PLAYERS
            object : PlayersFactory<SkavenPlayers, Skaven> {
                override fun build(type: SkavenPlayers): Skaven {
                    return when (type) {
                        SkavenPlayers.BLITZER -> BlitzerSkaven()
                        SkavenPlayers.GUTTER_RUNNER -> GutterRunnerSkaven()
                        SkavenPlayers.LINEMAN -> LinemanSkaven()
                        SkavenPlayers.THROWER -> ThrowerSkaven()
                    }
                }

                override fun randomPlayer(): Skaven {
                    return build(SkavenPlayers.values().random())
                }
            }
        )

    fun randomPlayer() : Player {
        return playersFactories.random().randomPlayer()
    }
}