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
    return runOnce(() -> {
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

  // Toggle & Open Piston
  public void openClaw() {
    RobotMap.clawPiston.set(DoubleSolenoid.Value.kForward);
  }

  // Un-Toggle & Close Piston
  public static void closeClaw() {
    RobotMap.clawPiston.set(DoubleSolenoid.Value.kReverse);
  }
}
