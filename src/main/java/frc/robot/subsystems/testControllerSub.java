/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.OI;


/**
 * Add your docs here.
 */
public class testControllerSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  int defaultMainController;
  OI m_OI;

  public testControllerSub () {
    defaultMainController = 1;
    m_OI = Robot.m_oi;
    SmartDashboard.putNumber("TestControllerNumb", 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void addToDisplay (int amount) {
    double number = SmartDashboard.getNumber("TestControllerNumb", 0);
    number += amount;
    SmartDashboard.putNumber("TestControllerNumb", number);

  }

  public void switchToNext () {
    m_OI = Robot.m_oi;
    m_OI.m_controllerManager.resetBindings();
    switch (defaultMainController) {
      case 0 : {
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_AddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_RemoveToCounterCmd, 2);

        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_MainAddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_MainRemoveToCounterCmd, 2);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_SwitchJoyCmd, 3);

        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_AddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_RemoveToCounterCmd, 2);
        defaultMainController = 1;
        break;
      }
      case 1 : {
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_AddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_RemoveToCounterCmd, 2);

        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_MainAddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_MainRemoveToCounterCmd, 2);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_SwitchJoyCmd, 3);

        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_AddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_RemoveToCounterCmd, 2);
        defaultMainController = 2;
        break;
      }
      default : {
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_AddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId3, m_OI.m_RemoveToCounterCmd, 2);

        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_MainAddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_MainRemoveToCounterCmd, 2);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId1, m_OI.m_SwitchJoyCmd, 3);

        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_AddToCounterCmd, 1);
        m_OI.m_controllerManager.bindCommand(m_OI.m_JoystickId2, m_OI.m_RemoveToCounterCmd, 2);
        defaultMainController = 0;
        break;
      }
    }
    SmartDashboard.putNumber("MainJoy", defaultMainController);
  }
}
