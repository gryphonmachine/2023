package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;

public class RobotContainer {

  public static Drivetrain drivetrain;
  public static Pneumatics pneumatics;
  public static Arm arm;

  public RobotContainer() {
    drivetrain = new Drivetrain();
    pneumatics = new Pneumatics();
    arm = new Arm();

    drivetrain.setDefaultCommand(new StartDriving());
    arm.setDefaultCommand(new StartArm());
    pneumatics.setDefaultCommand(new StartPneumatics());
  }
}
