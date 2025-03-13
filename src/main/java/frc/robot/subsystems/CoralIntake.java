package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.StaticBrake;          // API at https://api.ctr-electronics.com/phoenix6/release/java/com/ctre/phoenix6/controls/StaticBrake.html
import com.ctre.phoenix6.hardware.TalonFX;              // API at https://api.ctr-electronics.com/phoenix6/release/java/com/ctre/phoenix6/hardware/TalonFX.html
import com.ctre.phoenix6.controls.VelocityDutyCycle;    // API at https://api.ctr-electronics.com/phoenix6/release/java/com/ctre/phoenix6/controls/VelocityDutyCycle.html
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.HardwareConstants;
import frc.robot.Constants.CoralIntakeConstants;
import frc.robot.Constants.ElevatorConstants;
import com.ctre.phoenix6.controls.VelocityVoltage;
public final class CoralIntake implements Subsystem {

    private final TalonFX coral_intake = new TalonFX(HardwareConstants.CORAL_INTAKE_CAN);

    public CoralIntake() {
        coral_intake.getConfigurator().apply(ElevatorConstants.ELEVATOR_CONFIG);
    }

    /**
    * @param velocity sets velo (in rotations per second) 
    */
    public void setIntakeVelocity(double velocity) {
        // class member variable
        VelocityVoltage m_velocity = new VelocityVoltage(velocity);

        // robot init, set slot 0 gains
     //   var slot0Configs = new Slot0Configs();
       // slot0Configs.kV = 0.12;
        //slot0Configs.kP = 0.11;
        //slot0Configs.kI = 0.48;
       // slot0Configs.kD = 0.01;
        //coral_intake.getConfigurator().apply(slot0Configs, 0.050);

        // periodic, run velocity control with slot 0 configs,
        // target velocity of 50 rps
        //m_velocity.Slot = 0;
        coral_intake.setControl(m_velocity.withVelocity(velocity));
    }
}