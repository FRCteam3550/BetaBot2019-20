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
    private ArrayList<GenericHID> controllers;
    private ArrayList<String> controllersType;
    private int currentController;

    //Pilote et copilote
    //private int[] currentPilotes;
    //private int[] currentCoPilotes;
    private ArrayList<Integer> currentPilotes;
    private ArrayList<Integer> currentCoPilotes;

    private ArrayList<Command> currentRunnableCommands;
    private ArrayList<> currentPilote


    public ControllerTronix (int MaxController, int MaxCommands) {
        controllers = new ArrayList<GenericHID>();
        controllers.ensureCapacity(MaxController);
        controllersType = new ArrayList<String>();
        controllersType.ensureCapacity(MaxController);
        currentController = 0;

        currentPilotes = new ArrayList<Integer>();
        currentPilotes.ensureCapacity(MaxController);
        currentCoPilotes = new ArrayList<Integer>();
        currentCoPilotes.ensureCapacity(MaxController);
    }

    /**
     *  Since Joysticks are not supposed to be deleted, add all possible joystick ports.
     *  ** IN THE FUTURE : Check for a dynamic way to do this, without all of the missing controllers
     * @param type For now, only Joystick will work, might remove later idk
     * @param port
     * @return
     */
    public int addNewControlMethod (String type, int port) {
        int controllerId = -1;
        switch (type) {
            case "Joystick" : {
                Joystick newJoy = new Joystick(port);
                controllers.add(newJoy);
                controllersType.add(type);
                controllerId = currentController;

                setupJoystick(newJoy);

                currentController++;
            }
            case "Xbox" : { // DO NOT ADD RIGHT NOW
                controllers.add(new XboxController(port));
                controllersType.add(type);
                controllerId = currentController;
                currentController++;
            }
            default : {
                //Do nothing, might want to add an error handling
            }
        }
        return controllerId; //Return the id of the controller
    }

    public void addToPilot (int id) {
        currentPilotes.add(id);
    }

    public void resetPilotes () {
        currentPilotes.clear();
    }
    
    public void addToCoPilot (int id) {
        currentCoPilotes.add(id);
    }

    public void resetCoPilotes () {
        currentCoPilotes.clear();
    }


    private void setupJoystick(Joystick joy) { //tons of buttons, so little time
        JoystickButton b1 = new JoystickButton(joy,1);
        b1.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b2 = new JoystickButton(joy,1);
        b2.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b3 = new JoystickButton(joy,1);
        b3.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b4 = new JoystickButton(joy,1);
        b4.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b5 = new JoystickButton(joy,1);
        b5.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b6 = new JoystickButton(joy,1);
        b6.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b7 = new JoystickButton(joy,1);
        b7.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b8 = new JoystickButton(joy,1);
        b8.whenPressed(new JoystickButton1PressedCmd());
        JoystickButton b9 = new JoystickButton(joy,1);
        b9.whenPressed(new JoystickButton1PressedCmd());
    }
}
