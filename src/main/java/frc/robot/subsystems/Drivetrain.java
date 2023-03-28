// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI;

public class Drivetrain extends SubsystemBase {

  private static final DifferentialDrive differentialDriver = new DifferentialDrive(
    RobotMap.leftDriveMotor,
    RobotMap.rightDriveMotor
  );

  
  public Drivetrain() {
    // RobotMap.rightDriveMotor.setInverted(true);
    // RobotMap.rightDriveFollower.setInverted(true);
    setDefaultCommand(OIDrive());
    stop();
  }

  public CommandBase OIDrive() {
    return run(
        () -> {
          this.driveArcade(OI.getTurnJoystick(), OI.getDriveJoystick());
        });
  }

  public void driveArcade(double speed, double rotationRate) {
    differentialDriver.arcadeDrive(speed, rotationRate);
  }
  public void driveTank(double leftSpeed, double rightSpeed) {
    differentialDriver.tankDrive(leftSpeed, rightSpeed);
  }
  public void driveSolo(double leftSpeed, double rightSpeed) {
    RobotMap.leftDriveMotor.set(-leftSpeed);
    RobotMap.rightDriveMotor.set(rightSpeed);
  }
  public void stop() {
    differentialDriver.stopMotor();
  }


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
