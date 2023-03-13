package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;

public class Vision extends SubsystemBase {
    
    NetworkTableInstance instance;
    public NetworkTable table;
    public NetworkTableEntry visionOnline, visionEnabled, visionEnableSuccess;
    // public NetworkTableEntry tx;
    // public NetworkTableEntry ty;  
    public NetworkTableEntry ta;
    // public double targetOffsetAngle_vert;
    // public double mountingAngle;
    // public double limelightHeight;
    // public double targetHeight;
    // public double angleToTarget;
    public double targetArea;

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
        table.getEntry("pipeline").setNumber(0);

        visionOnline = table.getEntry("vision online");
        visionEnabled = table.getEntry("vision enabled");
        visionEnableSuccess = table.getEntry("succesfully enabled");
        // tx = table.getEntry("tx");
        // ty = table.getEntry("ty");
        ta = table.getEntry("ta");

        // targetOffsetAngle_vert = ty.getDouble(0.0);
        // mountingAngle = 0;
        // limelightHeight = 5.00;
        // targetHeight = 12.00;
        // angleToTarget = (mountingAngle + targetOffsetAngle_vert) * (3.14159 / 180.0);

        // distanceToTarget = (targetHeight - limelightHeight)/Math.tan(angleToTarget);
    }

    public double getTargetArea() {
        return this.ta.getDouble(0.0);
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
