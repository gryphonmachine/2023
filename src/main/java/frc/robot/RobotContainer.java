package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  public static Drivetrain drivetrain;

  public RobotContainer() {
    drivetrain = new Drivetrain();
    drivetrain.setDefaultCommand(new StartDriving());
  }
}
