// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.StartPneumatics;
import frc.robot.commands.StartDriving;
import frc.robot.commands.StartActuators;
import frc.robot.commands.StartArm;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Vision;
import frc.robot.subsystems.MiniMe;
import frc.robot.subsystems.Arm;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Drivetrain drivetrain;
  public static MiniMe miniMe;
  public static Arm arm; 
  public static Pneumatics pneumatics;
  public static Vision vision;
  public static DigitalInput actuatorSwitch;
  public static DigitalInput armSwitch;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    drivetrain = new Drivetrain();
    miniMe = new MiniMe();
    arm = new Arm();
    pneumatics = new Pneumatics();
    vision = new Vision();
    // actuatorSwitch = new DigitalInput(1);
    // armSwitch = new DigitalInput(7);

    drivetrain.setDefaultCommand(new StartDriving());
    miniMe.setDefaultCommand(new StartActuators());
    arm.setDefaultCommand(new StartArm());
    pneumatics.setDefaultCommand(new StartPneumatics());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AlignWithTag(15, 3); //TODO: Add deadzone
    // return new GyroTurn(90, 0.1, 0.0, 0.02);
    // return new DriveDistance(4,0.05);
    // return new DropCubeAuto();
  }
}
