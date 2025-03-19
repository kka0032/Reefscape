//this is the motion magic edit

package frc.robot.subsystems;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
// import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.StaticBrake;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Constants.HardwareConstants;

import edu.wpi.first.wpilibj.DigitalInput;

public final class Elevator implements Subsystem {
   // public static record ElevatorState(double height, double angle) {}
    
    
    public final TalonFX elevatorMain = new TalonFX(HardwareConstants.ELEVATOR_LEADER_CAN);
   // private final DigitalInput elevator_limit_switch = new DigitalInput(HardwareConstants.ELEVATOR_LIMIT_SWITCH_DIO);
   DigitalInput Max_limit = new DigitalInput(3);
    DigitalInput L3_limit = new DigitalInput(2);
    DigitalInput L2_limit = new DigitalInput(1);
    DigitalInput Min_limit = new DigitalInput(0);
   // private PositionVoltage positionControl;
   // private VelocityVoltage velocityControl;

    // If there is a follower motor:
    public final TalonFX elevatorFollower = new TalonFX(HardwareConstants.ELEVATOR_FOLLOWER_CAN);
    

    
  

    public Elevator() {
     //   TalonFXConfiguration config = new TalonFXConfiguration();
       // elevatorMain.getConfigurator().apply(ElevatorConstants.ELEVATOR_CONFIG);
      
     // config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
     // config.CurrentLimits.StatorCurrentLimitEnable = true;
    //   config.CurrentLimits.StatorCurrentLimit = 40;

      //elevatorMain.getConfigurator().apply(config);

    //   //instantiate control objects
        //   positionControl = new PositionVoltage(0);
        //   velocityControl = new VelocityVoltage(0);
         //   DigitalInput top_limit = new DigitalInput(0);
        // DigitalInput bottom_limit = new DigitalInput(1);
            //     // elevatorFollower.getConfigurator().apply(ElevatorConstants.ELEVATOR_CONFIG);
            //     // elevatorFollower.setControl(new Follower(HardwareConstants.ELEVATOR_LEADER_CAN, false));
          


     }
    // public Angle getPosition() {
    //     return elevatorMain.getPosition().getValue();
    // }
   
    // public AngularVelocity getVelocity(){
    //     return elevatorMain.getVelocity().getValue();
    // }

    // public void setPosition(double targetPosition){
    //     elevatorMain.setControl(positionControl.withPosition(targetPosition));
    // }

    // public void setVelocity(double targetVelocity){
    //     elevatorMain.setControl(velocityControl.withVelocity(targetVelocity));
    // }


    public void zero(){
        elevatorMain.set(0);
        elevatorFollower.setControl(new Follower(20, true));

        
    }

    public void level1(){
        elevatorMain.set(-.5);
        elevatorFollower.setControl(new Follower(20, true));
        if(Min_limit.get() == true){
            elevatorMain.stopMotor();
            }

           else {
         
         }
         
     }

     public void level2(){
        elevatorMain.set(.5);
        elevatorFollower.setControl(new Follower(20, true));
        if(L2_limit.get() == true){
            elevatorMain.stopMotor();
            }

           else {
         
         }

         
     }

      public void reset(){
         elevatorMain.set(-.4);
         elevatorFollower.setControl(new Follower(20, true));
         if(Min_limit.get() == true){
            elevatorMain.stopMotor();
            }

           else {
         
         }
        
     }

     
      public void level3(){
        elevatorMain.set(.5);
        elevatorFollower.setControl(new Follower(20, true));
        if(L3_limit.get() == true){
            elevatorMain.stopMotor();
            }

           else {
         
         }

        
         
      }
      public void Max(){
        elevatorMain.set(.4);
        elevatorFollower.setControl(new Follower(20, true));
        if(Max_limit.get() == true){
           elevatorMain.stopMotor();
           }

          else {
        
        }
       
    }

    }

    // public void setPosition(double targetPosition){
    //     elevatorMain.setControl(positionControl.withPosition(targetPosition));
    