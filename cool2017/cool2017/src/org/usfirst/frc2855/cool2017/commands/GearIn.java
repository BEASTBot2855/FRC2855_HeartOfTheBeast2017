package org.usfirst.frc2855.cool2017.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2855.cool2017.RobotMap;
import org.usfirst.frc2855.cool2017.Robot;

/**
 * tells arm solenoid to pull gear arm in
 */
public class GearIn extends Command {

    public GearIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.geararm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Gear Arm Status", "Retracted");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.geararm.gearIn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.geararm.gearInOutNull();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
