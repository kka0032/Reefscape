//this is the motion magic edit

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import frc.robot.Constants.HardwareConstants;

public class Elevatorcopy {
    public TalonFX elevatorMain = new TalonFX(HardwareConstants.ELEVATOR_LEADER_CAN);
        public final TalonFX elevatorFollower = new TalonFX(HardwareConstants.ELEVATOR_FOLLOWER_CAN);
        
        private PositionVoltage positionControl;
        private double[] levels; // Positions for each level
        private double kP, kI, kD, kG; // PID and Feedforward gains
    
        public Elevatorcopy(int motorID, double[] levelPositions, double p, double i, double d, double g) {
            elevatorMain = new TalonFX(motorID);
        TalonFXConfiguration config = new TalonFXConfiguration();

        // Configure sensor and motor settings
        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        config.ClosedLoopGeneral.ContinuousWrap = false;

        // Configure PID gains
        config.Slot0.kP = p;
        config.Slot0.kI = i;
        config.Slot0.kD = d;
        config.Slot0.kG = g;

        elevatorMain.getConfigurator().apply(config);

        positionControl = new PositionVoltage(0);
        levels = levelPositions;
        kP = p;
        kI = i;
        kD = d;
        kG = g;
    }

    public void setLevel(int level) {
         if (level >= 0 && level < levels.length) {
            positionControl.Position = levels[level];
            positionControl.FeedForward = kG; // Apply feedforward to counteract gravity
            elevatorMain.setControl(positionControl);
        }
    }

    public double getCurrentPosition() {
        return elevatorMain.getPosition().getValueAsDouble();
    }

    public void updatePID(double p, double i, double d, double g){
        kP = p;
        kI = i;
        kD = d;
        kG = g;

        TalonFXConfiguration config = new TalonFXConfiguration();
         // Configure PID gains
        config.Slot0.kP = kP;
        config.Slot0.kI = kI;
        config.Slot0.kD = kD;
        config.Slot0.kG = kG;
        elevatorMain.getConfigurator().apply(config);
    }
}

