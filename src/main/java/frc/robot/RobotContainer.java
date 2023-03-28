package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.ScoreGamePiece;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  // Subsystems
  private final Drivetrain s_drivetrain = new Drivetrain();
  private final Claw s_claw = new Claw();
  private final Arm s_arm = new Arm();

  public RobotContainer() {
    configureBindings();
  }

  // Xbox Controller Bindings
  private void configureBindings() {
    OI.controller.leftBumper().whileTrue(s_arm.pullArmCommand());
    OI.controller.rightBumper().whileTrue(s_arm.pushArmCommand());
    OI.controller.b().toggleOnTrue(s_claw.clawToggleCommand());
  }

  // Autonomous Routines
  public Command getAutonomousCommand() {
    return ScoreGamePiece.run(s_drivetrain, s_arm, s_claw);
  }
}
