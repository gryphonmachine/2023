package frc.robot.commands.auto.util;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveDistance {

  private static final double WHEEL_DIAMETER = 6; // inches
  private static final double ENCODER_TICKS_PER_REV = 1024;
  private static final double GEAR_RATIO = 1;
  private static final double DISTANCE_PER_TICK =
    (Math.PI * WHEEL_DIAMETER) / (ENCODER_TICKS_PER_REV * GEAR_RATIO);

  private Encoder leftEncoder;
  private Encoder rightEncoder;
  private DifferentialDrive robotDrive;

  public DriveDistance(
    Encoder leftEncoder,
    Encoder rightEncoder,
    DifferentialDrive robotDrive
  ) {
    this.leftEncoder = leftEncoder;
    this.rightEncoder = rightEncoder;
    this.robotDrive = robotDrive;
  }

  public void drive(double distance) {
    double targetTicks = distance / DISTANCE_PER_TICK;
    double initialLeftTicks = leftEncoder.get();
    double initialRightTicks = rightEncoder.get();
    double leftSpeed = 0.5;
    double rightSpeed = 0.5;

    while (
      Math.abs(leftEncoder.get() - initialLeftTicks) < Math.abs(targetTicks) ||
      Math.abs(rightEncoder.get() - initialRightTicks) < Math.abs(targetTicks)
    ) {
      robotDrive.tankDrive(leftSpeed, rightSpeed);
    }

    robotDrive.stopMotor();
  }
}
