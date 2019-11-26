/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TestControllerCmd;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.testControllerSub;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TestAddToCounterCmd extends Command {

  Boolean m_finished = false;
  public TestAddToCounterCmd() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_TestConSub);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    double test111 = SmartDashboard.getNumber("Test111", 0);
    test111++;
    SmartDashboard.putNumber("Test111",test111);
    }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_TestConSub.addToDisplay(1);
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
