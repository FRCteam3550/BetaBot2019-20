/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // Les roues sont à une distance de 56.5 cm

  // TODO : Find out what we are using for the speed controllers

 // public static final int m_MotorLeftFront = 0;
  public static final int m_MotorRight = 2;
  public static final int m_MotorLeft = 1;
 // public static final int m_MotorRightBack = 3;

  public static final int m_PlateSensor = 0;
  public static final int m_PlateMotor = 3;

  public static final int m_WedgerMotor = 12;
 // public static final int m_WedgerMobile = 7;
  
  // There are 90 motor turns in one pulse of this encoder, but how many do we need to turn the arm?
  public static final Encoder m_ArmEncoder = new Encoder(2,3);

  // This part is from 2019, do not use in comp, or else >=(
    //wedger
   // public static TalonSRX detroit2019wedgerMotor;
    //Grabber
   // public static TalonSRX detroit2019wedgerMobile;

 
}
