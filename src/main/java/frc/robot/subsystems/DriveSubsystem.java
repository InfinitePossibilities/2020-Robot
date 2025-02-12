package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

//import org.graalvm.compiler.nodes.calc.RightShiftNode;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends Subsystem{
    //declare motor variables
    private Spark MainLeftMotor;
    private Spark MainRightMotor;
    private boolean motorDirection = true;
    
    public DriveSubsystem(){
        MainLeftMotor = new Spark(RobotMap.LEFT_MOTOR_CHANNEL.value);
        MainRightMotor = new Spark(RobotMap.RIGHT_MOTOR_CHANNEL.value);
    }

    public void setRaw(double leftMotorValue, double rightMotorValue) {
        MainLeftMotor.set(leftMotorValue);
        MainRightMotor.set(-rightMotorValue);

    }




    // public void setRaw(double twistValue, double yValue) {


    //     if (twistValue>0 || twistValue<0){
    //         MainLeftMotor.set(twistValue);
    //         MainRightMotor.set((twistValue));
    //         System.out.println("twist:"+twistValue);
    //     }
        
    //     if (twistValue==0){
    //     MainLeftMotor.set(-yValue);
    //     MainRightMotor.set(yValue);
    //     System.out.println("y:"+yValue);
    //     }
    // }

    @Override
    protected void initDefaultCommand(){
        setDefaultCommand(new DriveCommand());
    }

}