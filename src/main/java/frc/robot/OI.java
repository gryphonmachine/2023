// Operator Interface
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {

  public static XboxController driverController = new XboxController(0);

  public static final class ControllerMap {

    public static final int LSTICK_X_AXIS = 0;
    public static final int LSTICK_Y_AXIS = 1;
    public static final int RSTICK_X_AXIS = 4;
    public static final int RSTICK_Y_AXIS = 5;
    public static final int LTRIGGER = 2;
    public static final int RTRIGGER = 3;

    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int LBUMPER = 5;
    public static final int RBUMPER = 6;
    public static final int BUTTON_BACK = 7;
    public static final int BUTTON_START = 8;
    public static final int BUTTON_LSTICK = 9;
    public static final int BUTTON_RSTICK = 10;
  }

  public static JoystickButton solenoidButton = new JoystickButton(
    driverController,
    ControllerMap.BUTTON_A
  );
  public static JoystickButton solenoidOffButton = new JoystickButton(
    driverController,
    ControllerMap.BUTTON_B
  );
  public static JoystickButton liftArmButton = new JoystickButton(
    driverController,
    ControllerMap.LBUMPER
  );
  public static JoystickButton dropArmButton = new JoystickButton(
    driverController,
    ControllerMap.RBUMPER
  );
  public static JoystickButton pushButton = new JoystickButton(
    driverController,
    ControllerMap.BUTTON_X
  );
  public static JoystickButton pullButton = new JoystickButton(
    driverController,
    ControllerMap.BUTTON_Y
  );

  public static double getYLeft() {
    return driverController.getLeftY();
  }

  public static double getYRight() {
    return driverController.getRightY();
  }
}
