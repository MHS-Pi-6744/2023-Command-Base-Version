
package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import frc.robot.Constants;

/**The following is an example of using the INLINE method of calling commands. A seperate command file is not required.
 * See edu.wpi.first.wpilibj.examples.rapidreactcommandbot.subsystems; 
 * -RM */

public class IntakeSubsystem extends SubsystemBase {
    private final WPI_TalonSRX m_intakeMotor = new WPI_TalonSRX(Constants.Intake_CANID);
    //private final DigitalInput m_limitSwitch = new DigitalInput(0);

     /** Returns a command that deploys the intake, and then runs the intake motor indefinitely. */
    public Command intakeCommand() {
        return runOnce(() -> m_intakeMotor.set(.5))
            .withName("Intake");
    }

    /** Returns a command that turns off and retracts the intake. */
    public Command releaseCommand() {
            return runOnce(() -> m_intakeMotor.set(-.5))
            .withName("Release");
    } 
}
 