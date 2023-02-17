package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

    private CANSparkMax leftMotor = new CANSparkMax (RobotMap.LEFT_LEADER, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax rightMotor = new CANSparkMax (RobotMap.RIGHT_LEADER, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax leftFollower = new CANSparkMax (RobotMap.LEFT_FOLLOWER, CANSparkMaxLowLevel.MotorType.kBrushless);
    private CANSparkMax rightFollower = new CANSparkMax (RobotMap.RIGHT_FOLLOWER, CANSparkMaxLowLevel.MotorType.kBrushless);

    public DriveTrain () {
        leftFollower.follow(leftMotor);
        rightFollower.follow(rightMotor);
    }    
    
    public void drive(double leftSpeed, double rightSpeed) {
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
        // set to any double value to drive
    }

    public void stop() {
        leftMotor.set(0);
        rightMotor.set(0);
    }
    
    // drive
    // stop


}
