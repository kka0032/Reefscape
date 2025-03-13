package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// also see Command get imported... if the above gives issues, try this
// import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.util.Util;
import frc.robot.Constants.JoystickConstants;
import frc.robot.subsystems.CoralIntake;


public class CoralCommand extends Command {
    private final CoralIntake coral;
    private final XboxController operator;

    public CoralCommand(CoralIntake coral, XboxController operator2) {
        this.coral = coral;
        this.operator = operator2.getHID();
        addRequirements(coral);
    }

    @Override
    public void execute() {
        if ( operator.getLeftBumper() ) {

            coral.setIntakeVelocity(1);
          
          } else if ( operator.getRightBumper() ) {
          
            coral.setIntakeVelocity(-1);
          
          }
        }
        
    }

