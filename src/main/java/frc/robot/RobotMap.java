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
  public static final CANSparkMax rightDriveMotor = new CANSparkMax(
    5,
    MotorType.kBrushless
  );
  public static final CANSparkMax leftDriveMotor = new CANSparkMax(
    2,
    MotorType.kBrushless
  );
  public static final CANSparkMax rightDriveFollower = new CANSparkMax(
    6,
    MotorType.kBrushless
  );
  public static final CANSparkMax leftDriveFollower = new CANSparkMax(
    3,
    MotorType.kBrushless
  );

  // ARM
  public static final CANSparkMax arm = new CANSparkMax(7, MotorType.kBrushed);

  // CLAW
  public static final DoubleSolenoid clawPiston = new DoubleSolenoid(
    PneumaticsModuleType.CTREPCM,
    0,
    1
  );

  public static final Compressor pcmCompressor = new Compressor(
    0,
    PneumaticsModuleType.CTREPCM
  );

  // Encoders
  public static final RelativeEncoder rightMotorEncoder = rightDriveMotor.getEncoder();
  public static final RelativeEncoder leftMotorEncoder = leftDriveMotor.getEncoder();

  public static void initRobotMap() {
    rightDriveMotor.setInverted(true);
    // rightMotorEncoder.setPositionConversionFactor(4.0 / 256.0);
    // leftMotorEncoder.setPositionConversionFactor(4.0 / 256.0);
    rightDriveFollower.follow(rightDriveMotor);
    leftDriveFollower.follow(leftDriveMotor);
  }
}
