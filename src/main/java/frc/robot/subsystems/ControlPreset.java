/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

//import frc.robot.commands.ControlPresets.ControlPresetCheckCmd;
import frc.robot.Robot;
import frc.robot.OI;
import frc.robot.concepttronix.controllertronix.ControllerTronix;

/**
 * Add your docs here.
 */
public class ControlPreset extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public SendableChooser<String> m_ControlChooser;
  public String m_CurrentDrivingMode = "";
  public OI m_oi;

  public ControlPreset (OI oi) {
    m_ControlChooser = new SendableChooser<String>();
    m_ControlChooser.addOption("Xbox Controller Tank Drive", "XboxTank");
    m_ControlChooser.setDefaultOption("Xbox Controller Arcade Drive 2 Joysticks", "XboxPlato");
    m_ControlChooser.addOption("Joystick Arcade Drive With Twist", "JoyArcade");
    SmartDashboard.putData("Driver Controller", m_ControlChooser);
    //SmartDashboard.putData("Select Controller", new ControlPresetCheckCmd());
    m_oi = oi;
    XboxPlatoPreset();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void checkPresetChange () {
    String result = Robot.m_oi.m_ControlPreset.m_ControlChooser.getSelected();
    SmartDashboard.putString("ModeToSwitchResult", result);
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
  }

  public void XboxTankPreset () {
    m_CurrentDrivingMode = "TankDrive";
    m_oi.m_controllerManager.resetBindings();
    m_oi.m_controllerManager.bindCommand(m_oi.m_JoystickController, m_oi.m_wedgerInitial, 0);
    m_oi.m_controllerManager.bindCommand(m_oi.m_JoystickController, m_oi.m_wedgerPos1, 1);
    m_oi.m_controllerManager.addAxis(m_oi.m_XboxController, 0); //axis 0
    m_oi.m_controllerManager.addAxis(m_oi.m_XboxController, 4); //axis 1
    SmartDashboard.putString("CurrentDriveMode", m_CurrentDrivingMode);
  }

  public void XboxPlatoPreset () {
    m_CurrentDrivingMode = "ArcadePlatoDrive";
    m_oi.m_controllerManager.resetBindings();
    m_oi.m_controllerManager.bindCommand(m_oi.m_JoystickController, m_oi.m_wedgerInitial, 0);
    m_oi.m_controllerManager.bindCommand(m_oi.m_JoystickController, m_oi.m_wedgerPos1, 1);
    m_oi.m_controllerManager.addAxis(m_oi.m_XboxController, 1); //axis 0
    m_oi.m_controllerManager.addAxis(m_oi.m_XboxController, 4); //axis 1
    SmartDashboard.putString("CurrentDriveMode", m_CurrentDrivingMode);
  }

  public void JoyArcadePreset () {
    m_CurrentDrivingMode = "ArcadeDrive";
    m_oi.m_controllerManager.resetBindings();
    m_oi.m_controllerManager.bindCommand(m_oi.m_XboxController, m_oi.m_wedgerInitial, 1);
    m_oi.m_controllerManager.bindCommand(m_oi.m_XboxController, m_oi.m_wedgerPos1, 2);
    m_oi.m_controllerManager.addAxis(m_oi.m_XboxController, 0); //axis 0
    m_oi.m_controllerManager.addAxis(m_oi.m_XboxController, 1); //axis 1
    SmartDashboard.putString("CurrentDriveMode", m_CurrentDrivingMode);
  }

  public String GetDriveMode () {
    return m_CurrentDrivingMode;
  }

}
