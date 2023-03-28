package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {

  private static final DifferentialDrive differentialDriver = new DifferentialDrive(
    RobotMap.leftDriveMotor,
    RobotMap.rightDriveMotor
  );

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
    RobotMap.leftDriveMotor.set(-leftSpeed);
    RobotMap.rightDriveMotor.set(rightSpeed);
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
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
