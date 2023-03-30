package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.SPI;

public class Drivetrain extends SubsystemBase {
  private static AHRS ahrs = new AHRS(SPI.Port.kMXP);
  private static final DifferentialDrive differentialDriver = new DifferentialDrive(
      RobotMap.leftDriveMotor,
      RobotMap.rightDriveMotor);
  private static PIDController m_balancePID = new PIDController(0.05, 0, 0);

  public Drivetrain() {
    setDefaultCommand(OIDrive());
    stop();
  }

  public CommandBase OIDrive() {
    return run(() -> {
      this.driveArcade(OI.getTurnJoystick(), OI.getDriveJoystick());
    });
  }

  // Arcade Drive
  public void driveArcade(double speed, double rotationRate) {
    differentialDriver.arcadeDrive(speed, rotationRate);
  }

  // Tank Drive
  public void driveTank(double leftSpeed, double rightSpeed) {
    differentialDriver.tankDrive(leftSpeed, rightSpeed);
  }

  // DriveDistance Drive
  public void driveSolo(double leftSpeed, double rightSpeed) {
    differentialDriver.feed();
    RobotMap.leftDriveMotor.set(-leftSpeed);
    RobotMap.rightDriveMotor.set(rightSpeed);
  }

  public PIDController getBalanceController() {
    return m_balancePID;
  }

  public double getPitchDegrees() {
    return ahrs.getPitch();
  }

  // Stop Motors
  public void stop() {
    differentialDriver.stopMotor();
  }

  // Encoders
  public double getRightEncoder() {
    return RobotMap.rightMotorEncoder.getPosition();
  }

  public double getLeftEncoder() {
    return RobotMap.leftMotorEncoder.getPosition();
  }

  public void setLeftEncoder(double position) {
    RobotMap.leftMotorEncoder.setPosition(position);
  }

  public void setRightEncoder(double position) {
    RobotMap.rightMotorEncoder.setPosition(position);
  }

  @Override
  public void periodic() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
