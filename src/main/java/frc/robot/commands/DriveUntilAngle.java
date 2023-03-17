package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveUntilAngle extends CommandBase {
  
  private PIDController pid;
  private final double speed;
  private final double setpoint;

  public DriveUntilAngle(double setpoint, double speed) {
    // Store the setpoint and PID gains
    
    this.setpoint = RobotMap.gyro.getRoll() + setpoint; // this boutta be a prolem (set it to only setpoint)
    this.speed = speed;
    // Require the drivetrain subsystem
    addRequirements(RobotContainer.drivetrain);
  }

  @Override
  public void initialize() {
    // Initialize the PID controller with the gains and setpoint
    
    System.out.println("Moving back until angle exceeds " + this.setpoint);
  }
  

  // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
      System.out.println(RobotMap.gyro.getRoll());
      RobotContainer.drivetrain.tankDrive(this.speed, this.speed);
    }

  @Override
  public boolean isFinished() {
    return (this.setpoint - 2 < RobotMap.gyro.getRoll() && RobotMap.gyro.getRoll() < this.setpoint + 3);
    // Return true when the PID controller is on target
    // return pid.atSetpoint();
  }

  @Override
  public void end(boolean interrupted) {
    // Stop the PID controller and the drivetrain
    RobotContainer.drivetrain.stop();
  }
}
