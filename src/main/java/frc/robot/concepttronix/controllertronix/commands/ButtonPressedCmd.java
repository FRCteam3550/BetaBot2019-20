/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.concepttronix.controllertronix.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.concepttronix.controllertronix.ControllerTronix;

public class ButtonPressedCmd extends Command {
  private int m_ControllerId;
  private int m_ButtonId;
  private ControllerTronix m_Controller;

  /**
   * Add your docs here.
   */
  public ButtonPressedCmd (int ControllerId, int ButtonId, ControllerTronix Controller) {
    m_ControllerId = ControllerId;
    m_ButtonId = ButtonId;
    m_Controller = Controller;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_Controller.getCommandFromButton(m_ControllerId, m_ButtonId);
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
