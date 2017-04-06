package org.usfirst.frc2855.cool2017.commands;

import org.usfirst.frc2855.cool2017.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * For testing the ultrasonic
 */
public class SensorTest extends Command {

	private final Ultrasonic ultrasonic = RobotMap.Ultrasonic;
	public static double range;
	
    public SensorTest() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	range = ultrasonic.getRangeInches();
    	SmartDashboard.putNumber("Ultrasonic Range", range);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
