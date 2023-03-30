package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class BalanceBot extends CommandBase {

    private Drivetrain m_drive;
    private final PIDController m_pid;

    private double m_currentAngle, m_output;
    private boolean m_usePitch;
    private boolean m_inverted;
    private boolean m_isStopping = false;
    private Timer m_timer = new Timer();

    /**
     * Attempts to balance the robot on the charge station. The robot must start
     * partially on
     * the charge station.
     * <p>
     * Uses a PID, and after a short time will stutter up the charge station to
     * allow the charge station to balance
     * naturally. Currently the command does not end.
     * 
     * @param drive the drive subsystem
     */
    public BalanceBot(Drivetrain drive) {
        m_drive = drive;
        m_pid = drive.getBalanceController();
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        m_pid.setSetpoint(0);

        m_timer.reset();
        m_isStopping = false;
    }

    @Override
    public void execute() {
        // starts the timer if it hasn't already been started
        m_timer.start();

        m_currentAngle = m_drive.getPitchDegrees();

        m_output = MathUtil.clamp(m_pid.calculate(m_currentAngle), -0.2,
                0.2);

        // TODO: consider using heading PID to keep drive straight
        m_drive.driveSolo(m_output, m_output);

        // after DriveConstants.kBalanceNoStopPeriod, will stop every
        // DriveConstants.kBalanceStopInterval seconds
        // for DriveConstants.kBalanceStopDuration seconds, to give charge station time
        // to balance. See DriveConstants.java
        if (m_isStopping && m_timer.get() >= 10) {
            m_drive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.stop();
    }
}