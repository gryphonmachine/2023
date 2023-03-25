package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.auto.util.DriveDistance;

public class Robot extends TimedRobot {

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

    RobotMap.right.setInverted(true);
    RobotMap.left.setInverted(true);

    // Drive forward for x seconds
    while (timer.get() < RobotMap.FORWARD_TIME) {
      RobotMap.right.set(RobotMap.FORWARD_SPEED);
      RobotMap.left.set(-RobotMap.FORWARD_SPEED);
    }

    RobotMap.right.set(0);
    RobotMap.left.set(0);
    // Timer.delay(1);

    RobotMap.right.setInverted(false);
    RobotMap.left.setInverted(false);

    // Drive backward for 3 seconds
    timer.reset();
    timer.start();


    // while (timer.get() < RobotMap.BACKWARD_TIME) {
    //   RobotMap.right.set(-RobotMap.BACKWARD_SPEED);
    //   RobotMap.left.set(RobotMap.BACKWARD_SPEED);
    // }

    // Turn motors off
    RobotMap.right.set(0);
    RobotMap.left.set(0);
  }

  @Override
  public void autonomousPeriodic() {
    
    new DriveDistance(1,0.1);
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
