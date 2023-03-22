package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class StartDriving extends CommandBase {

  public StartDriving() {
    addRequirements(RobotContainer.drivetrain);
  }

  @Override
  public void execute() {
    Drivetrain.drive(-OI.getRightX(), -OI.getLeftY());
  }
}
