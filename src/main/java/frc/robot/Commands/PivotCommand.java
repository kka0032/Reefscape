
package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AlgaePivot;
import edu.wpi.first.wpilibj2.command.WaitCommand;


public class PivotCommand extends Command {
    private final AlgaePivot algae;
    //private final XboxController operator;
    private boolean xPressed = false;
    private boolean yPressed = false;
    private boolean finished = false;
    
    public PivotCommand(AlgaePivot algae, boolean xPressed, boolean yPressed) {
        this.xPressed = xPressed;
        this.yPressed = yPressed;

        this.algae = algae;
        // this.operator = operator2.getHID();
        addRequirements(algae);
        
    }

    @Override
    public void initialize(){
      algae.setIntakeVelocity(.2);
      algae.algaeup();
    }

    @Override
    public void execute() {
        // // if ( operator.getLeftBumper() ) {

        //     coral.setIntakeVelocity(1);
          
        //   } else if ( operator.getRightBumper() ) {
          
        //     coral.setIntakeVelocity(-1);
          
        //   }
        // coral.setIntakeVelocity(1);
        algae.algaedown();
        new WaitCommand(2);
        algae.algaeup();
        finished = true;
    }
        
      
      public boolean isFinished(){
        return finished;
      }

      @Override
      public void end(boolean interrupted){
        algae.setIntakeVelocity(0);
      }
        
    }

