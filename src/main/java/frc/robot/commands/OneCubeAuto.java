package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Commands;

public class OneCubeAuto {

    public OneCubeAuto() {
        addCommands(
            // Align with the apriltag
            // Move forward until april tag size detected
            // Move forward additional amount
            // Move back until apriltag size
            // Turn 180
            // 
        );
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
