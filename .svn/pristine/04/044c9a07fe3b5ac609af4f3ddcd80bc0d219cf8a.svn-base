package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;


public class IntakeCommand extends Command{
    private int _direction;

    public IntakeCommand(int direction){
        _direction = direction;
    }
    

    @Override
    protected void initialize() {
        
        
        // if (intakeToggle){Robot.intake.setIntake(intakeSpeed);
        // }else{Robot.intake.setIntake(0);}
        //Robot.intake.setIntake(.5);
    }
    
    @Override
    protected void execute() {
        // runs every run
        // _direction ? Robot.intake.toggleIntake() : Robot.intake.toggleDirection();
        Robot.intake.toggleIntake();
        // Robot.intake.toggleDirection();

    }
        
    @Override
    protected boolean isFinished(){
        return true;
    }

    @Override
    protected void end(){
        System.out.println("End");
		Robot.intake.setIntake(0.0);
    }

    @Override
	protected void interrupted() {
		end();
	}
}