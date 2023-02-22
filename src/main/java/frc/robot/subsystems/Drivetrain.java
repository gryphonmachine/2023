// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {

  CANSparkMax right, left;
  CANSparkMax rightSlave, leftSlave; 

  public Drivetrain() {
    right = new CANSparkMax(RobotMap.right, MotorType.kBrushless);
    left = new CANSparkMax(RobotMap.left, MotorType.kBrushless);
    rightSlave = new CANSparkMax(RobotMap.rightFollower, MotorType.kBrushless);
    leftSlave = new CANSparkMax(RobotMap.leftFollower, MotorType.kBrushless);

    //set slaves
    rightSlave.follow(right);
    leftSlave.follow(left);
    stop();
  }


  public void tankDrive(double left, double right){
    this.left.set(left);
    this.right.set(right);
  }

  public void stop(){
    left.stopMotor();
    right.stopMotor();
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