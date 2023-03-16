// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.StartPneumatics;
import frc.robot.commands.StartDriving;
// import frc.robot.commands.StartActuators;
import frc.robot.commands.StartArm;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Drivetrain;
// import frc.robot.subsystems.MiniMe;
import frc.robot.subsystems.Arm;
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
  // public static MiniMe miniMe;
  public static Arm arm; 
  public static Pneumatics pneumatics;
  public static DigitalInput actuatorSwitch;
  public static DigitalInput armSwitch;

  public static XboxController xbox;
  public static XboxController xbox1;
  public static JoystickButton solenoidButton;
  public static JoystickButton solenoidOffButton;
  // public static JoystickButton pushButton;
  // public static JoystickButton pullButton;
  public static JoystickButton liftArmButton;
  public static JoystickButton dropArmButton;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    drivetrain = new Drivetrain();
    // miniMe = new MiniMe();
    arm = new Arm();
    pneumatics = new Pneumatics();
    actuatorSwitch = new DigitalInput(1);
    armSwitch = new DigitalInput(7);

    configureButtonBindings();

    drivetrain.setDefaultCommand(new StartDriving());
    // miniMe.setDefaultCommand(new StartActuators());
    arm.setDefaultCommand(new StartArm());
    pneumatics.setDefaultCommand(new StartPneumatics());
  }

  public static double getYLeft(){
    double kleft = xbox.getLeftY();
    if(Math.abs(kleft) <= 0.1){
      return 0;
    } else {
      return -kleft*Math.abs(kleft); //Math.abs to preserve sign
    }
  }

  public static double getYRight(){
    double kright = xbox.getRightY();
    if(Math.abs(kright) <= 0.1){
      return 0;
    } else {
      return kright*Math.abs(kright); //Math.abs to preserve sign
    }
  }

  public static boolean getSolenoidButton() {
    return solenoidButton.getAsBoolean();
  }

  public static boolean getSolenoidOffButton() {
    return solenoidOffButton.getAsBoolean();
  }

  // public static boolean getPushButton() {
  //   return pushButton.getAsBoolean();
  // }

  // public static boolean getPullButton() {
  //   return pullButton.getAsBoolean();
  // }

  public static boolean getLiftArmButton() {
    return liftArmButton.getAsBoolean();
  }
  
  public static boolean getDropArmButton() {
    return dropArmButton.getAsBoolean();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    xbox = new XboxController(0);
    xbox1 = new XboxController(1);

    solenoidButton = new JoystickButton(xbox, 1);
    solenoidOffButton = new JoystickButton(xbox, 2);
    liftArmButton = new JoystickButton(xbox, 5);
    dropArmButton = new JoystickButton(xbox, 6);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new StartDriving();
  }
}
