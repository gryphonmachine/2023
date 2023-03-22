package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;

public class StartPneumatics extends CommandBase {

  private boolean previousValue;

  public StartPneumatics() {
    addRequirements(RobotContainer.pneumatics);
  }

  @Override
  public void execute() {
    boolean currentValue = OI.solenoidToggleButton.getAsBoolean();

    if (currentValue && !previousValue) {
      RobotContainer.pneumatics.toggleClaw();
    }

    previousValue = currentValue;
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
