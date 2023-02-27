// Operator Interface
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {
    public static XboxController xbox = new XboxController(RobotMap.CONTROLLER_PORT);
    public static JoystickButton solenoidButton = new JoystickButton(xbox, 1);
    public static JoystickButton solenoidOffButton = new JoystickButton(xbox, 2);
    public static JoystickButton liftArmButton = new JoystickButton(xbox, 5);
    public static JoystickButton dropArmButton = new JoystickButton(xbox, 6);
    public static JoystickButton pushButton= new JoystickButton(xbox, 3);
    public static JoystickButton pullButton = new JoystickButton(xbox, 4); 
    public static boolean getSolenoidButton() {
        return OI.solenoidButton.getAsBoolean();
      }
    
      public static boolean getSolenoidOffButton() {
        return OI.solenoidOffButton.getAsBoolean();
      }
    
      public static boolean getPushButton() {
        return OI.pushButton.getAsBoolean();
      }
    
      public static boolean getPullButton() {
        return OI.pullButton.getAsBoolean();
      }
    
      public static boolean getLiftArmButton() {
        return OI.liftArmButton.getAsBoolean();
      }
      
      public static boolean getDropArmButton() {
        return OI.dropArmButton.getAsBoolean();
      }
      public static double getYLeft(){
        double kleft = OI.xbox.getLeftY();
        if(Math.abs(kleft) <= 0.1){
          return 0;
        } else {
          return -kleft*Math.abs(kleft); //Math.abs to preserve sign
        }
      }
    
      public static double getYRight(){
        double kright = OI.xbox.getRightY();
        if(Math.abs(kright) <= 0.1){
          return 0;
        } else {
          return kright*Math.abs(kright); //Math.abs to preserve sign
        }
      }
    
}