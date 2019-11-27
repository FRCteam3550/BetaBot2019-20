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

public class WadgerInitial extends Command {

  private double position;

  public WadgerInitial(double position) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_wedger);

    this.position = position;
    //setTimeout(2);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Robot.m_wedger.configPos0();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   Robot.m_wedger.goPos0(position);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    SmartDashboard.putNumber("wedger Int_Pos", Robot.m_wedger.getPosition());
   return false;//isTimedOut() || Robot.m_wedger.getPosition() < 20 ;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  // Robot.m_wedger.setWedgerMotorSpeed(0.05);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
