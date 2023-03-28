// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

public final class Autos {

  /** Example static factory for an autonomous command. */
  public static CommandBase AutoOne(Drivetrain drivetrain, Arm arm, Claw claw) {
    return Commands.sequence(
      new DriveDistance(drivetrain, 0.05, 5),
      arm.pushArmCommand().withTimeout(0.25),
      arm.stopArmCommand(),
      claw.clawToggleCommand(),
      new DriveDistance(drivetrain, -0.05, 5)
    );
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
