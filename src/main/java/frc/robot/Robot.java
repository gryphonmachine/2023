package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.auto.ChargeStationMovements;

public class Robot extends TimedRobot {

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;
  public static NetworkTable limelight;
  public static NetworkTableEntry ll_x;
  public static NetworkTableEntry ll_y;

  private static final String kChargeStationAuto = "Charge Station";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // Runs when the robot is first started up
  @Override
  public void robotInit() {
    RobotMap.init();
    m_robotContainer = new RobotContainer();
    limelight = NetworkTableInstance.getDefault().getTable("limelight");
    ll_x = limelight.getEntry("tx");
    ll_y = limelight.getEntry("ty");
    CameraServer.startAutomaticCapture();

    SmartDashboard.putData("Calibrate Robot", RobotMap.calibrateGyro);
    SmartDashboard.putData(m_chooser);

    m_chooser.setDefaultOption("Charge Station Auto", kChargeStationAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    System.out.println(RobotMap.getLimelightArea());
  }

  @Override
  public void disabledPeriodic() {
    System.out.println(RobotMap.getLimelightArea());
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto Mode selected: " + m_autoSelected);

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kChargeStationAuto:
        new ChargeStationMovements();
        break;
    }
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    DriverStation.reportWarning(
      "Calibrating IMU. Please do not move the robot.",
      true
    );
    Timer.delay(3);
    DriverStation.reportWarning("Finished Calibrating IMU.", true);
  }

  @Override
  public void teleopPeriodic() {
    if (isEnabled()) {
      double x = ll_x.getDouble(0.0);
      double y = ll_y.getDouble(0.0);
      SmartDashboard.putNumber("LimelightX", x);
      SmartDashboard.putNumber("LimelightY", y);
    }
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}