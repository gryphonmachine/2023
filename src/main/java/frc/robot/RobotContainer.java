package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;

public class RobotContainer {

  // The robot's subsystems and commands
  public static Drivetrain drivetrain;
  public static Arm arm;
  public static Pneumatics pneumatics;
  public static DigitalInput armSwitch;

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  // The container for the robot. Contains subsystems, OI devices, and commands.
  public RobotContainer() {
    drivetrain = new Drivetrain();
    arm = new Arm();
    pneumatics = new Pneumatics();

    drivetrain.setDefaultCommand(new StartDriving());
    arm.setDefaultCommand(new StartArm());
    pneumatics.setDefaultCommand(new StartPneumatics());
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
    // return new AlignWithTag(15, 3); //TODO: Add deadzone
    // return new GyroTurn(90, 0.1, 0.0, 0.02);
    // return new DriveDistance(4,0.05);
    // return new DropCubeAuto();
  }
}
