package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Arm;

public class StartArm extends CommandBase {

  Arm arm = RobotContainer.arm;

  public StartArm() {
    addRequirements(RobotContainer.arm);
  }

  @Override
  public void execute() {
    if (OI.dropArmButton.getAsBoolean()) {
      arm.pull();
    } else if (OI.liftArmButton.getAsBoolean()) {
      arm.push();
    } else {
      arm.stop();
    }
  }
}
