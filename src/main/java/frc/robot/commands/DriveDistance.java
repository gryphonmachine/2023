package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {

  private final Drivetrain drivetrain;
  private final double speed;
  private final double distance;
  private double encoderValue = 0;
  private double calibrationFactor = 50 / 88.5;

  /**
   * @param distance inches
   */
  public DriveDistance(Drivetrain subsystem, double speed, double distance) {
    this.drivetrain = subsystem;
    this.speed = speed;
    this.distance = distance;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    drivetrain.setRightEncoder(0);
    drivetrain.setLeftEncoder(0);
  }

  @Override
  public void execute() {
    encoderValue = (Math.abs(drivetrain.getRightEncoder()) +
        Math.abs(drivetrain.getLeftEncoder())) /
        2;
    System.out.println(encoderValue);
    this.drivetrain.driveSolo(this.speed, this.speed);
    // this.drivetrain.driveArcade(this.speed, 0);

  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("DriveDistance Completed");
    drivetrain.stop();
  }

  @Override
  public boolean isFinished() {
    return encoderValue > this.distance * this.calibrationFactor;
  }
}
