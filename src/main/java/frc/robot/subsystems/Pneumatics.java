// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Pneumatics extends SubsystemBase {

  //   Compressor pcmCompressor;

  /** Creates a new Chassis. */
  public Pneumatics() {
    // Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

    // pcmCompressor.enableAnalog(0, 130);
    // pcmCompressor.disable();

    // boolean enabled = pcmCompressor.isEnabled();
    // boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
    // double current = pcmCompressor.getCurrent();

    // doublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,1);
    // doublePCM.set(Value.kReverse);
    // pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    solenoidBack();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void solenoidForward() {
    RobotMap.doublePCM.set(Value.kForward);
    // pcmCompressor.enableDigital();
  }

  public void solenoidBack() {
    RobotMap.doublePCM.set(Value.kReverse);
    // pcmCompressor.disable();
  }
}
