package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.BalanceBot;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.Drivetrain;

/**
 * Auton Routine #2:
 *
 * Pre-Setup:
 * - Have a cube placed on the edge of the bot (on the back side)
 *
 * Start:
 * - Move robot forwards at a high speed so cube falls off
 * - Exit community for mobility (3 pts)
 * - Return back to the community and push cube into lower level (3 pts)
 *
 * Total: 6 pts
 */
public final class ScoreCube {

  public static CommandBase run(Drivetrain drivetrain) {
    return Commands.sequence(
      // Drive forward for a bit with high speed so cube falls off
      new DriveDistance(drivetrain, 0.5, 10),
      new WaitCommand(0.5),
      // Drive backwards to push cube back into lower level
      new DriveDistance(drivetrain, -0.5, 15),
      new WaitCommand(1),
      // Drive robot backwards
      new DriveDistance(drivetrain, 0.5, 115),
      new BalanceBot(drivetrain)
    );
  }

  private ScoreCube() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
