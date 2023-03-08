package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandGroupBase;

public class OneCubeAuto extends CommandGroupBase {

    public OneCubeAuto() {
        
    }

    @Override
    protected void initialize() {
        Robot.climbingEntry.setBoolean(true);
        Robot.logger.logInfoFine("Auto climb sequence started");
    }

    @Override
    protected void interrupted() {
        Robot.climbingEntry.setBoolean(false);
        Robot.logger.logInfoFine("Auto climb sequence interrupted");
    }

    @Override
    protected void end() {
        Robot.climbingEntry.setBoolean(false);
        Robot.logger.logInfoFine("Auto climb sequence ended");
    }


}
