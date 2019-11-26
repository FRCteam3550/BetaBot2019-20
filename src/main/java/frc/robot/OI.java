/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;

import frc.robot.concepttronix.controllertronix.ControllerTronix;

//This is a list of test imports, please remove later
import frc.robot.detroit2019testcode.commands.WadgerInitial;
import frc.robot.detroit2019testcode.commands.WedgerPos1;
import frc.robot.detroit2019testcode.PIDsettings.*;
import frc.robot.commands.TestControllerCmd.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  /**
  private final Joystick m_DriverJoystick;
  private final Joystick m_CoDriverJoystick;
  private final XboxController m_DriverXbox;
  private final XboxController m_CoDriverXbox;

  

  public OI() {
    // TODO : Learn what controller we are using / if we have more than one Xbox controlle
    m_DriverJoystick = new Joystick(0);
    m_CoDriverJoystick = new Joystick (1);
    m_DriverXbox = new XboxController(2);
    m_CoDriverXbox = new XboxController(3);

  // wedger
  Button b8 = new JoystickButton(m_CoDriverJoystick, 1);
  b8.whenPressed(new WadgerInitial(Constants.Wedger0));

  Button b9 = new JoystickButton(m_CoDriverJoystick, 2);
  b9.whenPressed(new WedgerPos1(Constants.Wedger1));
  }
  */


  public ControllerTronix m_controllerManager;
  public int m_JoystickId1;
  public int m_JoystickId2;
  public int m_JoystickId3;

  public int m_AddToCounterCmd;
  public int m_RemoveToCounterCmd;
  public int m_SwitchJoyCmd;
  public int m_MainAddToCounterCmd;
  public int m_MainRemoveToCounterCmd;

  public OI () {
    m_controllerManager = new ControllerTronix();
    m_JoystickId1 = m_controllerManager.addNewControlMethod("Joystick", 0, 12);
    m_JoystickId2 = m_controllerManager.addNewControlMethod("Joystick", 1, 12);
    m_JoystickId3 = m_controllerManager.addNewControlMethod("Joystick", 2, 12);

    m_AddToCounterCmd = m_controllerManager.addCommand(new TestAddToCounterCmd());
    m_RemoveToCounterCmd = m_controllerManager.addCommand(new TestRemoveToCounterCmd());
    m_SwitchJoyCmd = m_controllerManager.addCommand(new TestSwitchMainJoyCmd());
    m_MainAddToCounterCmd = m_controllerManager.addCommand(new TestMainAddToCounterCmd());
    m_MainRemoveToCounterCmd = m_controllerManager.addCommand(new TestMainRemoveToCounterCmd());

    m_controllerManager.setupJoystickPressedButton(m_JoystickId1, 1);
    m_controllerManager.setupJoystickPressedButton(m_JoystickId1, 2);
    m_controllerManager.setupJoystickPressedButton(m_JoystickId1, 3);

    m_controllerManager.setupJoystickPressedButton(m_JoystickId2, 1);
    m_controllerManager.setupJoystickPressedButton(m_JoystickId2, 2);
    m_controllerManager.setupJoystickPressedButton(m_JoystickId2, 3);

    m_controllerManager.setupJoystickPressedButton(m_JoystickId3, 1);
    m_controllerManager.setupJoystickPressedButton(m_JoystickId3, 2);
    m_controllerManager.setupJoystickPressedButton(m_JoystickId3, 3);

    //Default bindings
    m_controllerManager.bindCommand(m_JoystickId1, m_AddToCounterCmd, 1);
    m_controllerManager.bindCommand(m_JoystickId1, m_RemoveToCounterCmd, 2);

    m_controllerManager.bindCommand(m_JoystickId2, m_MainAddToCounterCmd, 1);
    m_controllerManager.bindCommand(m_JoystickId2, m_MainRemoveToCounterCmd, 2);
    m_controllerManager.bindCommand(m_JoystickId2, m_SwitchJoyCmd, 3);

    m_controllerManager.bindCommand(m_JoystickId3, m_AddToCounterCmd, 1);
    m_controllerManager.bindCommand(m_JoystickId3, m_RemoveToCounterCmd, 2);
  }

}
