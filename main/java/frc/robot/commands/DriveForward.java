package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveForward extends CommandBase {
  /** Creates a new DriveForward. */
  private final double speed = 0.1; // 0.0 is the MIN, 1.0 is the MAX speed
  private final long duration = 3000; // number of milliseconds that we want to drive forward, 3 seconds
  private long startTime;
  private Drivetrain m_drivetrain;
      
  public DriveForward(Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    m_drivetrain.forward(speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (System.currentTimeMillis() - startTime > duration) {
        return true;
    } else {
    return false;
    }
  }
}