package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  // Autonomous: Motor Speeds
  private static final double FORWARD_SPEED = 0.2;
  private static final double FORWARD_TIME = 5.0; // seconds

  // private static final double BACKWARD_SPEED = -0.2;
  // private static final double BACKWARD_TIME = 5.0; // seconds

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

  @Override
  public void autonomousInit() {
    Timer timer = new Timer();
    timer.reset();
    timer.start();

    // Drive forward for x seconds
    while (timer.get() < FORWARD_TIME) {
      RobotMap.right.set(-FORWARD_SPEED);
      RobotMap.left.set(-FORWARD_SPEED);
    }

    // RobotMap.right.set(0);
    // RobotMap.left.set(0);
    // Timer.delay(1);

    // // Drive backward for 3 seconds
    // timer.reset();
    // timer.start();
    // while (timer.get() < BACKWARD_TIME) {
    //   RobotMap.right.set(BACKWARD_SPEED);
    //   RobotMap.left.set(BACKWARD_SPEED);
    // }

    // Turn motors off
    RobotMap.right.set(0);
    RobotMap.left.set(0);
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
