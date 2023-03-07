package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;

public class Vision extends SubsystemBase {
    
    NetworkTableInstance instance;
    public AHRS imu; 
    public NetworkTable table;
    public NetworkTableEntry visionOnline, visionEnabled, visionEnableSuccess;
    public NetworkTableEntry ll_x;
    public NetworkTableEntry ll_y;  

    @SuppressWarnings("serial")
    public class VisionException extends Exception {
        public VisionException() {
            super();
        }
        public VisionException(String msg) {
            super(msg);
        }
    }

    public Vision() {
        CameraServer.startAutomaticCapture();

        instance = NetworkTableInstance.getDefault();
        table = instance.getTable("limelight");

        visionOnline = table.getEntry("vision online");
        visionEnabled = table.getEntry("vision enabled");
        visionEnableSuccess = table.getEntry("succesfully enabled");
        ll_x = table.getEntry("tx");
        ll_y = table.getEntry("ty");
    }

    //return whether limelight online
    public boolean ready() {
        return visionOnline.getBoolean(false);
    }

    public NetworkTableEntry readyEntry() {
        return visionOnline;
    }

    public void setVisionEnabled(boolean enabled) throws VisionException {
        visionEnabled.setBoolean(enabled);
    }

    public void shutdownLimelight() {
        NetworkTableEntry shutdown = table.getEntry("shutdown");
        shutdown.setBoolean(true);
        visionOnline.setBoolean(false);
    }

    public void restartServer() {
        NetworkTableEntry restart = table.getEntry("restart-server");
        restart.setBoolean(true);
    }
}
