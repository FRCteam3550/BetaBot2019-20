/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WedgerManual extends Command {
  public WedgerManual() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_wedger);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Robot.m_wedger.StopWedger();    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Robot.m_wedger.moveWedgerManual(Robot.m_oi.getGamePad().getX());
    //Robot.m_wedger.getWedgerInfo();
  // Robot.m_wedger.setWedge(Robot.m_oi.getGamePad().getY()* 0.5);
    //Robot.m_wedger.setWedgerMobile(Robot.m_oi.getGamePad().getY());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.m_wedger.StopWedger();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
