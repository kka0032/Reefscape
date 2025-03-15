package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// also see Command get imported... if the above gives issues, try this
// import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.util.Util;
import frc.robot.Constants.JoystickConstants;

public class ElevatorCommand extends Command {
    private final Elevator elevator;
    private final CommandXboxController operator;
    
    public ElevatorCommand(Elevator elevator, CommandXboxController operator2) {
         this.operator = operator2;
         this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void execute() {
        // Determine whether left joystick is positive or negative to raise or lower elevator
        double elevator_value = Util.applyDeadband(operator.getLeftY(), JoystickConstants.DEADBAND);

        if (elevator_value > 0.0) {
             elevator.raiseElevator();
         } else if (elevator_value < 0.0) {
             elevator.lowerElevator();
         } else {
             elevator.commandDefault();
            // Can change this to stop elevator depending on operator preference
            // elevator.stopElevator();
        }
        
    }
}
