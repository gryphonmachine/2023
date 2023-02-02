// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drivetrain extends SubsystemBase {

  TalonSRX rightLeader, leftLeader;
  VictorSPX rightFollower, leftFollower; 

  public Drivetrain() {
    rightLeader = new TalonSRX(RobotMap.RIGHT_LEADER);
    leftLeader = new TalonSRX(RobotMap.LEFT_LEADER);
    rightFollower = new VictorSPX(RobotMap.RIGHT_FOLLOWER);
    leftFollower = new VictorSPX(RobotMap.LEFT_FOLLOWER);

    //set brakemode
    rightLeader.setNeutralMode(NeutralMode.Brake);
    leftLeader.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Brake);
    leftFollower.setNeutralMode(NeutralMode.Brake);

    //set slaves
    rightFollower.follow(rightLeader);
    leftFollower.follow(leftLeader);
    stop();
    setDefaultCommand(Commands.stop);
  }


  public void tankDrive(double left, double right){
    this.leftLeader.set(ControlMode.PercentOutput, left);
    this.rightLeader.set(ControlMode.PercentOutput, right);
  }

  public void stop(){
    leftLeader.set(ControlMode.PercentOutput, 0);
    rightLeader.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
