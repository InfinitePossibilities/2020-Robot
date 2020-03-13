/*
    ConveyorBeltSubsystem

    This controls a motor driving conveyor belt to slide the balls.
    Another motor raises and lowers the conveyor.
    The convery is then limited by two limit switches

    DEVICES:
    - Belt motor
    - Lift motor
    - Upper Limit Switch
    - Lower Limit Switch


*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

// import frc.robot.commands.HookReleaseCommand;
import frc.robot.Robot;
import frc.robot.RobotMap; 




public class ConveyorBeltSubsystem extends Subsystem {
    private Spark beltMotor1;//,beltMotor2;
    
    private double RequestedBeltSpeed;

    public ConveyorBeltSubsystem(){
        beltMotor1 = new Spark(RobotMap.CONVEYOR_BELT_CHANNEL1.value); 
        RequestedBeltSpeed = 0;
    }

    public void setBeltSpeed(double x) {
        RequestedBeltSpeed = x;
        execute();  // call this once to move things along
    }

    public void execute()
    {
        double _beltSpeed;

        if (Math.abs(RequestedBeltSpeed)>0.01)  {
            // Give the user command priority
            _beltSpeed = RequestedBeltSpeed; 
        } else if (Robot.m_oi.getBallLoadSensor())  {
            // If the ball load sensor is tripped,
            // then run the belt until it isn't.
            _beltSpeed = -0.4;
        } else {
            _beltSpeed = 0;
        }
        beltMotor1.set(_beltSpeed);
    }
    
    
    @Override
    protected void initDefaultCommand() {
        // setDefaultCommand(new HookReleaseCommand());
        
    }
}
