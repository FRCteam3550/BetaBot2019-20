/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ControlPresets;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.ControlPreset;
import frc.robot.Robot;

public class ControlPresetCheckCmd extends Command {
  Boolean m_finished = false;
  public ControlPresetCheckCmd() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    // requires(Robot.m_oi.m_ControlPreset);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_finished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    String result = Robot.m_oi.m_ControlPreset.m_ControlChooser.getSelected();
    switch (result) {
      case "XboxTank" : {
        Robot.m_oi.m_ControlPreset.XboxTankPreset();
        break;
      }
      case "XboxPlato" : {
        Robot.m_oi.m_ControlPreset.XboxPlatoPreset();
        break;
      }
      case "JoyArcade" : {
        Robot.m_oi.m_ControlPreset.JoyArcadePreset();
        break;
      }
      default : {
        break;
      }
    }
    m_finished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return m_finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    m_finished = false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
