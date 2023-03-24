package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {

  private static final XboxController driverController = new XboxController(0);

  public static final class ControllerMap {

    public static final int B = 2; // button b
    public static final int LB = 5; // left bumper
    public static final int RB = 6; // right bumper
    public static final int BUTTON_RSTICK = 10;
  }

  public static JoystickButton dropArmButton = new JoystickButton(
    driverController,
    ControllerMap.LB
  );

  public static JoystickButton liftArmButton = new JoystickButton(
    driverController,
    ControllerMap.RB
  );

  public static JoystickButton solenoidToggleButton = new JoystickButton(
    driverController,
    ControllerMap.B
  );

  public static double getRightX() {
    return driverController.getRightX();
  }

  public static double getLeftY() {
    return driverController.getLeftY();
  }
}
