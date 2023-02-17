// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class MiniMe extends SubsystemBase {

  CANSparkMax actuator, follower;

  public MiniMe() {
    actuator = new CANSparkMax(RobotMap.actuator, MotorType.kBrushed);
    follower = new CANSparkMax(RobotMap.actuatorFollower, MotorType.kBrushed);

    //set slaves
    follower.follow(actuator);
    stop();
  }


  public void pull(boolean on){
    if (on) {
        this.actuator.set(1);
    }
  }
  public void push(boolean on){
    if (on) {
        this.actuator.set(-1);
    }
  }

  public void stop(){
    this.actuator.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}