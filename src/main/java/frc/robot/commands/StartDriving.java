// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class StartDriving extends CommandBase {

  /** Creates a new StartDriving. */
  public StartDriving() {
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.drivetrain.tankDrive(OI.getYLeft(), OI.getYRight());
    System.out.println(RobotContainer.vision.getTargetArea());
    // System.out.print(!RobotMap.actuatorSwitch.get() + " " + !RobotMap.armSwitch.get() + "\n");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
