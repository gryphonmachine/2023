package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Pneumatics extends SubsystemBase {

  public Pneumatics() {
    RobotMap.pcmCompressor.enableDigital();
  }

  @Override
  public void periodic() {
    double rawVoltage = RobotMap.pressureSensor.getVoltage();
    double pressure = (rawVoltage - 0.47) * (110 / (2.7 - 0.47));
    System.out.println("Pressure: " + pressure);

    if (pressure > 30) {
      System.out.println("Disabling Compressor");
      RobotMap.pcmCompressor.disable();
    } else if (pressure < 30) {
      System.out.println("Enabling Compressor");
      RobotMap.pcmCompressor.enableDigital();
    }
  }

  public void toggleClaw() {
    if (RobotMap.claw.get() == DoubleSolenoid.Value.kForward) {
      closeClaw();
    } else {
      openClaw();
    }
  }

  public static void openClaw() {
    RobotMap.claw.set(DoubleSolenoid.Value.kForward);
  }

  public static void closeClaw() {
    RobotMap.claw.set(DoubleSolenoid.Value.kReverse);
  }
}
