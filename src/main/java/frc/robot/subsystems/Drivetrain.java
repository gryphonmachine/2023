package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {

  private static final DifferentialDrive drivetrain = new DifferentialDrive(
    RobotMap.left,
    RobotMap.right
  );

  public Drivetrain() {
    stop();
  }

  public static void drive(double xSpeed, double zRotation) {
    drivetrain.arcadeDrive(xSpeed, zRotation);
  }

  public void stop() {
    drivetrain.stopMotor();
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
