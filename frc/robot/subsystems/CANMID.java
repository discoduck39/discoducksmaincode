// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



import static frc.robot.Constants.LauncherConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import static frc.robot.Constants.LauncherConstants.LEFT_INTAKE;
import static frc.robot.Constants.LauncherConstants.RIGHT_INTAKE;
import static frc.robot.Constants.LauncherConstants.LEFT_MID_SHOOTER;
import static frc.robot.Constants.LauncherConstants.RIGHT_MID_SHOOTER;
import static frc.robot.Constants.LauncherConstants.LEFT_TOP_SHOOTER;
import static frc.robot.Constants.LauncherConstants.RIGHT_TOP_SHOOTER;


import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;


public class CANMID extends SubsystemBase {
  CANSparkMax left_intake;
  CANSparkMax right_intake;
  CANSparkMax left_mid_shooter; 
  CANSparkMax right_mid_shooter;
  CANSparkMax left_top_shooter;
  CANSparkMax right_top_shooter;
public Runnable run;




  /** Creates a new Launcher. */
  public CANMID() {

    left_mid_shooter = new CANSparkMax(LEFT_MID_SHOOTER, CANSparkLowLevel.MotorType.kBrushless);
    right_mid_shooter = new CANSparkMax(RIGHT_MID_SHOOTER, CANSparkLowLevel.MotorType.kBrushless);
    left_mid_shooter.follow(right_mid_shooter);


 
    left_mid_shooter.setSmartCurrentLimit(kLauncherCurrentLimit);
    right_mid_shooter.setSmartCurrentLimit(kLauncherCurrentLimit);



    //Set the other motor to follow the matching stage so only controlling 1 motor at a time
   






  }

  public void run_motor() {
  right_mid_shooter.set(0.5);
}

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */

  

  // An accessor method to set the speed (technically the output percentage) of the launch wheel


  // An accessor method to set the speed (technically the output percentage) of the feed wheel
  public void setFeedWheel(double speed) {
    right_mid_shooter.set(speed);
  }

  // An accessor method to set the speed (technically the output percentage) of the intake wheel



  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    right_intake.set(0);
    right_mid_shooter.set(0);
    right_top_shooter.set(0);
  }
}

