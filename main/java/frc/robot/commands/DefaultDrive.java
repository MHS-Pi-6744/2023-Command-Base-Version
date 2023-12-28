package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class DefaultDrive extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final DoubleSupplier m_forward;
  private final DoubleSupplier m_rotation;

  /**
   * Creates a new DefaultDrive.
   *
   * @param drivetrain The drive subsystem this command wil run on.
   * @param fwd The control input for driving forwards/backwards
   * @param rot The control input for turning
   */
  public DefaultDrive(Drivetrain drivetrain, DoubleSupplier fwd, DoubleSupplier rot) {
    m_drivetrain = drivetrain;
    m_forward = fwd;
    m_rotation = rot;
    addRequirements(m_drivetrain);
  }


@Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
  }

  // Make this return true when this Command no longer needs to run execute()
@Override
  public boolean isFinished() {
    return false; // Runs until interrupted
  } 

// Called once after isFinished returns true
@Override
  public void end(boolean interrupted) {
   m_drivetrain.arcadeDrive(0, 0);
  }
}