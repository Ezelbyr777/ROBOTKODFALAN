package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class Robot extends TimedRobot {
 
   private CANSparkMax leftMotor1 = new CANSparkMax(0, MotorType.kBrushed);  
   private CANSparkMax leftMotor2 = new CANSparkMax(1, MotorType.kBrushed);  
   
   private CANSparkMax rightMotor1 = new CANSparkMax(2, MotorType.kBrushed);  
   private CANSparkMax rightMotor2 = new CANSparkMax(3, MotorType.kBrushed);  
   
   private MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(leftMotor1, leftMotor2);
   private MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(rightMotor1, rightMotor2);

   DifferentialDrive differentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
   private Joystick joy1 = new Joystick(0);   
  
  @Override
  public void robotInit() {
  leftMotorControllerGroup.setInverted(false);
  rightMotorControllerGroup.setInverted(true);
}
  @Override
  public void teleopPeriodic() {} {
  
  double speed = -joy1.getRawAxis(1) * 0.6;
  double turn = joy1.getRawAxis(4) * 0.3;
  
  double left = speed + turn;
  double right = speed - turn;

  differentialDrive.arcadeDrive(left, right);
}
}