package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// also see Command get imported... if the above gives issues, try this
// import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.XboxController;
//import frc.robot.util.Util;
//import frc.robot.Constants.JoystickConstants;

public class ElevatorCommand extends Command {
    private final Elevator elevator;
    private final CommandXboxController operator;

    public ElevatorCommand(Elevator elevator, CommandXboxController operator) {
         this.operator = operator;
         this.elevator = elevator;
        addRequirements(elevator);
    }


    @Override
    public void execute() {

        

     
}
}