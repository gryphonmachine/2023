package frc.robot.util;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveDistance extends CommandBase {

  final double distance;
  final double speed;
  double calibrationFactor = 1/95.6;
  public DriveDistance(double distance, double speed) {
    addRequirements(RobotContainer.drivetrain);
    this.speed = speed;
    this.distance = distance;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    RobotMap.rightMotorEncoder.setPosition(0);
    RobotMap.leftMotorEncoder.setPosition(0);
    System.out.println("Initialized autonomous");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    RobotContainer.drivetrain.drive(this.speed, 0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    if (
      RobotMap.rightMotorEncoder.getPosition() >= distance*this.calibrationFactor ||
      RobotMap.leftMotorEncoder.getPosition() >= distance*this.calibrationFactor
    ) {
      RobotContainer.drivetrain.stop();
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrain.stop();
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
}