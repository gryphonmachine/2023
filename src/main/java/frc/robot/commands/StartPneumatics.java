// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class StartPneumatics extends CommandBase {

  /** Creates a new StartPneumatics. */
  public StartPneumatics() {
    addRequirements(RobotContainer.pneumatics);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (OI.solenoidOffButton.getAsBoolean()) {
      RobotContainer.pneumatics.solenoidBack();
    } else if (OI.solenoidButton.getAsBoolean()) {
      RobotContainer.pneumatics.solenoidForward();
    }
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
