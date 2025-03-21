package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.BallIntake;

public class BallSuckCommand extends Command {
  private final BallIntake ballIntake;
  // private final XboxController operator;
  private boolean APressed = false;
  private boolean BPressed = false;

  // public CoralCommand(CoralIntake coral, CommandXboxController operator2) {
  public BallSuckCommand(BallIntake ballintake, boolean APressed, boolean BPressed) {
    this.APressed = APressed;
    this.BPressed = BPressed;
    ballIntake = ballintake;
    // this.operator = operator2.getHID();
    addRequirements(ballIntake);
  }

  @Override
  public void initialize(){
    if (APressed){
      ballIntake.setIntakeVelocity(.5);
    } else {
      if (BPressed) {
        ballIntake.setIntakeVelocity(-.5);
    }
  }
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
      @Override
      public boolean isFinished(){
        return false;
      }

      @Override
      public void end(boolean interrupted){
        ballIntake.setIntakeVelocity(0);
      }
    }
  
