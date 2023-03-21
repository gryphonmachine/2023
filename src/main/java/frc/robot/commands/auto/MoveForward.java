package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class MoveForward {

  public void drop() {
    double time = Timer.getFPGATimestamp();

    if (time - Robot.startTime < 3) {
      RobotMap.left.set(0.5);
      RobotMap.right.set(-0.5);
    } else {
      RobotMap.left.set(0);
      RobotMap.right.set(0);
      // RobotMap.left.stopMotor();
      // RobotMap.right.stopMotor();
    }
  }
}
