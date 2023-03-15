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
      // Drive forward until area of apriltag is certain value (limelight)
      new DriveDistance(10000, 0.05)
    );
    // (Maybe) Raise arm to highest cube position
    // (Maybe) Open clamps
    // Drive back onto charge station and dock (straight back, back and left, back and right)
    //
  }
}
