package org.usfirst.frc2855.cool2017.subsystems;

import org.usfirst.frc2855.cool2017.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGrab extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final DoubleSolenoid gearDoubleSolenoid = RobotMap.gearPinchSolenoid;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void gearPinch() {
    	gearDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    public void gearUnPinch() {
    	gearDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void gearPinchNull() {
    	gearDoubleSolenoid.set(DoubleSolenoid.Value.kOff);
    }
}

