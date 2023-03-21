package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {

  public static XboxController driverController = new XboxController(0);

  public static double getRightX() {
    return driverController.getRightX();
  }

  public static double getLeftY() {
    return driverController.getLeftY();
  }
}
