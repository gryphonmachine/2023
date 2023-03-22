package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {

  private static final XboxController driverController = new XboxController(0);

  public static final int BUTTON_B = 2;
  public static final int LBUMPER = 5;
  public static final int RBUMPER = 6;
  public static final int BUTTON_RSTICK = 10;

  public static JoystickButton liftArmButton = new JoystickButton(
    driverController,
    LBUMPER
  );

  public static JoystickButton dropArmButton = new JoystickButton(
    driverController,
    RBUMPER
  );

  public static JoystickButton solenoidToggleButton = new JoystickButton(
    driverController,
    BUTTON_B
  );

  public static double getRightX() {
    return driverController.getRightX();
  }

  public static double getLeftY() {
    return driverController.getLeftY();
  }
}
