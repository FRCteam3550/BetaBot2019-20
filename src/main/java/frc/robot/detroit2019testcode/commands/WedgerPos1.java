/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.detroit2019testcode.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class WedgerPos1 extends Command {

  private double position;

  public WedgerPos1(double position) {

    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_wedger);
     this.position = position;
     // setTimeout(2);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Robot.m_wedger.configPos1();\

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   Robot.m_wedger.goPos1(position);
   
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    SmartDashboard.putNumber("wedger Position1", Robot.m_wedger.getPosition());
    return false; // isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_wedger.StopWedger();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
