package org.usfirst.frc2855.cool2017.commands;

import org.usfirst.frc2855.cool2017.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * turns the robot counterclockwise for 2 seconds, then stops the robot
 */
public class AutoTurn extends Command {

	private double t;
    public AutoTurn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.movedarobot.turnLeft();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Timer.getFPGATimestamp() >= t+2);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.movedarobot.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
