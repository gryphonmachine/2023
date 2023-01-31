// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import com.kauailabs.navx.frc.AHRS;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  AHRS ahrs;
  Joystick stick;

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    stick = new Joystick(0);
      try {
          /* Communicate w/navX-MXP via the MXP SPI Bus.                                     */
          /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
          /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
          ahrs = new AHRS(SPI.Port.kMXP); 
      } catch (RuntimeException ex ) {
          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
      }
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    while (isEnabled()) {
          
      Timer.delay(0.020);		/* wait for one motor update time period (50Hz)     */
      
      boolean zero_yaw_pressed = stick.getTrigger();
      if ( zero_yaw_pressed ) {
          ahrs.zeroYaw();
      }

      /* Display 6-axis Processed Angle Data                                      */
      SmartDashboard.putBoolean(  "IMU_Connected",        ahrs.isConnected());
      SmartDashboard.putBoolean(  "IMU_IsCalibrating",    ahrs.isCalibrating());
      SmartDashboard.putNumber(   "IMU_Yaw",              ahrs.getYaw());
      SmartDashboard.putNumber(   "IMU_Pitch",            ahrs.getPitch());
      SmartDashboard.putNumber(   "IMU_Roll",             ahrs.getRoll());
      
      /* Display tilt-corrected, Magnetometer-based heading (requires             */
      /* magnetometer calibration to be useful)                                   */
      
      SmartDashboard.putNumber(   "IMU_CompassHeading",   ahrs.getCompassHeading());
      
      /* Display 9-axis Heading (requires magnetometer calibration to be useful)  */
      SmartDashboard.putNumber(   "IMU_FusedHeading",     ahrs.getFusedHeading());

      /* These functions are compatible w/the WPI Gyro Class, providing a simple  */
      /* path for upgrading from the Kit-of-Parts gyro to the navx-MXP            */
      
      SmartDashboard.putNumber(   "IMU_TotalYaw",         ahrs.getAngle());
      SmartDashboard.putNumber(   "IMU_YawRateDPS",       ahrs.getRate());

      /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
      
      SmartDashboard.putNumber(   "IMU_Accel_X",          ahrs.getWorldLinearAccelX());
      SmartDashboard.putNumber(   "IMU_Accel_Y",          ahrs.getWorldLinearAccelY());
      SmartDashboard.putBoolean(  "IMU_IsMoving",         ahrs.isMoving());
      SmartDashboard.putBoolean(  "IMU_IsRotating",       ahrs.isRotating());

      /* Display estimates of velocity/displacement.  Note that these values are  */
      /* not expected to be accurate enough for estimating robot position on a    */
      /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
      /* of these errors due to single (velocity) integration and especially      */
      /* double (displacement) integration.                                       */
      
      SmartDashboard.putNumber(   "Velocity_X",           ahrs.getVelocityX());
      SmartDashboard.putNumber(   "Velocity_Y",           ahrs.getVelocityY());
      SmartDashboard.putNumber(   "Displacement_X",       ahrs.getDisplacementX());
      SmartDashboard.putNumber(   "Displacement_Y",       ahrs.getDisplacementY());
      
      /* Display Raw Gyro/Accelerometer/Magnetometer Values                       */
      /* NOTE:  These values are not normally necessary, but are made available   */
      /* for advanced users.  Before using this data, please consider whether     */
      /* the processed data (see above) will suit your needs.                     */
      
      SmartDashboard.putNumber(   "RawGyro_X",            ahrs.getRawGyroX());
      SmartDashboard.putNumber(   "RawGyro_Y",            ahrs.getRawGyroY());
      SmartDashboard.putNumber(   "RawGyro_Z",            ahrs.getRawGyroZ());
      SmartDashboard.putNumber(   "RawAccel_X",           ahrs.getRawAccelX());
      SmartDashboard.putNumber(   "RawAccel_Y",           ahrs.getRawAccelY());
      SmartDashboard.putNumber(   "RawAccel_Z",           ahrs.getRawAccelZ());
      SmartDashboard.putNumber(   "RawMag_X",             ahrs.getRawMagX());
      SmartDashboard.putNumber(   "RawMag_Y",             ahrs.getRawMagY());
      SmartDashboard.putNumber(   "RawMag_Z",             ahrs.getRawMagZ());
      SmartDashboard.putNumber(   "IMU_Temp_C",           ahrs.getTempC());
      
      /* Omnimount Yaw Axis Information                                           */
      /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount  */
      AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
      SmartDashboard.putString(   "YawAxisDirection",     yaw_axis.up ? "Up" : "Down" );
      SmartDashboard.putNumber(   "YawAxis",              yaw_axis.board_axis.getValue() );
      
      /* Sensor Board Information                                                 */
      SmartDashboard.putString(   "FirmwareVersion",      ahrs.getFirmwareVersion());
      
      /* Quaternion Data                                                          */
      /* Quaternions are fascinating, and are the most compact representation of  */
      /* orientation data.  All of the Yaw, Pitch and Roll Values can be derived  */
      /* from the Quaternions.  If interested in motion processing, knowledge of  */
      /* Quaternions is highly recommended.                                       */
      SmartDashboard.putNumber(   "QuaternionW",          ahrs.getQuaternionW());
      SmartDashboard.putNumber(   "QuaternionX",          ahrs.getQuaternionX());
      SmartDashboard.putNumber(   "QuaternionY",          ahrs.getQuaternionY());
      SmartDashboard.putNumber(   "QuaternionZ",          ahrs.getQuaternionZ());
      
      /* Connectivity Debugging Support                                           */
      SmartDashboard.putNumber(   "IMU_Byte_Count",       ahrs.getByteCount());
      SmartDashboard.putNumber(   "IMU_Update_Count",     ahrs.getUpdateCount());
  }
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
