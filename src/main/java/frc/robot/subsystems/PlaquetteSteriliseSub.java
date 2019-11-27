/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.RobotMap;

/**
 * Subsystem utilisé afin de controller la plaquette stérilisé utilisé afin de manipuler les pièces de jeu
 */
public class PlaquetteSteriliseSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final WPI_TalonSRX m_PlateMotor;
  //private final DigitalInput m_PlateSensor;
  //private final Encoder m_Encoder;
  //private final double m_DistancePerPulse;

  public PlaquetteSteriliseSub() {
    m_PlateMotor = new WPI_TalonSRX(RobotMap.m_PlateMotor);
    //m_PlateSensor = new DigitalInput(RobotMap.m_PlateSensor);
    //m_Encoder = RobotMap.m_ArmEncoder;
  }

  public void PlateUp() {
    m_PlateMotor.set(0.5);
  }

  public void PlateDown() {
    m_PlateMotor.set(-0.5);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
