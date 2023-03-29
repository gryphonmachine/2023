package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.auto.ScoreCube;
import frc.robot.commands.auto.ScoreGamePiece;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  // Subsystems
  private final Drivetrain s_drivetrain = new Drivetrain();
  private final Claw s_claw = new Claw();
  private final Arm s_arm = new Arm();

  private static final String kAutoOne = "Auto One";
  private static final String kAutoTwo = "Auto Two";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    configureBindings();

    // SmartDashboard
    SmartDashboard.putData(m_chooser);

    m_chooser.setDefaultOption("Auto One", kAutoOne);
    m_chooser.addOption("Auto Two", kAutoTwo);

    SmartDashboard.putData("Auto choices", m_chooser);
  }

  // Xbox Controller Bindings
  private void configureBindings() {
    OI.controller.leftBumper().whileTrue(s_arm.pullArmCommand());
    OI.controller.rightBumper().whileTrue(s_arm.pushArmCommand());
    OI.controller.b().toggleOnTrue(s_claw.clawToggleCommand());
  }

  // Autonomous Routines
  public Command getAutonomousCommand() {
    m_autoSelected = m_chooser.getSelected();

    switch (m_autoSelected) {
      case kAutoOne:
        return ScoreGamePiece.run(s_drivetrain, s_arm, s_claw);
      case kAutoTwo:
        return ScoreCube.run(s_drivetrain);
      default:
        return ScoreGamePiece.run(s_drivetrain, s_arm, s_claw);
    }
  }
}
