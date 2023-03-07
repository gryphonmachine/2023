package frc.robot;
//PORT DECLARATIONS

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DigitalInput;

public class RobotMap {

    public static final CANSparkMax arm = new CANSparkMax(1, MotorType.kBrushed);
    public static final CANSparkMax right = new CANSparkMax(5, MotorType.kBrushless);
    public static final CANSparkMax left = new CANSparkMax(2, MotorType.kBrushless);
    public static final CANSparkMax rightSlave = new CANSparkMax(6, MotorType.kBrushless);
    public static final CANSparkMax leftSlave = new CANSparkMax(3, MotorType.kBrushless);
    public static final CANSparkMax actuator = new CANSparkMax(7, MotorType.kBrushed);
    public static final CANSparkMax follower = new CANSparkMax(8, MotorType.kBrushed);
    public static final DoubleSolenoid doublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,1);
    public static final DigitalInput actuatorSwitch = new DigitalInput(1);
    public static final DigitalInput armSwitch = new DigitalInput(7);

    public static void init()  {
        rightSlave.follow(right);
        leftSlave.follow(left);
        follower.follow(actuator);

    }
}