package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DriveDistance;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

/**
 * Auton Routine #1:
 * 
 * Pre-Setup:
 * - Have a cube placed on claw
 * 
 * Start:
 * - Jitter forwards for little distance, high speed so arm can lock into position
 * - Extends arm to top level of cube stand, opens claw, & drops cube (6 pts)
 * - Retracts arm & moves backward (out of community) for mobility points (3pts)
 * 
 * Total: 9 pts
 */
public final class ScoreGamePiece {

  public static CommandBase run(Drivetrain drivetrain, Arm arm, Claw claw) {
    return Commands.sequence(
      new DriveDistance(drivetrain, 0.05, 5),
      arm.pushArmCommand().withTimeout(0.25),
      arm.stopArmCommand(),
      claw.clawToggleCommand(),
      arm.pullArmCommand().withTimeout(0.25),
      new DriveDistance(drivetrain, -0.05, 5)
    );
  }

  private ScoreGamePiece() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
