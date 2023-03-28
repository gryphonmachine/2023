package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Arm extends SubsystemBase {
  public Arm() {
    setDefaultCommand(stopArmCommand());
  }

  public CommandBase pullArmCommand() {
    return run(
        () -> {
          this.pull();
        });
  }

  public CommandBase pushArmCommand() {
    return run(
        () -> {
          this.push();
        });
  }

  public CommandBase stopArmCommand() {
    return runOnce(
        () -> {
          this.stop();
        });
  }

  public void pull() {
    RobotMap.arm.set(-1);
  }

  public void push() {
    RobotMap.arm.set(1);
  }

  public void stop() {
    RobotMap.arm.stopMotor();
  }
}
