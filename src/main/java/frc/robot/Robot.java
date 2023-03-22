package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;

public class Robot extends TimedRobot {

  // Autonomous: Motor Speeds
  private static final double FORWARD_SPEED = 0.2; // Speed to move forward at
  // private static final double BACKWARD_SPEED = -0.2; // Speed to move backward at
  private static final double FORWARD_TIME = 3.0; // Time to move forward in seconds

  // private static final double BACKWARD_TIME = 5.0; // Time to move backward in seconds

  @Override
  public void robotInit() {
    RobotMap.start();
    new RobotContainer();

    // Camera Feed
    UsbCamera LifeCam = CameraServer.startAutomaticCapture();
    LifeCam.setResolution(320, 240);
    LifeCam.setFPS(30);
    CameraServer.putVideo("LifeCam Feed", 320, 240);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /**
   * Autonomous Routine:
   * Move robot forwards for X seconds to pass community zone at X speed,
   * then turns 180 degrees getting ready for teleop
   *
   * Points Gained: 3
   *
   * ---------------------------
   *
   * Score a cube or cone on top row
   * Note: Game pieces come pre-loaded onto the arm, nothing has to be picked up
   *
   * Points Gained: 6
   *
   * Total Autonomous Points: 9
   */
  @Override
  public void autonomousInit() {
    Timer timer = new Timer();
    timer.reset();
    timer.start();

    // Drive forward for x seconds
    while (timer.get() < FORWARD_TIME) {
      RobotMap.right.set(-FORWARD_SPEED);
      RobotMap.left.set(FORWARD_SPEED);
    }

    // Turn robot 180 degrees
    Drivetrain.tankDrive(FORWARD_SPEED, 0.5);

    // Turn motors off
    RobotMap.right.set(0);
    RobotMap.left.set(0);
    // Stop for 1 second
    // RobotMap.right.set(0);
    // RobotMap.left.set(0);
    // Timer.delay(1);

    // // Drive backward for 3 seconds
    // timer.reset();
    // timer.start();
    // while (timer.get() < BACKWARD_TIME) {
    //   RobotMap.right.set(-BACKWARD_SPEED);
    //   RobotMap.left.set(BACKWARD_SPEED);
    // }
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
