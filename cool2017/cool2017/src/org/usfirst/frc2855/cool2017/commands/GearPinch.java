package org.usfirst.frc2855.cool2017.commands;

import org.usfirst.frc2855.cool2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * tells gear solenoid to pinch gear
 */
public class GearPinch extends Command {

    public GearPinch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearpinch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearpinch.gearPinch();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearpinch.gearPinchNull();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
