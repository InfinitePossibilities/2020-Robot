package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class ColorLifterCommand extends Command {
    private boolean direction;

    public ColorLifterCommand(boolean gotDirection){
        direction = gotDirection;
    }


    @Override
    protected void execute() {
        Robot.colorWheelLift.setAngle(direction);
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return true;
    }
}
