/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.concepttronix.controllertronix;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import java.util.ArrayList;
import frc.robot.concepttronix.controllertronix.commands.*;

/**
 * The goal of ControllerTronix is to allow to easily change keybindings
 * when working with up to 5 controllers. It has support a pilot and a 
 * copilot, and should be able to handle 12 buttons in it's current state
 */
public class ControllerTronix {
    //Do note that for as long as we are in the betabot, this code will be a
    //bit feature missing, but should work fine for the betabot. If we want to
    //use this code again, we should start by expanding what it can do
    
    //Initializer
    //private GenericHID[] controllers;
    //private String[] controllersType;
    private ArrayList<GenericHID> m_controller;
    private ArrayList<String> m_controllerType;
    private ArrayList<Integer> m_controllerMaxButton;
    private int m_currentController;
    private ArrayList<int[]> m_controllerCommandManager;


    private ArrayList<Command> m_currentRunnableCommands;
    private int m_currentCommandId;


    public ControllerTronix () {
        //Setup all controllers
        m_controller = new ArrayList<GenericHID>();
        m_controllerType = new ArrayList<String>();
        m_controllerMaxButton = new ArrayList<Integer>();
        m_currentController = 0;

        //Set Commands
        m_currentRunnableCommands = new ArrayList<Command>();
        m_currentCommandId = 0;
        m_controllerCommandManager = new ArrayList<int[]>();
    }

    /**
     *  Since Joysticks are not supposed to be deleted, add all possible joystick ports.
     *  ** IN THE FUTURE : Check for a dynamic way to do this, without all of the missing controllers
     * @param type Currently supported : Joystick. Your choice will be ignored
     * @param port The port of the controller
     * @param maxButton The max amount of virtual buttons. You should set it to the max amount of buttons on the controller, but you can put it lower if you know you will not use all of the buttons available
     * @return
     */
    public int addNewControlMethod (String controllerType, int port, int maxButton) {
        int controllerId = -1;
        String type = "Joystick"; //ignore everything else
        switch (type) {
            case "Joystick" : {
                Joystick newJoy = new Joystick(port);

                m_controller.ensureCapacity(m_currentController+1);
                m_controller.add(newJoy);

                m_controllerType.ensureCapacity(m_currentController+1);
                m_controllerType.add(type);

                m_controllerMaxButton.ensureCapacity(m_currentController+1);
                m_controllerMaxButton.add(maxButton);

                m_controllerCommandManager.ensureCapacity(m_currentController+1);
                m_controllerCommandManager.add(new int[maxButton+1]);

                controllerId = m_currentController;
                resetControllerBinding(m_currentController);

                //setupJoystick(newJoy); //SetupJoystick should not be here

                m_currentController++;
            }
            case "Xbox" : {
                //Since gamepads are concidered joysticks, we should ignore that value for now
            }
            default : {
                //Do nothing, might want to add an error handling
            }
        }
        return controllerId; //Return the id of the controller
    }

    public GenericHID getControllerFromId(int ControllerId) {
        return m_controller.get(ControllerId);
    }

    /**
     * Removed since we are no longer using the Pilot CoPilot Formula (Was to complicated, tbh)
    public void addControllerToPilot (int id) {
        currentPilotes.add(id);
    }

    public void resetPiloteController () {
        currentPilotes.clear();
    }
    
    public void addControllerToCoPilot (int id) {
        currentCoPilotes.add(id);
    }

    public void resetCoPiloteController () {
        currentCoPilotes.clear();
    }
    */
    public int addCommand (Command command) {
        m_currentRunnableCommands.add(m_currentCommandId,command);
        m_currentCommandId++;
        return m_currentCommandId - 1;
    }

    public void resetBindings () {
        for (int i = 0; i < m_controllerCommandManager.size(); i++) { //this should remove all of the commands everywhere
            
            int[] ToClear = m_controllerCommandManager.get(i);
            //since we know that i is the commandId
            int ButtonAmount = m_controllerMaxButton.get(i);
            for (int j = 0; j <= ButtonAmount; j++) {
                ToClear[j] = -1;
            }
            m_controllerCommandManager.set(i,ToClear);
        }
    }

    public void resetControllerBinding (int ControllerId) {
        int[] ToClear = m_controllerCommandManager.get(ControllerId);
        int ButtonAmount = m_controllerMaxButton.get(ControllerId);
        for (int j = 0; j <= ButtonAmount; j++) {
            ToClear[j] = -1;
        }
        m_controllerCommandManager.set(ControllerId,ToClear);
    }

    /**
     * @param ControllerId
     * @param CommandId
     * @param VirtualButtonId
     */
    public void bindCommand (int ControllerId, int CommandId, int VirtualButtonId) {
        int[] ButtonArray = m_controllerCommandManager.get(ControllerId);
        ButtonArray[VirtualButtonId] = CommandId;
        m_controllerCommandManager.set(ControllerId, ButtonArray);
    }

    public Command getCommandFromButton (int ControllerId, int VirtualButtonId) {
        int[] buttonArray = m_controllerCommandManager.get(ControllerId);
        Command ReturnCommand;
        if (buttonArray[VirtualButtonId] != -1) {
            ReturnCommand = m_currentRunnableCommands.get(buttonArray[VirtualButtonId]);
        } else {
            ReturnCommand = new EmptyCommand();
        }
        return ReturnCommand;
    }

    private void setupJoystickPressedButton(int ControllerId, int RealButtonId) { //tons of buttons, so little time
        JoystickButton button = new JoystickButton(getControllerFromId(ControllerId),RealButtonId);
        button.whenPressed(new ButtonPressedCmd(ControllerId, RealButtonId, this));
    }

    private void setupJoystickPressedButton(int ControllerId, int RealbuttonId, int VirtualButtonId) { //tons of buttons, so little time
        JoystickButton button = new JoystickButton(getControllerFromId(ControllerId),RealbuttonId);
        button.whenPressed(new ButtonPressedCmd(ControllerId, VirtualButtonId, this));
    }
}
