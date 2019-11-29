/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveBaseSub;
import frc.robot.Robot;
import frc.robot.OI;

public class AutoDrive extends Command {
  public DriveBaseSub m_DriveBaseSub;
  
  public AutoDrive() {
    m_DriveBaseSub = Robot.m_DriveBaseSub;
    requires(m_DriveBaseSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(6.5);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //This is really the bare minimum. If we want, we can add back the multiple drive mode.
    m_DriveBaseSub.arcadeDrive(0.25, 0.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
