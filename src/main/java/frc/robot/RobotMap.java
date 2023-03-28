package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

  // Drivetrain Motors
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

  // Arm & Claw Motors
  public static final CANSparkMax arm = new CANSparkMax(7, MotorType.kBrushed);

  public static final DoubleSolenoid clawPiston = new DoubleSolenoid(
    PneumaticsModuleType.CTREPCM,
    0,
    1
  );

  // Compressor
  public static final Compressor pcmCompressor = new Compressor(
    0,
    PneumaticsModuleType.CTREPCM
  );

  // Encoders
  public static final RelativeEncoder rightMotorEncoder = rightDriveMotor.getEncoder();
  public static final RelativeEncoder leftMotorEncoder = leftDriveMotor.getEncoder();

  // Misc
  public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

  public static void initRobotMap() {
    rightDriveFollower.follow(rightDriveMotor);
    leftDriveFollower.follow(leftDriveMotor);
  }
}
