package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeSubsystem;

public final class Autos {
    

    public static Command dropAndGoAuto(Drivetrain m_myRobot, IntakeSubsystem m_IntakeSubsystem){
        return Commands.sequence(
            m_IntakeSubsystem.releaseCommand().withTimeout(2),
            m_myRobot.driveForwardCommand(AutoConstants.kTimeoutSeconds, AutoConstants.kDriveSpeed));     }
}
