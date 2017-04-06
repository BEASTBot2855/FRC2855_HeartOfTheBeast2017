package org.usfirst.frc2855.cool2017.commands;

import org.usfirst.frc2855.cool2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoGearCommand extends Command {

	private final double time = 1.0; // enter number of seconds to run auto
	private static double codeTime = 0;
	private static int t = 0;
    public AutoGearCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	codeTime = (int) time*1000;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (t >= codeTime) { 
        	return true;
        } else {
        	t += 5; // add 5 milliseconds to t because thread runs approximately every 5 milliseconds
        	return false;
        }
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
