// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2855.cool2017;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2855.cool2017.commands.*;
import org.usfirst.frc2855.cool2017.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static ballintake ballintake;
    public static shooter shooter;
    public static drive drive;
    public static climbingarm climbingarm;
    public static PneumaticGearArm geararm;
    public static PneumaticGearPinch gearpinch;
    public static LEDArduino leds;
    public static UsbCamera usbcam;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    
    	// initializes RobotMap
    	RobotMap.init();
    
    	// creates new intake subsystem object
        ballintake = new ballintake();
        
        // creates new shooter subsystem object
        shooter = new shooter();
        
        // creates new drive subsystem object
        drive = new drive();
        
        // creates new climber subsystem object
        climbingarm = new climbingarm();
        
        // creates new gear arm solenoid subsystem object
        geararm = new PneumaticGearArm();
        
        // creates new gear solenoid subsystem object
        gearpinch = new PneumaticGearPinch();
        
        // creates new LED microcontroller subsystem object
        leds = new LEDArduino();

        UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture();
        
        /* code for two cameras - currently untested
        
        UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
        UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);
        */
        
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        autonomousCommand = new AutoGearCommandGroup();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    	// these pull in the arm and pinch a gear
    	// apparently runs when disabled starts but solenoids don't fire until enabled again which kind of makes sense
    	gearpinch.gearPinch();
    	geararm.gearIn();
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        // turns on agitator
        RobotMap.agitator.set(1);
        
        // puts FPGA time on SmartDashboard
        SmartDashboard.putNumber("Match Time", Timer.getFPGATimestamp());
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        // runs agitator
        RobotMap.agitator.set(1);
        
        // puts FPGA time on SmartDashboard
        SmartDashboard.putNumber("Match Time", Timer.getFPGATimestamp());
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
