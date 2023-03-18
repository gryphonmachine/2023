// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Pneumatics extends SubsystemBase {

  public Pneumatics() {

    closeClaw();
    RobotMap.pcmCompressor.enableDigital();
  }

  @Override
  public void periodic() {
    double rawVoltage = RobotMap.pressureSensor.getVoltage();
    double pressure = (rawVoltage-0.47)*(110/(2.7-0.47));
    // 110 -> 2.7
    // 0 -> 0.47

    System.out.println("Pressure " + pressure);
    if (pressure > 70) {
      System.out.println("Disabling");
      RobotMap.pcmCompressor.disable();
    } else if (pressure < 40) {
      System.out.println("Enabling");
      RobotMap.pcmCompressor.enableDigital();
    }
    // This method will be called once per scheduler run
  }

  public void toggleClaw() {
    RobotMap.claw.toggle();
  }

  public void openClaw() {
    RobotMap.claw.set(Value.kForward);
  }

  public void closeClaw() {
    RobotMap.claw.set(Value.kReverse);
  }
}
