// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class DriveDistance extends CommandBase {
  // @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain drivetrain;
  private final double speed;
  private final double distance;
  private double encoderValue = 0;

  public DriveDistance(Drivetrain subsystem, double speed, double distance) {
    this.drivetrain = subsystem;
    this.speed = speed;
    this.distance = distance;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.setRightEncoder(0);
    drivetrain.setLeftEncoder(0);
    // drivetrain.driveArcade(0, 0);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    encoderValue = (Math.abs(drivetrain.getRightEncoder()) + Math.abs(drivetrain.getLeftEncoder())) / 2;
    System.out.println(encoderValue);
    this.drivetrain.driveSolo(this.speed, this.speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // return false;
    return encoderValue > this.distance;
  }
}
