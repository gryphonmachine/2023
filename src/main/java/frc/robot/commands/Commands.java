package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Robot;
public class Commands {
    public static final RunCommand drive = new RunCommand(() -> Robot.drivetrain.tankDrive(Robot.oi.driverController.getLeftY(), Robot.oi.driverController.getRightY()), Robot.drivetrain);
    public static final RunCommand stop = new RunCommand(() -> Robot.drivetrain.stop(), Robot.drivetrain);
}
