/*
    ColorWheelSpinSubsystem

    This implements a motor to spin the wheel

*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

// import frc.robot.commands.HookReleaseCommand;



public class ColorWheelSpinSubsystem extends Subsystem {
    //SEE: 
    // NO!! http://www.revrobotics.com/rev-11-2158/
    // NO!! http://www.revrobotics.com/content/sw/max/sw-docs/java/com/revrobotics/SparkMax.html
    // NO!! http://www.revrobotics.com/sparkmax-software/#java-api
    // NO!! download http://www.revrobotics.com/content/sw/max/sdk/SPARK-MAX-SDK-v1.5.1.zip put into the public folder
    // YES: https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/PWMSparkMax.html
    
    private Spark spinMotor;
    private double DesiredWheelSpeed;
    private double WheelBrakeCounter;

    public ColorWheelSpinSubsystem(){
        //spinMotor = new PWMSparkMax(RobotMap.COLOR_WHEEL_MOTOR_CHANNEL.value);
        spinMotor = new Spark(RobotMap.COLOR_WHEEL_MOTOR_CHANNEL.value);
        WheelBrakeCounter = 0;
        DesiredWheelSpeed = 0;
    }

    public void setColorMotorSpeed(double x) {
        WheelBrakeCounter = 0;
        DesiredWheelSpeed = x;
        //spinMotor.set(x);
    }

    // Bring the color wheel to a stop as quick as possible.
    public void hitColorMotorBrakes()
    {
        WheelBrakeCounter = -1*DesiredWheelSpeed;         // apply reverse brakes
        DesiredWheelSpeed = 0;
    }

    public void execute()
    {
        if ( Math.abs(WheelBrakeCounter) > 0.01 )    {
            spinMotor.set(WheelBrakeCounter);
            WheelBrakeCounter = WheelBrakeCounter * 0.95;
            System.out.println( "Braking! "+WheelBrakeCounter);
        } else if ( Math.abs(DesiredWheelSpeed) > 0.01 ) {
            spinMotor.set(DesiredWheelSpeed);
        } else {
            spinMotor.set(0);
        }

    }   


    @Override
    protected void initDefaultCommand() {
        // setDefaultCommand(new HookReleaseCommand());
        
    }
}
