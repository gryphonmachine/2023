// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class MiniMe extends SubsystemBase {

  public MiniMe() {
    stop();
  }

  public void pull() {
    if (!RobotMap.armSwitch.get()) {
      RobotMap.actuator.set(-1);
    } else {
      RobotMap.actuator.set(1);
    }
  }

  public void push() {
    if (!RobotMap.actuatorSwitch.get()) {
      RobotMap.actuator.set(1);
    } else {
      RobotMap.actuator.set(-1);
    }
  }

  public void stop() {
    RobotMap.actuator.stopMotor();
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
