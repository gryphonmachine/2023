package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CalibrateGyro extends CommandBase {
  public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

  public void execute() {
    gyro.calibrate();
  }
}