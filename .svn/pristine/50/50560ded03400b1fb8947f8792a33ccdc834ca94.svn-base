package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;


public class LiftCommand extends Command{
    private double speed;


    public LiftCommand(double liftSpeed){
        speed = liftSpeed;
    }
    

    @Override
    protected void initialize() {
        
    }
    
    @Override
    protected void execute() {
        Robot.lift.setLift(speed);
        

    }
        
    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
		Robot.lift.setLift(0);
    }

    @Override
	protected void interrupted() {
		end();
	}
}