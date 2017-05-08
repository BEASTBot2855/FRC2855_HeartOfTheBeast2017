package org.usfirst.frc2855.cool2017;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.hal.HAL;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tInstances;
import edu.wpi.first.wpilibj.hal.FRCNetComm.tResourceType;

public class SixMotorDrive extends RobotDrive{

	private CANTalon rearLeftMotorSlave;
	private CANTalon rearRightMotorSlave;
	
	public SixMotorDrive(CANTalon frontLeftMotor, CANTalon rearLeftMotor, CANTalon frontRightMotor,
			CANTalon rearRightMotor, CANTalon rearLeftMotorSlave, CANTalon rearRightMotorSlave) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		
		// declare which slave motor controllers are which
		this.rearLeftMotorSlave = rearLeftMotorSlave;
		this.rearRightMotorSlave = rearRightMotorSlave;
		
		// set slaves to follower mode
		this.rearLeftMotorSlave.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
		this.rearRightMotorSlave.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
		
		// get ids of talons to follow
		this.rearLeftMotorSlave.set(rearLeftMotor.getDeviceID());
		this.rearRightMotorSlave.set(rearRightMotor.getDeviceID());
	}
	
	// copied from RobotDrive class but has different calculations to determine wheel speed and direction
	public void mecanumDrive_Cartesian(double x, double rotate, double strafe, double gyroAngle) {
	    if (!kMecanumCartesian_Reported) {
	      HAL.report(tResourceType.kResourceType_RobotDrive, getNumMotors(),
	          tInstances.kRobotDrive_MecanumCartesian);
	      kMecanumCartesian_Reported = true;
	    }
	    @SuppressWarnings("LocalVariableName")
	    double xIn = x;
	    @SuppressWarnings("LocalVariableName")
	    double rotateIn = rotate;
	    // Negate y for the joystick.
	    rotateIn = -rotateIn;
	    // Compenstate for gyro angle.
	    double[] rotated = rotateVector(xIn, rotateIn, gyroAngle);
	    xIn = rotated[0];
	    rotateIn = rotated[1];

	    double[] wheelSpeeds = new double[kMaxNumberOfMotors];
	    wheelSpeeds[MotorType.kFrontLeft.value] = xIn - Math.pow(rotateIn, 5) + strafe;
	    wheelSpeeds[MotorType.kFrontRight.value] = xIn + Math.pow(rotateIn, 5) + strafe;
	    wheelSpeeds[MotorType.kRearLeft.value] = -xIn + Math.pow(rotateIn, 5) + strafe;
	    wheelSpeeds[MotorType.kRearRight.value] = -xIn - Math.pow(rotateIn, 5) + strafe;
	    
	    normalize(wheelSpeeds);
	    m_frontLeftMotor.set(wheelSpeeds[MotorType.kFrontLeft.value] * m_maxOutput);
	    m_frontRightMotor.set(wheelSpeeds[MotorType.kFrontRight.value] * m_maxOutput);
	    m_rearLeftMotor.set(wheelSpeeds[MotorType.kRearLeft.value] * m_maxOutput * 0.9);
	    m_rearRightMotor.set(wheelSpeeds[MotorType.kRearRight.value] * m_maxOutput * 0.9);
	    	    
	    if (m_safetyHelper != null) {
	        m_safetyHelper.feed();
	      }
	  } 
	
}
