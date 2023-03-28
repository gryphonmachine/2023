package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class OI {

  // Initialize Xbox Controller
  public static final CommandXboxController controller = new CommandXboxController(
    0
  );

  // Drive Robot Forward (left side, Y axis)
  public static double getDriveJoystick() {
    return -controller.getLeftY();
  }

  // Turn Robot Left & Right (right side, X axis)
  public static double getTurnJoystick() {
    return -controller.getRightX();
  }
}
