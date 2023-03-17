package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** A complex auto command that drives forward, releases a hatch, and then drives backward. */
public class ChargeStationMovements extends SequentialCommandGroup {

  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param hatch The hatch subsystem this command will run on
   */
  public ChargeStationMovements() {
    addCommands(
      // Drive b ack until gyro angle exceeds threshold
      new DriveUntilAngle(12, -0.3),
      new DriveUntilAngle(0, -0.15)
      // Drive back until gyro angle goes back to 90.
    );
  }
}
