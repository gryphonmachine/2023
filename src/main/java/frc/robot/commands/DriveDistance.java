// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistance extends CommandBase {
  private final Drivetrain drivetrain;
  private final double speed;
  private final double distance;
  private double encoderValue = 0;

  public DriveDistance(Drivetrain subsystem, double speed, double distance) {
    this.drivetrain = subsystem;
    this.speed = speed;
    this.distance = distance;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    drivetrain.setRightEncoder(0);
    drivetrain.setLeftEncoder(0);
  }

  @Override
  public void execute() {
    encoderValue = (Math.abs(drivetrain.getRightEncoder()) + Math.abs(drivetrain.getLeftEncoder())) / 2;
    System.out.println(encoderValue);
    this.drivetrain.driveSolo(this.speed, this.speed);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("Finished a drivedistance");
    drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return encoderValue > this.distance;
  }
}
