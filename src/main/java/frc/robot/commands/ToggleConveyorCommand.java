package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.Robot;

public class ToggleConveyorCommand extends Command {
 
    public ToggleConveyorCommand() {
 	}
 
     // Runs on first run
	@Override
	protected void initialize(){
        //Robot.conveyorBelt.toggleConveyorBeltActive();
    }
    
    // Runs every run
	@Override
	protected void execute() {
    }
    
    @Override
    protected boolean isFinished() {
        return true;
    }
}
