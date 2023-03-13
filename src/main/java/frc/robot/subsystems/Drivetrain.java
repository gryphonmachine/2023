// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class Drivetrain extends SubsystemBase {

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

  public void tankDrive(double left, double right) {
    // RobotMap.left.set(Math.min(1, -left * speedMultiplier));
    // RobotMap.right.set(Math.min(1, -right * speedMultiplier));
    RobotMap.left.set(left);
    RobotMap.right.set(-right);
  }

  public void stop() {
    RobotMap.left.stopMotor();
    RobotMap.right.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

}