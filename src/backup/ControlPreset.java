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

import frc.robot.commands.ControlPresets.ControlPresetCheckCmd;
import frc.robot.Robot;
import frc.robot.OI;

/**
 * Add your docs here.
 */
public class ControlPreset extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public SendableChooser<String> m_ControlChooser;
  public String m_CurrentDrivingMode = "";

  public ControlPreset () {
    m_ControlChooser = new SendableChooser<String>();
    m_ControlChooser.addOption("Xbox Controller Tank Drive", "XboxTank");
    m_ControlChooser.setDefaultOption("Xbox Controller Arcade Drive 2 Joysticks", "XboxPlato");
    m_ControlChooser.addOption("Joystick Arcade Drive With Twist", "JoyArcade");
    SmartDashboard.putData("Driver Controller", m_ControlChooser);
    SmartDashboard.putData("Select Controller", new ControlPresetCheckCmd());

    XboxPlatoPreset();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void XboxTankPreset () {
    m_CurrentDrivingMode = "TankDrive";
    OI oi = Robot.m_oi;
    oi.m_controllerManager.resetBindings();
    oi.m_controllerManager.bindCommand(oi.m_JoystickController, oi.m_SlowDropCmd, 3);
    oi.m_controllerManager.bindCommand(oi.m_JoystickController, oi.m_FastDropCmd, 4);
    oi.m_controllerManager.addAxis(oi.m_XboxController, 0); //axis 0
    oi.m_controllerManager.addAxis(oi.m_XboxController, 4); //axis 1
  }

  public void XboxPlatoPreset () {
    m_CurrentDrivingMode = "ArcadePlatoDrive";
    OI oi = Robot.m_oi;
    oi.m_controllerManager.resetControllerBinding(oi.m_JoystickController);
    oi.m_controllerManager.resetControllerBinding(oi.m_XboxController);
    oi.m_controllerManager.resetAxisBinding();
    oi.m_controllerManager.bindCommand(oi.m_JoystickController, oi.m_SlowDropCmd, 3);
    oi.m_controllerManager.bindCommand(oi.m_JoystickController, oi.m_FastDropCmd, 4);
    oi.m_controllerManager.addAxis(oi.m_XboxController, 1); //axis 0
    oi.m_controllerManager.addAxis(oi.m_XboxController, 4); //axis 1
  }

  public void JoyArcadePreset () {
    m_CurrentDrivingMode = "ArcadeDrive";
    OI oi = Robot.m_oi;
    oi.m_controllerManager.resetBindings();
    oi.m_controllerManager.bindCommand(oi.m_XboxController, oi.m_SlowDropCmd, 1);
    oi.m_controllerManager.bindCommand(oi.m_XboxController, oi.m_FastDropCmd, 2);
    oi.m_controllerManager.addAxis(oi.m_XboxController, 0); //axis 0
    oi.m_controllerManager.addAxis(oi.m_XboxController, 1); //axis 1
  }

}
