package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.CoralIntakeConstants;
import frc.robot.Constants.JoystickConstants;
import frc.robot.subsystems.CoralIntake;
import frc.robot.util.Util;

public class SetIntakeVelocity extends Command {

    private double maxIntakeVel;
    private CoralIntake coral;

    public SetIntakeVelocity(CoralIntake coral, double maxIntakeVel) {
        this.coral = coral;
        this.maxIntakeVel = maxIntakeVel;
    }

    @Override
    public void execute() {
        coral.setIntakeVelocity(maxIntakeVel);
    }

}
