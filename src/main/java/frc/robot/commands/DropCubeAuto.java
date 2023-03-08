package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class DropCubeAuto extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param hatch The hatch subsystem this command will run on
   */
  public DropCubeAuto() {
    addCommands(
        // Drive forward the specified distance
        new DriveDistance(100, 0.4));
  }
}
