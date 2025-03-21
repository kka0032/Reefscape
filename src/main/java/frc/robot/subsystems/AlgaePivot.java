package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.HardwareConstants;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;


// NOTE: all this is copy-paste from the Elevator subsystem because I'm assuming its the same kind of motor. If this assumption is poor we might have to redo this
public final class AlgaePivot implements Subsystem {
    
    private final TalonFX algae = new TalonFX(HardwareConstants.algae_CAN);



    /**
    * @param velocity sets velo (in rotations per second) 
    */
    public void setIntakeVelocity(double velocity) {
        // class member variable
        VelocityVoltage m_velocity = new VelocityVoltage(velocity);
        TalonFXConfiguration talonFXConfigs = new TalonFXConfiguration();
       // robot init, set slot 0 gains
        var slot0Configs = talonFXConfigs.Slot0;
        slot0Configs.kV = 0.12;
        slot0Configs.kP = 0.11;
        slot0Configs.kI = 0.48;
        slot0Configs.kD = 0.01;
        algae.getConfigurator().apply(talonFXConfigs, 0.050);

        
        // periodic, run velocity control with slot 0 configs,
        // target velocity of 50 rps
        //m_velocity.Slot = 0;
        algae.setControl(m_velocity.withVelocity(velocity));
    }

    public void algaeup(){
        algae.set(0.15);
    }

    public void algaedown(){
        algae.set(-0.15);
    }
    public void zero(){
        algae.set(.01);
    }
}