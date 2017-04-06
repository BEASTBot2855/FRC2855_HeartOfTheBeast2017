package org.usfirst.frc2855.cool2017.subsystems;

import org.usfirst.frc2855.cool2017.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDArduino extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final DigitalOutput shooter = RobotMap.ledshooter;
	private final DigitalOutput intake = RobotMap.ledintake;
	private final DigitalOutput flash = RobotMap.ledflash;
	private final DigitalOutput breathe = RobotMap.ledbreathe;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void LEDShooterActivate() { //DIO 1
    	shooter.set(true);
    }
    
    public void LEDIntakeActivate() { //DIO 2
    	intake.set(true);
    }
    
    public void LEDFlashActivate() { //DIO 3
    	flash.set(true);
    }
    
    public void LEDBreatheActivate() { //DIO 4
    	breathe.set(true);
    }
    
    public void LEDShooterDeActivate() { //DIO 1
    	shooter.set(false);
    }
    
    public void LEDIntakeDeActivate() { //DIO 2
    	intake.set(false);
    }
    
    public void LEDFlashDeActivate() { //DIO 3
    	flash.set(false);
    }
    
    public void LEDBreatheDeActivate() { //DIO 4
    	breathe.set(false);
    }
}

