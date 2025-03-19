// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.CoralIntake;
import frc.robot.subsystems.AlgaePivot;
import frc.robot.subsystems.BallIntake;

import frc.robot.Commands.*;

public class RobotContainer {

    public static final double MaxSpeed = TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts
                                                                                               // desired top speed
    public static final double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per
                                                                                                // second max angular
                                                                                                // velocity



    /* Setting up bindings for necessary control of the swerve drive platform */
    // NOTE: moved MAX_SPEED and MAX_ANG_RATE over to Constants file, this may break things
    // Good practice to declutter this class though
    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
    private final SwerveRequest.SwerveDriveBrake brake = new SwerveRequest.SwerveDriveBrake();
    private final SwerveRequest.PointWheelsAt point = new SwerveRequest.PointWheelsAt();

    // Instantiate subsystems
    private final Elevator elevator = new Elevator();
    private final Climber climber = new Climber();
    private final CoralIntake coral = new CoralIntake();
    private final BallIntake ball = new BallIntake();
    private final AlgaePivot algae = new AlgaePivot();
    
    

  
    private final BallSuckCommand ballIntakeCommand = new BallSuckCommand(ball, true, false);
    private final BallSuckCommand ballOuttakeCommand = new BallSuckCommand(ball, false, true);

  //  private final CoralCommand intakeCoralCommand =  new CoralCommand(coral, true);

   // private final Telemetry logger = new Telemetry(MaxSpeed);

    private final CommandXboxController driver = new CommandXboxController(0);
    // private final CommandXboxController operator = new CommandXboxController(1);
    private final CommandXboxController operator = new CommandXboxController(1);


    public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();
//auto practice
   public void autothing()
    {
        drivetrain.applyRequest(() ->
                drive.withVelocityX(0).withVelocityY(-.4).withRotationalRate(0) // Drive forward with negative Y (forward)
            );
    }

    public RobotContainer() {
       configureBindings();
    
    }
    /**
    * Use this method to define your trigger->command mappings.
    */
    public void configureBindings() {
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
        drivetrain.setDefaultCommand(
            // Drivetrain will execute this command periodically
            drivetrain.applyRequest(() ->
                drive.withVelocityX(-driver.getLeftY() * MaxSpeed) // Drive forward with negative Y (forward)
                    .withVelocityY(-driver.getLeftX() * MaxSpeed) // Drive left with negative X (left)
                    .withRotationalRate(-driver.getRightX() * MaxAngularRate) // Drive counterclockwise with negative X (left)
            )
        );

        driver.a().whileTrue(drivetrain.applyRequest(() -> brake));
        driver.b().whileTrue(drivetrain.applyRequest(() ->
        point.withModuleDirection(new Rotation2d(-driver.getLeftY(), -driver.getLeftX()))
        ));
        climber.setDefaultCommand(new RunCommand(() -> climber.zero(), climber));
        coral.setDefaultCommand(new RunCommand(() -> coral.zero(), coral));
        algae.setDefaultCommand(new RunCommand(() -> algae.zero(), algae));
        elevator.setDefaultCommand(new RunCommand(() -> elevator.zero(), elevator));



       ball.setDefaultCommand(new RunCommand(() -> ball.ballstop(), ball));
        // Run SysId routines when holding back/start and X/Y.
        // Note that each routine should be run exactly once in a single log.
        driver.back().and(driver.y()).whileTrue(drivetrain.sysIdDynamic(Direction.kForward));
        driver.back().and(driver.x()).whileTrue(drivetrain.sysIdDynamic(Direction.kReverse));
        driver.start().and(driver.y()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kForward));
        driver.start().and(driver.x()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kReverse));
        
        //lines up robot with closest april tag
        //driver.x().whileTrue(getAutonomousCommand(new LimelightHelpers));
        
        // reset the field-centric heading on left bumper press
        driver.leftBumper().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldCentric()));

  //      drivetrain.registerTelemetry(logger::telemeterize);

        // Runs elevator to raise/lower or return to default state based on driver left joystick
        // NOTE: There is a clever way to do this with lambda expressions and a RepeatCommand class but choosing not to implement that because it's trickier
        // See: https://github.com/FRC7153/2025-Reefscape/blob/main/src/main/java/frc/robot/RobotContainer.java and https://github.com/FRC7153/2025-Reefscape/blob/main/src/main/java/frc/robot/commands/ManipulatorCommand.java
   //     elevator.setDefaultCommand(new ElevatorCommand(elevator, operator.getHID()));

        // Runs climber to raise/lower or return to default state based on driver left joystick
        // NOTE: There is a clever way to do this with lambda expressions and a RepeatCommand class but choosing not to implement that because it's trickier
        // See: https://github.com/FRC7153/2025-Reefscape/blob/main/src/main/java/frc/robot/RobotContainer.java and https://github.com/FRC7153/2025-Reefscape/blob/main/src/main/java/frc/robot/commands/ManipulatorCommand.java
       // climber.setDefaultCommand(new ClimberCommand(climber, operator));        
          //  elevator.setDefaultCommand(new ElevatorCommand(elevator, operator));
       // operator.leftTrigger().whileTrue(new SetIntakeVelocity(coral, CoralIntakeConstants.MAX_INTAKE_VEL));
        //operator.rightTrigger().whileTrue(new SetIntakeVelocity(coral, -CoralIntakeConstants.MAX_INTAKE_VEL));
        // coral.setDefaultCommand(new CoralCommand(coral, operator));
        //operator.getLeftBumper().onTrue(new CoralCommand(coral, true));
         driver.button(5).whileTrue(new RunCommand(() -> ball.ballout(),ball)); 
         driver.button(6).whileTrue(new RunCommand(() -> ball.ballin(),ball));
        // operator.button(10).whileTrue(new RunCommand(() -> ball.ballstop(),ball)); 
       //  operator.button(11).whileTrue(new RunCommand()) -> elevator.elevatorup(),elevator));
       //  operator.button(12).whileTrue(new RunCommand()) -> elevator.elevatordown(),elevator));

        operator.button(5).whileTrue(new RunCommand(() -> coral.coralout(),coral)); 
        operator.button(6).whileTrue(new RunCommand(() -> coral.coralin(),coral));
      //  operator.leftTrigger().whileTrue(ballIntakeCommand);
       // operator.rightTrigger().whileTrue(ballOuttakeCommand);
        operator.button(11).whileTrue(new RunCommand(() -> climber.moveClimberUp(), climber)); // move up
        operator.button(12).whileTrue(new RunCommand(() -> climber.moveClimberDown(), climber)); // move down

        operator.button(1).whileTrue(new RunCommand(() -> elevator.level1(),elevator));
        operator.button(2).whileTrue(new RunCommand(() -> elevator.Max(),elevator));
        operator.button(3).whileTrue(new RunCommand(() -> elevator.level2(),elevator));
        operator.button(4).whileTrue(new RunCommand(() -> elevator.level3(),elevator));

        driver.leftTrigger(.5).whileTrue(new RunCommand(()  -> algae.algaeup(), algae));
        driver.rightTrigger(.5).whileTrue(new RunCommand(()  -> algae.algaedown(), algae)); 
      //  operator.getLeftY(new RunCommand(null, null)) -> elevator.elevatorup(),elevator));
    }


    public Command getAutonomousCommand() {
        return drivetrain.applyRequest(() ->
        drive.withVelocityX(2).withVelocityY(0).withRotationalRate(0) // Drive forward with negative Y (forward)
    ).repeatedly().withTimeout(2.0);
    }
}