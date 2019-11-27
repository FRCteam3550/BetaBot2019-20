/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.detroit2019testcode.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import frc.robot.detroit2019testcode.PIDsettings.Constants;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.detroit2019testcode.commands.StopWedger;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import frc.robot.detroit2019testcode.commands.StopWedger;
import frc.robot.detroit2019testcode.commands.WedgerManual;

/**
 * Add your docs here.
 */
public class WedgerSub extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static TalonSRX m_wedgerMotor = new TalonSRX(RobotMap.m_WedgerMotor);
  //private static TalonSRX m_wedgerMobile = new TalonSRX(RobotMap.m_WedgerMobile);
  

  public WedgerSub(){ 
     m_wedgerMotor.configFactoryDefault();
    m_wedgerMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, Constants.kTimeoutMs0);
  
       /* Configure Sensor Source for Pirmary PID */
       m_wedgerMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
        Constants.kPIDLoopId0, 
        Constants.kTimeoutMs0);
  
                     m_wedgerMotor.setNeutralMode(NeutralMode.Brake);    
//       /**
       // * Configure Talon SRX Output and Sesnor direction accordingly
       // * Invert Motor to have green LEDs when driving Talon Forward / Requesting Postiive Output
     //  * Phase sensor to have positive increment when driving Talon Forward (Green LED)
       
     m_wedgerMotor.setSensorPhase(false); //false on the tests robot and True on the Year's robot
      m_wedgerMotor.setInverted(true);
  
      /* Set relevant frame periods to be at least as fast as periodic rate */
      m_wedgerMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs0);
      m_wedgerMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs0);
  
      /* Set the peak and nominal outputs */
      m_wedgerMotor.configNominalOutputForward(0, Constants.kTimeoutMs0);
      m_wedgerMotor.configNominalOutputReverse(0, Constants.kTimeoutMs0);
      m_wedgerMotor.configPeakOutputForward(1, Constants.kTimeoutMs0);
      m_wedgerMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs0);
  
  
      /* Set Motion Magic gains in slot0 - see documentation */
     m_wedgerMotor.selectProfileSlot(Constants.kSlotId0, Constants.kPIDLoopId0);
      m_wedgerMotor.config_kF(Constants.kSlotId0, Constants.kGains0.kF, Constants.kTimeoutMs0);
      m_wedgerMotor.config_kP(Constants.kSlotId0, Constants.kGains0.kP, Constants.kTimeoutMs0);
      m_wedgerMotor.config_kI(Constants.kSlotId0, Constants.kGains0.kI, Constants.kTimeoutMs0);
      m_wedgerMotor.config_kD(Constants.kSlotId0, Constants.kGains0.kD, Constants.kTimeoutMs0);
  
      m_wedgerMotor.configMotionCruiseVelocity(Constants.kCruiseVelocity0, Constants.kTimeoutMs0);
      m_wedgerMotor.configMotionAcceleration(Constants.kAcceleration0, Constants.kTimeoutMs0);
  
      //Zeroes the Sensor
      m_wedgerMotor.setSelectedSensorPosition(0, Constants.kPIDLoopId0, Constants.kTimeoutMs0);

      //******************************************8************************** */

     // m_wedgerMobile.configFactoryDefault();
      //m_wedgerMobile.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, Constants.kTimeoutMs0);
      
            /* Configure Sensor Source for Pirmary PID */
        // m_wedgerMobile.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
            // Constants.kPIDLoopId0, 
            // Constants.kTimeoutMs0);
       
                      // m_wedgerMobile.setNeutralMode(NeutralMode.Brake);    
     //       /**
            // * Configure Talon SRX Output and Sesnor direction accordingly
            // * Invert Motor to have green LEDs when driving Talon Forward / Requesting Postiive Output
          //  * Phase sensor to have positive increment when driving Talon Forward (Green LED)
            
      // m_wedgerMobile.setSensorPhase(false); //false on the tests robot and True on the Year's robot
      //  m_wedgerMobile.setInverted(false);
       
           /* Set relevant frame periods to be at least as fast as periodic rate */
      //  m_wedgerMobile.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs0);
       // m_wedgerMobile.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs0);
       
           /* Set the peak and nominal outputs */
       // m_wedgerMobile.configNominalOutputForward(0, Constants.kTimeoutMs0);
      //  m_wedgerMobile.configNominalOutputReverse(0, Constants.kTimeoutMs0);
      //  m_wedgerMobile.configPeakOutputForward(1, Constants.kTimeoutMs0);
      //  m_wedgerMobile.configPeakOutputReverse(-1, Constants.kTimeoutMs0);
       
       
           /* Set Motion Magic gains in slot0 - see documentation */
      // m_wedgerMobile.selectProfileSlot(Constants.kSlotId0, Constants.kPIDLoopId0);
      //  m_wedgerMobile.config_kF(Constants.kSlotId0, Constants.kGains0.kF, Constants.kTimeoutMs0);
      //  m_wedgerMobile.config_kP(Constants.kSlotId0, Constants.kGains0.kP, Constants.kTimeoutMs0);
       // m_wedgerMobile.config_kI(Constants.kSlotId0, Constants.kGains0.kI, Constants.kTimeoutMs0);
      //  m_wedgerMobile.config_kD(Constants.kSlotId0, Constants.kGains0.kD, Constants.kTimeoutMs0);
       
      //  m_wedgerMobile.configMotionCruiseVelocity(Constants.kCruiseVelocity0, Constants.kTimeoutMs0);
      //  m_wedgerMobile.configMotionAcceleration(Constants.kAcceleration0, Constants.kTimeoutMs0);
       
           //Zeroes the Sensor
      //  m_wedgerMobile.setSelectedSensorPosition(0, Constants.kPIDLoopId0, Constants.kTimeoutMs0);

 }
  public void initDefaultCommand() {
      setDefaultCommand(new WedgerManual());
  }

  /*public void setWedgerMotorSpeed(double speed){
    m_wedgerMobile.set(ControlMode.PercentOutput, speed);
  }*/

  public void resetWedger(){
   //Zeroes the Sensor
   m_wedgerMotor.setSelectedSensorPosition(0, Constants.kPIDLoopId0, Constants.kTimeoutMs0); 
  // m_wedgerMobile.setSelectedSensorPosition(0, Constants.kPIDLoopId0, Constants.kTimeoutMs0);
  }

  public void StopWedger(){
    m_wedgerMotor.set(ControlMode.PercentOutput, 0);
  }

  public void moveWedgerManual(double axey){
    m_wedgerMotor.set(ControlMode.PercentOutput, axey);
  }

  public double getEncoder(){
    return m_wedgerMotor.getSelectedSensorPosition();
  }

  public double getPosition(){
    return getEncoder();
  }

  public void configPos1(){
    m_wedgerMotor.selectProfileSlot(Constants.kSlotIdWedger1, Constants.kPIDLoopIdWedger1);
    m_wedgerMotor.config_kF(Constants.kSlotIdWedger1, Constants.kGainsWedger1.kF, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kP(Constants.kSlotIdWedger1, Constants.kGainsWedger1.kP, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kI(Constants.kSlotIdWedger1, Constants.kGainsWedger1.kI, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kD(Constants.kSlotIdWedger1, Constants.kGainsWedger1.kD, Constants.kTimeoutMs0);
  }

  public void goPos1(double position){
    m_wedgerMotor.set(ControlMode.MotionMagic, position);    
  }

  public void configPos2(){
    m_wedgerMotor.selectProfileSlot(Constants.kSlotIdWedger2, Constants.kPIDLoopIdWedger2);
    m_wedgerMotor.config_kF(Constants.kSlotIdWedger2, Constants.kGainsWedger2.kF, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kP(Constants.kSlotIdWedger2, Constants.kGainsWedger2.kP, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kI(Constants.kSlotIdWedger2, Constants.kGainsWedger2.kI, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kD(Constants.kSlotIdWedger2, Constants.kGainsWedger2.kD, Constants.kTimeoutMs0);
  }

  public void goPos2(double position){
    m_wedgerMotor.set(ControlMode.MotionMagic, position);    
  }

  public void ResetWedger(double position){
    m_wedgerMotor.set(ControlMode.PercentOutput, position);    
  }

  public void configPos0(){
		m_wedgerMotor.selectProfileSlot(Constants.kSlotId0, Constants.kPIDLoopId0);
		m_wedgerMotor.config_kF(Constants.kSlotId0, Constants.kGains0.kF, Constants.kTimeoutMs0);
		m_wedgerMotor.config_kP(Constants.kSlotId0, Constants.kGains0.kP, Constants.kTimeoutMs0);
	  m_wedgerMotor.config_kI(Constants.kSlotId0, Constants.kGains0.kI, Constants.kTimeoutMs0);
    m_wedgerMotor.config_kD(Constants.kSlotId0, Constants.kGains0.kD, Constants.kTimeoutMs0);

	  m_wedgerMotor.configMotionCruiseVelocity(Constants.kCruiseVelocity0, Constants.kTimeoutMs0);
    m_wedgerMotor.configMotionAcceleration(Constants.kAcceleration0, Constants.kTimeoutMs0);
  }

  public void goPos0(double position){
    m_wedgerMotor.set(ControlMode.MotionMagic, position);    
  }

  public void getWedgerInfo(){
    SmartDashboard.putNumber("wedger Pos", m_wedgerMotor.getSelectedSensorPosition());
    SmartDashboard.putNumber("wedger vel" , m_wedgerMotor.getSelectedSensorVelocity());
   // SmartDashboard.putBoolean("wedger front sensor", m_wedgerMobile.getSensorCollection().isFwdLimitSwitchClosed());
   // SmartDashboard.putBoolean("wedger back sensor", m_wedgerMobile.getSensorCollection().isRevLimitSwitchClosed());
    SmartDashboard.putBoolean("wedger pos0", getStatusPos0());
    SmartDashboard.putBoolean("wedger pos0", getStatusPos1());
  }

  public boolean getStatusPos0(){
    boolean status = false;
    if (m_wedgerMotor.getSelectedSensorPosition(Constants.kPIDLoopId0) == -400){
      status = true;
      
    }
    return status;
  }

  public boolean getStatusPos1(){
    boolean status = false;
    if (m_wedgerMotor.getSelectedSensorPosition(Constants.kPIDLoopId0) == 500){
      status = true;
      
    }
    return status;
  }

 /* public void setWedgerMobile(double speed){
    m_wedgerMobile.set(ControlMode.PercentOutput , speed);
  } */


  public void setWedge(double speed){
    m_wedgerMotor.set(ControlMode.PercentOutput , speed);
  }

  
}
