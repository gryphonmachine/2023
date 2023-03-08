/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class DriveDistance extends CommandBase {

    final double distance;
    final double speed;

    public DriveDistance(double distance, double speed) {
        addRequirements(RobotContainer.drivetrain);
        this.speed = speed;
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        RobotMap.rightMotorEncoder.setPosition(0);
        RobotMap.leftMotorEncoder.setPosition(0);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        try {
            if (RobotMap.rightMotorEncoder.equals(distance) ||RobotMap.leftMotorEncoder.equals(distance) ) {end(true);}
            RobotContainer.drivetrain.tankDrive(speed, speed);
        }
        catch(Exception e) {
            System.out.println("DriveDistance exception:");
            e.printStackTrace();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        RobotContainer.drivetrain.stop();
        return true;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        RobotContainer.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
}