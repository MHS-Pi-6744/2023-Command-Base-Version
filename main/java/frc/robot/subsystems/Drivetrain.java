// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import java.util.function.DoubleSupplier;


public class Drivetrain extends SubsystemBase {

  // must create groups and add 2 motors, assign CANID in constants - RM
  private final CANSparkMax m_leftMotor = new CANSparkMax(DrivetrainConstants.LEFT_MOTOR_CANID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(DrivetrainConstants.RIGHT_MOTOR_CANID, MotorType.kBrushless);

  private final DifferentialDrive m_drivetrain = new DifferentialDrive(m_leftMotor,m_rightMotor);

  // Add encoders here - RM

  /** Creates a new subsystem. */
  public Drivetrain() {
    m_rightMotor.setInverted(true);
  }

  public Command arcadeDriveCommand(DoubleSupplier fwd, DoubleSupplier rot) {
    // A split-stick arcade command, with forward/backward controlled by the left
    // hand, and turning controlled by the right.
    return run(() -> m_drivetrain.arcadeDrive(fwd.getAsDouble(), rot.getAsDouble()))
        .withName("arcadeDrive");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
