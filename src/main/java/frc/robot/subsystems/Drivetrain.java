// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {

  private final static DifferentialDrive drivetrain = new DifferentialDrive(
    RobotMap.left,
    RobotMap.right
  );

  // SPEED MULTIPLIER for ramp up on controller
  public double speedMultiplier = 1.0;

  public void setSpeedMultiplier(double multiplier) {
    speedMultiplier = multiplier;
  }

  public double getSpeedMultiplier() {
    return speedMultiplier;
  }

  public Drivetrain() {
    stop();
  }

  public static void tankDrive(double xSpeed, double zRotation) {
    drivetrain.arcadeDrive(xSpeed, zRotation);
  }

  public void stop() {
    RobotMap.left.stopMotor();
    RobotMap.right.stopMotor();
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
