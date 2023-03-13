package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class GyroTurn extends CommandBase {
  
  private PIDController pid;
  private final double kP;
  private final double kI;
  private final double kD;
  private final double setpoint;

  public GyroTurn(double setpoint, double kP, double kI, double kD) {
    // Store the setpoint and PID gains
    
    this.setpoint = RobotMap.gyro.getAngle() + setpoint;
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    // Require the drivetrain subsystem
    addRequirements(RobotContainer.drivetrain);
  }

  @Override
  public void initialize() {
    // Initialize the PID controller with the gains and setpoint
    pid = new PIDController(this.kP, this.kI, this.kD);
    pid.setTolerance(5, 10);
    pid.setIntegratorRange(-0.5, 0.5);

  }
  

  // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        double speedAmount = pid.calculate(RobotMap.gyro.getAngle(), this.setpoint);
        System.out.println(this.setpoint - RobotMap.gyro.getAngle());
        double bounded = MathUtil.clamp(speedAmount, -0.1, 0.1);
        RobotContainer.drivetrain.tankDrive(bounded, -bounded);
    }

  @Override
  public boolean isFinished() {
    // Return true when the PID controller is on target
    return pid.atSetpoint();
  }

  @Override
  public void end(boolean interrupted) {
    // Stop the PID controller and the drivetrain
    RobotContainer.drivetrain.stop();
  }
}
