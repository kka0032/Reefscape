package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Climber;
import frc.robot.util.Util;
import frc.robot.Constants.JoystickConstants;


public class ClimberCommand extends Command {
    private final Climber climber;
    private final CommandXboxController operator;

    public ClimberCommand(Climber climber, CommandXboxController operator2) {
        this.climber = climber;
        this.operator = operator2;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        // // Determine whether right joystick is positive or negative to raise or lower climber
        // double climber_value = Util.applyDeadband(operator.getRightY(), JoystickConstants.DEADBAND);

        // if (climber_value > 0.0) {
        //     climber.raiseClimber();
        // } else if (climber_value < 0.0) {
        //     climber.lowerClimber();
        // } else {
        //   //  climber.commandDefault();
        //     // Can change this to stop climber depending on operator preference
        //      climber.stopClimber();
        }
        
    }

