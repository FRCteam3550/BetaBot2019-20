package frc.robot.PIDsettings;

public class Constants {

	/**
	 * Which PID slot to pull gains from. Starting 2018, you can choose from
	 * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
	 * configuration.
	 */



	/**
	 * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
	 * now we just want the primary one.
	 */



	/**
	 * set to zero to skip waiting for confirmation, set to nonzero to wait and
	 * report to DS if action fails.
	 */


    /**
	 * set Cruise Velocity and Acceleration
	 */

	 // ELEVATOR CONSTANTS
	 
	 //slot number 0 
	public static final int kSlotId0 = 0;
	//pid loop number 0
	public static final int kPIDLoopId0 = 0;
	//same for all the slots
	public static final int kTimeoutMs0 = 30;

	//acceleration and velocity for slot 0
	public static final int kCruiseVelocity0 = 20000;
	public static final int kAcceleration0 = 9000;

	//gains for slot0
	public static final Gains kGains0 = new Gains(0.5, 0.0, 0.0, 0.1, 0, 1.0);


	//position 
	public static final double ELEVATORBOTTOM = 200;

//**************************************************************************************************** */

	 //slot number 1 
	public static final int kSlotId1 = 1;
	//pid loop number 1
	public static final int kPIDLoopId1 = 1;
	//same for all the slots
	public static final int kTimeoutMs1 = 30;

	//acceleration and velocity for slot 1
	public static final int kCruiseVelocity1 = 20000;
	public static final int kAcceleration1 = 10000;

	//gains for slot1
	public static final Gains kGains1 = new Gains(2, 0.0, 0.0, 0.1, 0, 1.0);

	public static final double ELEVATORMIDDLE = 4096 * 2;

//**************************************************************************************************** */

	 //slot number 2 
	 public static final int kSlotId2 = 2;
	 //pid loop number 2
	 public static final int kPIDLoopId2 = 2;
	 //same for all the slots
	 public static final int kTimeoutMs2 = 30;
 
	 //acceleration and velocity for slot 2
	 public static final int kCruiseVelocity2 = 25000;
	 public static final int kAcceleration2 = 10000;
 
	 //gains for slot2
	 public static final Gains kGains2 = new Gains(2, 0.0, 0.0, 0.1, 0, 1.0);
 
	 public static final double ELEVATORUP = 4096 * 3.5;

	 // ELEVATOR  CONSTANTS  END
	 

	 // ARM CONSTANTS START

	 //**************************************************************************************************** */

	 //slot number 1 for the arm
	 public static final int kSlotIdArm1 = 0;
	 //pid loop number 2
	 public static final int kPIDLoopIdArm1 = 0;
	 //same for all the slots
	 public static final int kTimeoutMsArm1 = 30;
 
	 //acceleration and velocity for slot 1
	 public static final int kCruiseVelocityArm1 = 25000;
	 public static final int kAccelerationArm1 = 10000;
 
	 //gains for slot1
	 public static final Gains kGainsArm1 = new Gains(2, 0.0, 0.0, 0.1, 0, 1.0);  // for test on robot tests
	 //public static final Gains kGainsArm1 = new Gains(0.5, 0.0, 0.0, 0.1, 0, 1.0);//on 2019 robot
 
	 public static final double ArmUp = 4096 * 3;



	 	 //**************************************************************************************************** */

	 //slot number 2 for the arm
	 public static final int kSlotIdArm2 = 1;
	 //pid loop number 2
	 public static final int kPIDLoopIdArm2 = 0;
	 //same for all the slots
	 public static final int kTimeoutMsArm2 = 30;
 
	 //acceleration and velocity for slot 2
	 public static final int kCruiseVelocityArm2 = 25000;
	 public static final int kAccelerationArm2 = 10000;
 
	 //gains for slot2
	public static final Gains kGainsArm2 = new Gains(2, 0.0, 0.0, 0.2, 0, 1.0);
	//public static final Gains kGainsArm2 = new Gains(0.5, 0.0, 0.0, 0.1, 0, 1.0);  //on 2019 robot
	 public static final double ArmDown = 500;

   // ARM CONSTANTS END

   //WEDGER CONSTANTS START

 //**************************************************************************************************** */

	 //slot number 1 for the wedger
	 public static final int kSlotIdWedger1 = 0;
	 //pid loop number 1
	 public static final int kPIDLoopIdWedger1  = 0;
	 //same for all the slots
	 public static final int kTimeoutMsWedger1  = 10;
 
	 //acceleration and velocity for slot 1
	 public static final int kCruiseVelocityWedger1  = 20000; //25000
	 public static final int kAccelerationVWedger1  = 15000;
 
	 //gains for slot1
	 public static final Gains kGainsWedger1  = new Gains(20 , 0.0, 0.0, 0, 0, 1.0);
 
	 public static final double Wedger1  =-1637;


//**************************************************************************************************** */

	 //slot number 2 for the wedger
	 public static final int kSlotIdWedger2 = 1;
	 //pid loop number 2
	 public static final int kPIDLoopIdWedger2  = 0;
	 //same for all the slots
	 public static final int kTimeoutMsWedger2  = 10;
 
	 //acceleration and velocity for slot 2
	 public static final int kCruiseVelocityWedger2  = 25000;
	 public static final int kAccelerationVWedger2  = 10000;
 
	 //gains for slot2
	 public static final Gains kGainsWedger2  = new Gains(1, 0.0, 0.0, 0.2, 0, 1.0);
 
	 public static final double Wedger2  = 900;

	 
	 
//**************************************************************************************************** */

	 //slot number 0 for the wedger
	 public static final int kSlotIdWedger0 = 2;
	 //pid loop number 0
	 public static final int kPIDLoopIdWedger0  = 0;
	 //same for all the slots
	 public static final int kTimeoutMsWedger0  = 10;
 
	 //acceleration and velocity for slot 0
	 public static final int kCruiseVelocityWedger0  = 10000; //25000
	 public static final int kAccelerationVWedger0  = 10000; //25000
 
	 //gains for slot0
	 public static final Gains kGainsWedger0  = new Gains(0.2, 0.0, 0.0, 2, 0, 1.0);
 
	 //public static final double Wedger0  = -1500; //
	 public static final double Wedger0  = 0; //



	 //**************************************************************************************************** */
//armSub Costants

	 //slot number 0 for the wedger
	 public static final int kSlotIdArmSub0 = 0;
	 //pid loop number 0
	 public static final int kPIDLoopIdArmSub0 = 0;
	 //same for all the slots
	 public static final int kTimeoutMsArmSub0  = 30;
 
	 //acceleration and velocity for slot 0
	 public static final int kCruiseVelocitArmSub0= 25000;
	 public static final int kAccelerationArmSub0  = 10000;
 
	 //gains for slot0
	 public static final Gains kGainsArmSub0 = new Gains(1, 0.0, 0.0, .2, 0, 1.0);
 
	 public static final double ArmSub0= -600; 
	/**
	 * Gains used in Motion Magic, to be adjusted accordingly
     * Gains(kp, ki, kd, kf, izone, peak output);
     */

	 //WEDGER CONSTANTS END
}

