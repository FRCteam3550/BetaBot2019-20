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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    private int m_currentController; //I could have used .size() instead, probably
    private ArrayList<int[]> m_controllerCommandManager;

    private ArrayList<Integer> m_axisControllerUsed;
    private ArrayList<Integer> m_axisControllerPort;
    private int m_axisControllerIndex;

    private ArrayList<Command> m_currentRunnableCommands;
    private int m_currentCommandId; //I could have used .size() instead, probably, again

    private Boolean m_DebugMode; 


    public ControllerTronix () {
        //Setup all controllers
        m_controller = new ArrayList<GenericHID>();
        m_controllerType = new ArrayList<String>();
        m_controllerMaxButton = new ArrayList<Integer>();
        m_currentController = 0;

        m_axisControllerUsed = new ArrayList<Integer>();
        //m_axisControllerUsed.trimToSize();
        m_axisControllerPort = new ArrayList<Integer>();
        //m_axisControllerPort.trimToSize();
        m_axisControllerIndex = 0;

        //Set Commands
        m_currentRunnableCommands = new ArrayList<Command>();
        m_currentCommandId = 0;
        m_controllerCommandManager = new ArrayList<int[]>();

        m_DebugMode = false;
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
        int controllerId;
        String type = "Joystick"; //ignore everything else for now, to remove later
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

                if (m_DebugMode) {
                    SmartDashboard.putString("Controller Last Type", "Joystick");
                    SmartDashboard.putNumber("Controller Last Id", controllerId);
                }

                break;
            }
            case "Xbox" : {
                //Since gamepads are concidered joysticks, we should ignore that value for now
                controllerId = -1;
            }
            default : {
                //Do nothing, might want to add an error handling
                controllerId = -1;
            }
        }
        return controllerId; //Return the id of the controller
    }

    public GenericHID getControllerFromId(int ControllerId) {
        return m_controller.get(ControllerId);
    }

    public void ToggleSmartDashboardDebuging() {
        m_DebugMode = !m_DebugMode;
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
        if (m_DebugMode) {
            SmartDashboard.putNumber("Last Command Id", m_currentCommandId-1);
        }
        return m_currentCommandId - 1;
    }

    /**
     * While we only support one joystick per axis, an interesting path foward would be to support multiple axis per axis
     * @param ControllerId
     * @param axis
     * @return the axisId for getAxis()
     */
    public int addAxis (int ControllerId ,int axis) {
        m_axisControllerUsed.ensureCapacity(m_axisControllerIndex + 1);
        m_axisControllerUsed.add(ControllerId);
        m_axisControllerPort.ensureCapacity(m_axisControllerIndex + 1);
        m_axisControllerPort.add(axis);
        if (m_DebugMode) {
            SmartDashboard.putNumber("Last Axis Id", m_axisControllerIndex);
            SmartDashboard.putNumber("Last Axis Controller", ControllerId);
        }
        m_axisControllerIndex++;
        return m_axisControllerIndex - 1;
    }

    public Double getAxis (int axis) {
        double axisValue;
        if (m_DebugMode) {
            SmartDashboard.putNumber("GetAxis", axis);
        }
        if (axis >= m_axisControllerUsed.size()) { //No crash
            int axisController = m_axisControllerUsed.get(axis);
            int axisPort = m_axisControllerPort.get(axis);
            if ((axisController != -1) && (axisPort != -1)) {
                axisValue = getControllerFromId(axisController).getRawAxis(axisPort);
            } else {
                axisValue = 0;
            }
        } else {
            axisValue = 0;
        }   
        if (m_DebugMode) {
            SmartDashboard.putNumber("AxisValue", axisValue);
        }   
        return axisValue;
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
        m_axisControllerPort.clear();
        m_axisControllerUsed.clear();
        m_axisControllerIndex = 0;
    }

    public void resetControllerBinding (int ControllerId) {
        int[] ToClear = m_controllerCommandManager.get(ControllerId);
        int ButtonAmount = m_controllerMaxButton.get(ControllerId);
        for (int j = 0; j <= ButtonAmount; j++) {
            ToClear[j] = -1;
        }
        m_controllerCommandManager.set(ControllerId,ToClear);
    }

    public void resetAxisBinding () {
        m_axisControllerUsed.clear();
        m_axisControllerPort.clear();
        m_axisControllerIndex = 0;
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

    public void setupJoystickPressedButton(int ControllerId, int RealButtonId) { //tons of buttons, so little time
        JoystickButton button = new JoystickButton(getControllerFromId(ControllerId),RealButtonId);
        button.whenPressed(new ButtonPressedCmd(ControllerId, RealButtonId, this));
        button.close();//Test with and without
    }

    public void setupJoystickPressedButton(int ControllerId, int RealbuttonId, int VirtualButtonId) { //tons of buttons, so little time
        JoystickButton button = new JoystickButton(getControllerFromId(ControllerId),RealbuttonId);
        button.whenPressed(new ButtonPressedCmd(ControllerId, VirtualButtonId, this));
        button.close();//Test with and without
    }
}
