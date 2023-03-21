package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class StartDriving extends CommandBase {

  public static XboxController driverController = new XboxController(0);

  public StartDriving() {
    addRequirements(RobotContainer.drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Drivetrain.tankDrive(-OI.getRightX(), -OI.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}