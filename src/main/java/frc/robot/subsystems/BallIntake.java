package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;
//import com.revrobotics.config.SparkBaseConfig;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Subsystem;

public class BallIntake implements Subsystem {
    public static SparkMax algaeIntake;
    public BallIntake(){
        algaeIntake = new SparkMax(9, MotorType.kBrushed);
    }

    public void setIntakeVelocity(double speed){
        algaeIntake.set(speed);
       
    }


public void ballin(){
    algaeIntake.set(0.8);
}

public void ballout(){
    algaeIntake.set(-.7);
} 
public void ballstop(){
    algaeIntake.set(0.15);
    
} 
}
