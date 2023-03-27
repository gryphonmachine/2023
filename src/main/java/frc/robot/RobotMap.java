package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class RobotMap {

  // Motors
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

  public static final CANSparkMax arm = new CANSparkMax(7, MotorType.kBrushed);

  public static final DoubleSolenoid claw = new DoubleSolenoid(
    PneumaticsModuleType.CTREPCM,
    0,
    1
  );

  public static final AnalogInput pressureSensor = new AnalogInput(0);
  public static final Compressor pcmCompressor = new Compressor(
    0,
    PneumaticsModuleType.CTREPCM
  );

  // Autonomous: Motor Speeds
  public static final double FORWARD_SPEED = 0.5;
  public static final double FORWARD_TIME = 0.15; // seconds

  public static final double BACKWARD_SPEED = -0.5;
  public static final double BACKWARD_TIME = 1.5; // seconds

  // Encoders
  public static final RelativeEncoder rightMotorEncoder = right.getEncoder();
  public static final RelativeEncoder leftMotorEncoder = left.getEncoder();

  public static void start() {
    rightMotorEncoder.setPositionConversionFactor(4.0 / 256.0);
    leftMotorEncoder.setPositionConversionFactor(4.0 / 256.0);
    rightSlave.follow(right);
    leftSlave.follow(left);
  }
}
