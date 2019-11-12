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

  private final SpeedController m_MotorLeftFront;
  private final SpeedController m_MotorRightFront;
  private final SpeedController m_MotorLeftBack;
  private final SpeedController m_MotorRightBack;

  private final SpeedControllerGroup m_Left;
  private final SpeedControllerGroup m_Right;

  

  public DriveBaseSub() { // init some stuff

    m_MotorLeftFront = new WPI_TalonSRX(RobotMap.m_MotorLeftFront);
    m_MotorRightFront = new WPI_TalonSRX(RobotMap.m_MotorRightFront);
    m_MotorLeftBack = new WPI_TalonSRX(RobotMap.m_MotorLeftBack);
    m_MotorRightBack = new WPI_TalonSRX(RobotMap.m_MotorRightBack);

    m_Left = new SpeedControllerGroup(m_MotorLeftFront, m_MotorLeftBack);
    m_Right = new SpeedControllerGroup(m_MotorRightFront, m_MotorRightBack);


    //m_MotorLeftF.setInverted(false); // TODO : Find out if we need to invert it
   // m_MotorRight = RobotMap.m_MotorRight;
   // m_MotorRight.setInverted(false); // TODO : Find out if we need to invert it
    m_DiffDrive = new DifferentialDrive(m_Left, m_Right); 
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
