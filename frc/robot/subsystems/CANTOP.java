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

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;


public class CANTOP extends SubsystemBase {
  CANSparkMax left_intake;
  CANSparkMax right_intake;
  CANSparkMax left_mid_shooter; 
  CANSparkMax right_mid_shooter;
  CANSparkMax left_top_shooter;
  CANSparkMax right_top_shooter;
public Runnable run;




  /** Creates a new Launcher. */
  public CANTOP() {

    left_top_shooter = new CANSparkMax(7, CANSparkLowLevel.MotorType.kBrushless);
    right_top_shooter = new CANSparkMax(8, CANSparkLowLevel.MotorType.kBrushless);

         //left_top_shooter.follow(right_top_shooter);
         //right_top_shooter.setInverted(false);


    //left_top_shooter.setSmartCurrentLimit(kTopFeedCurrentLimit);
    //right_top_shooter.setSmartCurrentLimit(kTopFeedCurrentLimit);

    //Set the other motor to follow the matching stage so only controlling 1 motor at a time
   
  




  }

//   public void run_motor() {
//   right_top_shooter.set(0.5);
// }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */

  

  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  // public void setLaunchWheel(double speed) {
  //   right_top_shooter.set(speed);
  // }

  // An accessor method to set the speed (technically the output percentage) of the feed wheel
  public void setFeedWheel(double speed) {
    right_mid_shooter.set(speed);
  }

  // An accessor method to set the speed (technically the output percentage) of the intake wheel
  public void setintakewheel(double speed) {
    right_intake.set(speed);
  }

  public Command start(){
return run (() -> {
  this.left_top_shooter.set(-.1);
  this.right_top_shooter.set(.1);
});
  }
    public Command stop(){
return run (() -> {
  this.left_top_shooter.set(0);
  this.right_top_shooter.set(0);
});
  }

  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
 
  }


