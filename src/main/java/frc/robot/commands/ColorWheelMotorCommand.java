package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ColorWheelMotorCommand extends Command{
    private double colorMotorSpeed;
    public ColorWheelMotorCommand(double speed){
        colorMotorSpeed = speed;
    }

        @Override
        protected void execute() {
           Robot.colorWheelSpin.setColorMotorSpeed(colorMotorSpeed);
        }

        @Override
        protected void end() {
            Robot.colorWheelSpin.hitColorMotorBrakes();

            //Robot.colorWheelSpin.setColorMotorSpeed(0);
        }

    public boolean isFinished(){
        return false;
    }



}