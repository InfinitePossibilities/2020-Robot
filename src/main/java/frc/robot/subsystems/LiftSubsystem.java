package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftSubsystem extends Subsystem{
    private Spark LiftMotor;
    


    public LiftSubsystem() {
        LiftMotor = new Spark(RobotMap.LIFT_CHANNEL.value);
    }

    public void setLift(double speed) {
        // LiftMotor.set(speed);
        if(Robot.m_oi.getLiftTop() && speed > 0){
            LiftMotor.set(0);
        }else if(Robot.m_oi.getLiftBot() && speed < 0){
            LiftMotor.set(0);
        }else{
            LiftMotor.set(speed);
        }
    }

    


    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }
}
