// package frc.robot.Commands;

// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.CoralIntake;
// import frc.robot.subsystems.CoralIntakelaser;
// import au.grapplerobotics.ConfigurationFailedException;
// import au.grapplerobotics.LaserCan;
// import au.grapplerobotics.ConfigurationFailedException;

// public class CoralCommandlaser extends Command {
//     private final CoralIntakelaser coral;
//     //private final XboxController operator;
//     private boolean bumperPressed = false;
//     private LaserCan lc;
//     // public CoralCommand(CoralIntake coral, CommandXboxController operator2) {
//     public CoralCommandlaser(CoralIntakelaser coral, boolean bumperPressed) {
//         this.bumperPressed = bumperPressed;
//         this.coral = coral;
//         // this.operator = operator2.getHID();
//         addRequirements(coral);
//     }

//     @Override
//     public void initialize(){
//       lc = new LaserCan(0);
//       try {
//         lc.setRangingMode(LaserCan.RangingMode.SHORT);
//         lc.setRegionOfInterest(new LaserCan.RegionOfInterest(8, 8, 16, 16));
//         lc.setTimingBudget(LaserCan.TimingBudget.TIMING_BUDGET_33MS);
//     }catch (ConfigurationFailedException e) {
//       System.out.println("Configuration failed! " + e);
//     }
//   }

//     @Override
//     public void execute() {
//       LaserCan lc;
//       try {
//         lc.setRangingMode(LaserCan.RangingMode.SHORT);
//         lc.setRegionOfInterest(new LaserCan.RegionOfInterest(8, 8, 16, 16));
//         lc.setTimingBudget(LaserCan.TimingBudget.TIMING_BUDGET_33MS);
//       } catch (ConfigurationFailedException e) {
//         System.out.println("Configuration failed! " + e);
//       }
//     }
//         // // if ( operator.getLeftBumper() ) {

//         //     coral.setIntakeVelocity(1);
          
//         //   } else if ( operator.getRightBumper() ) {
          
//         //     coral.setIntakeVelocity(-1);
          
//         //   }
//         // coral.setIntakeVelocity(1);
    

      
//       public boolean isFinished(){
//         return false;
//       }

//       @Override
//       public void end(boolean interrupted){
//         coral.setIntakeVelocity(0); 
//       }
        
//     }

