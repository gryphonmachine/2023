// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Arm extends SubsystemBase {

  CANSparkMax arm;

  public Arm() {
    stop();
  }

  // x pulls down & holds in place
  public void pull() {
    RobotMap.arm.set(-1);
  }

  // y key pushes up\
  public void push() {
    RobotMap.arm.set(1);
  }

  public void keep() {
    RobotMap.arm.set(0.3);
  }

  public void stop() {
    RobotMap.arm.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(RobotMap.getLimelightArea()); 
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
