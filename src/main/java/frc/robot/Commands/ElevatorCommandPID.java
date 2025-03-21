package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevatorcopy;

public class ElevatorCommandPID extends Command {
    public static void main(String[] args) {
        double[] elevatorLevels = {0, 10, 20, 30}; // Example positions in encoder counts
        //Need to tune these values
        double kP = 0.1, kI = 0.01, kD = 0.001, kG = 0.1;

        Elevatorcopy elevator = new Elevatorcopy(20, elevatorLevels, kP, kI, kD, kG);

        // Move to level 2
        elevator.setLevel(2);
        System.out.println("Moving to level 2...");

        // Wait for the elevator to reach the position (add a delay or use a loop with a tolerance check)
        try {
            Thread.sleep(3000); // Wait 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         System.out.println("Current position: " + elevator.getCurrentPosition());

        // Move to level 0
         elevator.setLevel(0);
        System.out.println("Moving to level 0...");

        // Wait for the elevator to reach the position
        try {
            Thread.sleep(3000); // Wait 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current position: " + elevator.getCurrentPosition());

        elevator.updatePID(0.2, 0.02, 0.002, 0.2);
        System.out.println("PID updated");
    }
}