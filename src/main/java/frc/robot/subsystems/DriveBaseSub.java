/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 * Add your docs here.
 */
public class DriveBaseSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final DifferentialDrive m_DiffDrive;

  private final SpeedController m_MotorLeft;
  private final SpeedController m_MotorRight;

  

  public DriveBaseSub() { // init some stuff

    m_MotorLeft = new WPI_TalonSRX(RobotMap.m_MotorLeft);
    m_MotorRight = new WPI_TalonSRX(RobotMap.m_MotorRight);



    //m_MotorLeftF.setInverted(false); // TODO : Find out if we need to invert it
   // m_MotorRight = RobotMap.m_MotorRight;
   // m_MotorRight.setInverted(false); // TODO : Find out if we need to invert it
    m_DiffDrive = new DifferentialDrive(m_MotorLeft, m_MotorRight); 
  }

  public void arcadeDrive (double DriveSpeed, double DriveRotation) {
    m_DiffDrive.arcadeDrive(DriveSpeed, DriveRotation);
  }

  public void tankDrive (double DriveLeftSpeed, double DriveRightSpeed) {
    m_DiffDrive.tankDrive(DriveLeftSpeed, DriveRightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArcadeDriveCmd());
  }
}
