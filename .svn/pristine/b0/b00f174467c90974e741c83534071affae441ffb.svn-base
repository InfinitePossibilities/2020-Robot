package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class HookReleaseCommand extends Command{
    private double xnum;

    public HookReleaseCommand(double x) {
        xnum = x;
    }
    
    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        Robot.hookSub.setMotorSpeed(xnum);
    }
    
    @Override
    protected void execute() {
        // TODO Auto-generated method stub

    }
        
    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void end(){
        System.out.println("End");
		Robot.hookSub.setMotorSpeed(0.0);
    }

    @Override
	protected void interrupted() {
		end();
	}
}