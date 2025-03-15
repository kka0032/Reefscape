package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralIntake;


public class CoralCommand extends Command {
    private final CoralIntake coral;
    //private final XboxController operator;
    private boolean bumperPressed = false;
    // public CoralCommand(CoralIntake coral, CommandXboxController operator2) {
    public CoralCommand(CoralIntake coral, boolean bumperPressed) {
        this.bumperPressed = bumperPressed;
        this.coral = coral;
        // this.operator = operator2.getHID();
        addRequirements(coral);
    }

    @Override
    public void initialize(){
      coral.setIntakeVelocity(1);
    }

    @Override
    public void execute() {
        // // if ( operator.getLeftBumper() ) {

        //     coral.setIntakeVelocity(1);
          
        //   } else if ( operator.getRightBumper() ) {
          
        //     coral.setIntakeVelocity(-1);
          
        //   }
        // coral.setIntakeVelocity(1);
    }

      
      public boolean isFinished(){
        return false;
      }

      @Override
      public void end(boolean interrupted){
        coral.setIntakeVelocity(0);
      }
        
    }

