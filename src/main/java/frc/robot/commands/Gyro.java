package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class Gyro {

  private static AHRS gyro = new AHRS(SPI.Port.kMXP);

  public static void calibrate() {
    gyro.calibrate();
  }

  public static void reset() {
    gyro.reset();
  }
}
