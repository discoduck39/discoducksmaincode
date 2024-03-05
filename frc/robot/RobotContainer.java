// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CANMID;
import frc.robot.subsystems.CANTOP;
import frc.robot.Constants.LauncherConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.CANDrivetrain;
import frc.robot.subsystems.CANLauncher;

// import frc.robot.subsystems.CANDrivetrain;
// import frc.robot.subsystems.CANLauncher;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final CANLauncher m_intake = new CANLauncher();
private final CANMID m_mid = new CANMID();
private final CANTOP m_top = new CANTOP();
  // The robot's subsystems are defined here.
  private final CANDrivetrain m_drivetrain = new CANDrivetrain();
  // private final CANDrivetrain m_drivetrain = new CANDrivetrain();
  
  // private final CANLauncher m_launcher = new CANLauncher();

  /*The gamepad provided in the KOP shows up like an XBox controller if the mode switch is set to X mode using the
   * switch on the top.*/
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_operatorController =
      new CommandXboxController(OperatorConstants.kOperatorControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be accessed via the
   * named factory methods in the Command* classes in edu.wpi.first.wpilibj2.command.button (shown
   * below) or via the Trigger constructor for arbitary conditions
   */
  private void configureBindings() {
    // Set the default command for the drivetrain to drive using the joysticks
    m_drivetrain.setDefaultCommand(
        new RunCommand(
            () ->
                m_drivetrain.arcadeDrive(
                    m_driverController.getLeftY(), m_driverController.getLeftX()),
            m_drivetrain));

    m_driverController.x().onTrue(
   (m_intake.run()));
    m_driverController.x().onFalse(
   (m_intake.stop()));

    m_driverController.leftBumper().onTrue(
   (m_top.start()));
    m_driverController.leftBumper().onFalse(
   (m_top.stop()));

    m_driverController.rightBumper().onTrue(
   (m_mid.start()));
    m_driverController.leftBumper().onFalse(
   (m_mid.stop()));



  //   m_operatorController.leftBumper().onTrue(
  //   m_mid.runOnce(m_mid.run));
    
  //   m_operatorController.rightBumper().onTrue(
  //   m_top.runOnce(m_top.run));
    
   }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   {
    // An example command will be run in autonomous
    
  }
}
