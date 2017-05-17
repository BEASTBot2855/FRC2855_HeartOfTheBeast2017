// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2855.cool2017.subsystems;

import org.usfirst.frc2855.cool2017.Robot;
import org.usfirst.frc2855.cool2017.RobotMap;
import org.usfirst.frc2855.cool2017.SixMotorDrive;
import org.usfirst.frc2855.cool2017.SPIGyro.ADXRS453Gyro;
import org.usfirst.frc2855.cool2017.commands.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * moves da robot
 */
public class moveDaRobot extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SixMotorDrive robotDrive41 = RobotMap.driveRobotDrive41;
    private final ADXRS453Gyro SpinnySensor = RobotMap.SpinnySensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    	public moveDaRobot() {

    	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new relocaterobot());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void drivezRobot(double x, double y, double strafe) {
    	robotDrive41.mecanumDrive_Cartesian(x, y, strafe, 0);
    }
    
    // TODO figure out exactly which way is which, these values are arbitrary
    public void driveShooter(){
    	robotDrive41.mecanumDrive_Cartesian(0, 0, 1, 0);
    }
    
    public void driveGear(){
    	robotDrive41.mecanumDrive_Cartesian(0, -1, 0, 0);
    }
    
    public void driveIntake(){
    	robotDrive41.mecanumDrive_Cartesian(0, 1, 0, 0);
    }
    
    public void driveClimber(){
    	robotDrive41.mecanumDrive_Cartesian(0, 0, -1, 0);
    }
    
    public void stop(){
    	robotDrive41.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    
    public void turnLeft(){
    	robotDrive41.mecanumDrive_Cartesian(1, 0, 0, 0);
    }
    
    public void turnRight(){
    	robotDrive41.mecanumDrive_Cartesian(-1, 0, 0, 0);
    }
    public void calibrateSpinnySensor () {
    	SpinnySensor.calibrate();
    }
}
