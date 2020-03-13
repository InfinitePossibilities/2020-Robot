package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.subsystems.FlyWheelSubsystem;

public class FlyWheelCommand extends Command {
//private static boolean toggleFlywheel = false;
    public FlyWheelCommand() {
        requires(Robot.flywheel);
     }
 
     // Runs on first run
	@Override
	 protected void initialize(){
    //    Robot.flywheel.toggleFlywheelActive();
    }
    
    // Runs every run
	@Override
	protected void execute() {
        Robot.flywheel.toggleFlywheelActive();
    }
    
    @Override
    protected boolean isFinished() {
        return true;
    }
}
