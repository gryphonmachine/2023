package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;


public class Claw extends SubsystemBase {
    public Claw() {
        openClaw();
    }

    public CommandBase clawToggleCommand() {
    return runOnce(
        () -> {
            this.toggleClaw();
        });
    }

  public void toggleClaw() {
    if (RobotMap.clawPiston.get() == DoubleSolenoid.Value.kForward) {
      closeClaw();
    } else {
      openClaw();
    }
  }

  public static void openClaw() {
    RobotMap.clawPiston.set(DoubleSolenoid.Value.kForward);
  }

  public static void closeClaw() {
    RobotMap.clawPiston.set(DoubleSolenoid.Value.kReverse);
  }
}
