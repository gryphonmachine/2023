// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.RobotContainer;

public class Arm extends SubsystemBase {

  CANSparkMax arm;

  public Arm() {
    arm = new CANSparkMax(RobotMap.arm, MotorType.kBrushed);
    stop();
  }

  // x pulls down & holds in place
  public void pull(){
    this.arm.set(-0.5);
  }

  // y key pushes up
  public void push(){
    this.arm.set(-0.2);
  }

  public void stop(){
    this.arm.stopMotor();
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