// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.Constants.OIConstants;
//import frc.robot.commands.Autos;
//import frc.robot.commands.DriveForward;
//import frc.robot.commands.DefaultDrive;
//import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  //private final DriveForward m_driveForward = new DriveForward(m_drivetrain);
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  //private final ArmSubsystem m_armSubsystem = new ArmSubsystem();
  //private final ExtendArm m_extendArmCommand = new ExtendArm(m_armSubsystem);

  // The autonomous routines go here

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The driver's controller
  CommandXboxController m_driverController = new CommandXboxController(OIConstants.kDriverControllerPort);

  public RobotContainer(){
    // Configure the button bindings
    configureButtonBindings();
  
  }

   
  public void configureButtonBindings() {
    m_drivetrain.setDefaultCommand(
        m_drivetrain.arcadeDriveCommand(
            () -> -m_driverController.getLeftY(), () -> -m_driverController.getRightX()));

     // Pickup a cube with the X button
     m_driverController.x().toggleOnTrue(m_intake.pickupCommand());
     // Shoot the cube with the Y button
     m_driverController.y().toggleOnTrue(m_intake.releaseCommand());
     // Stop the intake with the B button
     m_driverController.b().onTrue(m_intake.disableIntakeCommand());
 
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_chooser.getSelected();
  //}
}

 
}