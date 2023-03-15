// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;

public class StartArm extends CommandBase {

  /** Creates a new StartDriving. */
  public StartArm() {
    addRequirements(RobotContainer.arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (OI.dropArmButton.getAsBoolean()) {
      RobotContainer.arm.pull();
    } else if (OI.liftArmButton.getAsBoolean()) {
      RobotContainer.arm.push();
    } else {
      RobotContainer.arm.stop();
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
