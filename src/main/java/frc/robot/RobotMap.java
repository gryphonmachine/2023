package frc.robot;

import com.kauailabs.navx.frc.AHRS;
//PORT DECLARATIONS

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

  public static final CANSparkMax arm = new CANSparkMax(1, MotorType.kBrushed);
  public static final CANSparkMax right = new CANSparkMax(
    5,
    MotorType.kBrushless
  );
  public static final CANSparkMax left = new CANSparkMax(
    2,
    MotorType.kBrushless
  );
  public static final CANSparkMax rightSlave = new CANSparkMax(
    6,
    MotorType.kBrushless
  );
  public static final CANSparkMax leftSlave = new CANSparkMax(
    3,
    MotorType.kBrushless
  );
  public static final CANSparkMax actuator = new CANSparkMax(
    7,
    MotorType.kBrushed
  );
  public static final CANSparkMax follower = new CANSparkMax(
    8,
    MotorType.kBrushed
  );

  public static final DoubleSolenoid doublePCM = new DoubleSolenoid(
    PneumaticsModuleType.CTREPCM,
    0,
    1
  );
  public static final DigitalInput actuatorSwitch = new DigitalInput(1);
  public static final DigitalInput armSwitch = new DigitalInput(7);

  public static final RelativeEncoder rightMotorEncoder = right.getEncoder();
  public static final RelativeEncoder leftMotorEncoder = left.getEncoder();
  public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

  public static void init() {
    rightMotorEncoder.setPositionConversionFactor(4 / 256);
    leftMotorEncoder.setPositionConversionFactor(4 / 256);
    rightSlave.follow(right);
    leftSlave.follow(left);
    follower.follow(actuator);
    gyro.calibrate();
  }
}
