// package frc.robot.subsystems;
// import com.ctre.phoenix6.configs.TalonFXConfiguration;
// import com.ctre.phoenix6.hardware.TalonFX;              // API at https://api.ctr-electronics.com/phoenix6/release/java/com/ctre/phoenix6/hardware/TalonFX.html
// import com.grapplerobotics.LaserCan;
// import com.ctre.phoenix6.controls.VelocityVoltage;

// import edu.wpi.first.wpilibj2.command.Subsystem;
// import frc.robot.Constants.HardwareConstants;
// import frc.robot.Constants.CoralIntakeConstants;
// public final class CoralIntakelaser implements Subsystem {

//     private final TalonFX coral_intake = new TalonFX(HardwareConstants.CORAL_INTAKE_CAN);
    
//     lc = new LaserCan(0);
    


//     public CoralIntakelaser() {
//         coral_intake.getConfigurator().apply(CoralIntakeConstants.CORAL_CONFIG);
        
//     }

//     /**
//     * @param velocity sets velo (in rotations per second) 
//     */
//     public void setIntakeVelocity(double velocity) {
//         // class member variable
//         VelocityVoltage m_velocity = new VelocityVoltage(velocity);
//         TalonFXConfiguration talonFXConfigs = new TalonFXConfiguration();
//        // robot init, set slot 0 gains
//         var slot0Configs = talonFXConfigs.Slot0;
//         slot0Configs.kV = 0.12;
//         slot0Configs.kP = 0.11;
//         slot0Configs.kI = 0.48;
//         slot0Configs.kD = 0.01;
//         coral_intake.getConfigurator().apply(talonFXConfigs, 0.050);

//         // periodic, run velocity control with slot 0 configs,
//         // target velocity of 50 rps
//         //m_velocity.Slot = 0;
//         coral_intake.setControl(m_velocity.withVelocity(velocity));
//     }

//     public void set(double d) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'set'");
//     }
//     public void coralin(){
        
//         coral_intake.set(-0.25);
//     }
  
//     public void coralout(){
//         coral_intake.set(0.1);
//     } 

//     public void zero(){
//         coral_intake.set(0);
//     }
// }