package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RobotMap {
  // MOTORS
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

  public static final RelativeEncoder rightMotorEncoder = right.getEncoder();
  public static final RelativeEncoder leftMotorEncoder = left.getEncoder();
  public static final AHRS gyro = new AHRS(SPI.Port.kMXP);  
  public static InstantCommand calibrateGyro = new InstantCommand(() -> {gyro.calibrate();});

  public static void start() {
    rightMotorEncoder.setPositionConversionFactor(4 / 256);
    leftMotorEncoder.setPositionConversionFactor(4 / 256);
    rightSlave.follow(RobotMap.right);
    leftSlave.follow(RobotMap.left);
    gyro.calibrate();
  }
}