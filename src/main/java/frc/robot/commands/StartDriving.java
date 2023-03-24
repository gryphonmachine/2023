package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class StartDriving extends CommandBase {

  public static XboxController driverController = new XboxController(0);
  private final DifferentialDrive drivetrain = new DifferentialDrive(
    RobotMap.left,
    RobotMap.right
  );

  public StartDriving() {
    addRequirements(RobotContainer.drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    drivetrain.arcadeDrive(-OI.getRightX(), -OI.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
