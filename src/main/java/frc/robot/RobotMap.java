package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

  public static final CANSparkMax arm = new CANSparkMax(7, MotorType.kBrushed);
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

  public static final DoubleSolenoid claw = new DoubleSolenoid(
    PneumaticsModuleType.CTREPCM,
    0,
    1
  );
  public static final DigitalInput armSwitch = new DigitalInput(7);

  public static final RelativeEncoder rightMotorEncoder = right.getEncoder();
  public static final RelativeEncoder leftMotorEncoder = left.getEncoder();
  public static final AHRS gyro = new AHRS(SPI.Port.kMXP);
  // public static final AnalogInput pressureSensor = new AnalogInput(0);
  public static final Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  
  public static void init() {
    rightMotorEncoder.setPositionConversionFactor(4 / 256);
    leftMotorEncoder.setPositionConversionFactor(4 / 256);
    rightSlave.follow(right);
    leftSlave.follow(left);
    gyro.calibrate();
  }
}
