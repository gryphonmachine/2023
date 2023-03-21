package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.Drivetrain;

public class RobotContainer {

  public static Drivetrain drivetrain;
  public static DigitalInput armSwitch;

  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    drivetrain = new Drivetrain();
    drivetrain.setDefaultCommand(new StartDriving());
  }
}
