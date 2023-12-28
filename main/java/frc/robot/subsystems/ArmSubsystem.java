
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    private final PWMSparkMax m_intakeMotor = new PWMSparkMax(0);
    //private final DigitalInput m_limitSwitch = new DigitalInput(0);

    public ArmSubsystem(){
    }

    public void open(){
        m_intakeMotor.set(.2);
    }

    public void close(){
        m_intakeMotor.set(-.2);
    }

}
