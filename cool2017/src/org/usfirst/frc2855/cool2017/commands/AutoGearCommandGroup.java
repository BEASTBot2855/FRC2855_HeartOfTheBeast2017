package org.usfirst.frc2855.cool2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto command for placing gear on peg
 * Moves, turns, moves, releases gear, drives away
 */
public class AutoGearCommandGroup extends CommandGroup {

    public AutoGearCommandGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new AutoGearCommand());
    	addSequential(new AutoTurn());
    	addSequential(new AutoGearCommand());
    	addSequential(new AutoGearRelease());
      	addSequential(new AutoReverse());
    }
}
