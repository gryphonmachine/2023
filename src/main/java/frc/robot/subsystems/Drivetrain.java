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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  CANSparkMax rightLeader, leftLeader;
  CANSparkMax rightFollower, leftFollower; 

  public Drivetrain() {
    rightLeader = new CANSparkMax(RobotMap.RIGHT_LEADER, MotorType.kBrushless);
    leftLeader = new CANSparkMax(RobotMap.LEFT_LEADER, MotorType.kBrushless);
    rightFollower = new CANSparkMax(RobotMap.RIGHT_FOLLOWER, MotorType.kBrushless);
    leftFollower = new CANSparkMax(RobotMap.LEFT_FOLLOWER, MotorType.kBrushless);

    //set brakemode

    //set slaves
    rightFollower.follow(rightLeader);
    leftFollower.follow(leftLeader);
    stop();
    setDefaultCommand(Commands.stop);
  }


  public void tankDrive(double left, double right){
    this.leftLeader.set(left);
    this.rightLeader.set(right);
  }

  public void stop(){
    leftLeader.stopMotor();
    rightLeader.stopMotor();
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
