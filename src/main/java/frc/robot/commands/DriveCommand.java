package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command{

    public DriveCommand(){
        requires(Robot.driveTrain);
    }
    
    @Override
    protected void initialize(){
        //TODO
    }

    @Override
    protected void execute(){
        Robot.driveTrain.setRaw(Robot.m_oi.getLeftMotorValue(), Robot.m_oi.getRightMotorValue());
    }

    @Override
    protected boolean isFinished()
    {
        //TODO
        return false;
    }

    @Override
    protected void interrupted(){
        end();
    }

}