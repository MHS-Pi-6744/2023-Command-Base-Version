// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {

  // must create groups and add 2 motors, assign CANID in constants - RM
  private final CANSparkMax leftMotor = new CANSparkMax(DrivetrainConstants.LEFT_MOTOR_CANID, MotorType.kBrushless);
  private final CANSparkMax rightMotor = new CANSparkMax(DrivetrainConstants.RIGHT_MOTOR_CANID, MotorType.kBrushless);

  private final DifferentialDrive m_drivetrain = new DifferentialDrive(leftMotor,rightMotor);

  // Add encoders here - RM

  /** Creates a new subsystem. */
  public Drivetrain() {
    rightMotor.setInverted(true);
  }

   // sets the motors to move at a certain speed, so long as it is a positive value between 0 and 1
  public void forward(double speed){
    // before we send this value to the motors we want to only send it if it is a value between 0.0 and 1.0
    // anything else is an invalid value for this function, because we are going FORWARD
    if(speed <= 1.0 && speed > 0.0){
        leftMotor.set(speed);
        rightMotor.set(speed);
      } else{
        // we enter this block if we are given a bad value, let's just set the motors to zero
        leftMotor.set(0.0);
        rightMotor.set(0.0);
      }
    }

    // function that stops the motors
  public void stop(){
    leftMotor.set(0.0);
    rightMotor.set(0.0);
  }
   /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
   m_drivetrain.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
