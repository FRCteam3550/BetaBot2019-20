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

public class ArcadeDriveCmd extends Command {
  public DriveBaseSub m_DriveBaseSub;
  
  public ArcadeDriveCmd() {
    m_DriveBaseSub = Robot.m_DriveBaseSub;
    requires(m_DriveBaseSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //This is really the bare minimum. If we want, we can add back the multiple drive mode.

    //m_DriveBaseSub.arcadeDrive(Robot.m_oi.driverXAxis(), Robot.m_oi.driverYAxis());
    switch (Robot.m_oi.m_ControlPreset.GetDriveMode()) {
      case ("TankDrive") : {
        m_DriveBaseSub.tankDrive(Robot.m_oi.m_ControlPreset.GetJoy0(), Robot.m_oi.m_ControlPreset.GetJoy1());
        break;
      }
      case ("ArcadePlatoDrive") : {
        m_DriveBaseSub.arcadeDrive(Robot.m_oi.m_ControlPreset.GetJoy0(), Robot.m_oi.m_ControlPreset.GetJoy1());
      break;
      }
      case ("ArcadeDrive") : {
        m_DriveBaseSub.arcadeDrive(Robot.m_oi.m_ControlPreset.GetJoy0(), Robot.m_oi.m_ControlPreset.GetJoy1());
        break;
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
