/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class AlignWithTag extends CommandBase {

  final double deadzone;
  public double targetArea;
  public double setPointArea;

  // private PIDController pid;

  public AlignWithTag(double setPointArea, double deadzone) {
    addRequirements(RobotContainer.drivetrain);
    this.setPointArea = setPointArea;
    this.deadzone = deadzone;
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    System.out.println("Initializing tag alignment");
    // pid = new PIDController(0.1, 0, 0);
    // pid.setTolerance(5, 10);
    // pid.setIntegratorRange(-0.5, 0.5);
    System.out.println("Target Area:" + targetArea);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    System.out.println(RobotMap.rightMotorEncoder.getPosition());

    // double speedAmount = pid.calculate(RobotMap.gyro.getAngle(), this.targetArea);
    // double bounded = MathUtil.clamp(speedAmount, -0.1, 0.1);
    RobotContainer.drivetrain.tankDrive(0.1, 0.1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return this.targetArea >= this.setPointArea;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    RobotContainer.drivetrain.stop();
  }
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
}
