package frc.robot.subsystems;

public class Debug {
    private Debug() {}

    private static boolean isPeriodicLogTick = true;
    private static final long logPeriod = 500;
    private static long lastLogTime = 0;

    public static void perioidic() {
        long currentTime = System.currentTimeMillis();

        //if current time is before last log tick time, set last log tick time to current time
        if (currentTime < lastLogTime) {
            lastLogTime = currentTime;
        }

        //Time dif since last log tick
        long deltaTime = currentTime - lastLogTime;

        if(deltaTime < logPeriod) {
            isPeriodicLogTick = false;
        } else {
            isPeriodicLogTick = true;
            lastLogTime = currentTime;
        }
    }
    
    public static void log(String message) {
        System.out.println(message);
    }
    public static void logPeriodic(String message) {
        if (isPeriodicLogTick) {
            log(message);
        }
    }
}
