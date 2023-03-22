package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Arm extends SubsystemBase {

  public Arm() {
    stop();
  }

  public void pull() {
    RobotMap.arm.set(-1);
  }

  public void push() {
    RobotMap.arm.set(1);
  }

  public void stop() {
    RobotMap.arm.stopMotor();
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}
}
