package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
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
 * - Jitter forwards for little distance, high speed so arm can lock into
 * position
 * - Extends arm to top level of cube stand, opens claw, & drops cube (6 pts)
 * - Retracts arm & moves backward (out of community) for mobility points (3pts)
 *
 * Total: 9 pts
 */
public final class ChargeStation {

    public static CommandBase run(Drivetrain drivetrain, Arm arm, Claw claw) {
        return Commands.sequence(
                // Start with claw closed
                claw.clawToggleCommand(),
                // Jitter robot forwards so arm locks into place
                new DriveDistance(drivetrain, 0.25, 10),
                new WaitCommand(0.5),
                // Extend arm out
                arm.pushArmCommand().withTimeout(1),
                arm.stopArmCommand(),
                // Open claw
                claw.clawToggleCommand(),
                new WaitCommand(0.5),
                // Retract arm
                arm.pullArmCommand().withTimeout(1),
                arm.stopArmCommand(),
                new WaitCommand(0.5),
                // Drive robot backwards
                new DriveDistance(drivetrain, -0.5, 150),
                new WaitCommand(0.5),
                // Drive robot onto charge station
                new DriveDistance(drivetrain, 0.5, 80));
    }

    private ChargeStation() {
        throw new UnsupportedOperationException("This is a utility class!");
    }
}