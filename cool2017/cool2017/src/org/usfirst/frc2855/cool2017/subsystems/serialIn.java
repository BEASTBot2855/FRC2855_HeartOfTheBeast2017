package org.usfirst.frc2855.cool2017.subsystems;

import org.usfirst.frc2855.cool2017.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class serialIn extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void serialRead() {
    	
    	String x = RobotMap.serialTest.readString();
    	
    	DriverStation.reportWarning(x, true);
    }
}

