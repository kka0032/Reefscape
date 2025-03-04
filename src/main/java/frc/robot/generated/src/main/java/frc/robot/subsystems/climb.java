package frc.robot.generated.src.main.java.frc.robot.subsystems;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class climb {
     
}
public class climb extends Subsystem  {
    private final WPI_TalonFX climbMotor;

    public climb(){
      climbMotor = new WPI_TalonFX(0)//Motor on PWM port 0
    }
  
public void moveUp(){
  climbMotor.set(1.0);// Move UP
}
public void moveDown(){
  climbMotor.set(-1.0);//Move DOWN
}
public void stop(){
  climbMotor.set(0.0);//Stop
}