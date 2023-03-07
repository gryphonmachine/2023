package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.OI;

public class StartActuators extends CommandBase {
    public StartActuators() {
        addRequirements(RobotContainer.miniMe);
      }
    
      // Called when the command is initially scheduled.
      @Override
      public void initialize() {}
    
      // Called every time the scheduler runs while the command is scheduled.
      @Override
      public void execute() {
        if(OI.pullButton.getAsBoolean()) {
          RobotContainer.miniMe.pull();
        } else if(OI.pushButton.getAsBoolean()) {
          RobotContainer.miniMe.push();
        } else {
          RobotContainer.miniMe.stop();
        }
      }
    
      // Called once the command ends or is interrupted.
      @Override
      public void end(boolean interrupted) {}
    
      // Returns true when the command should end.
      @Override
      public boolean isFinished() {
        return false;
      }
}
