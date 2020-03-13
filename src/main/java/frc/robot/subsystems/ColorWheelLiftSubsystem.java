/*
    ColorWheelLiftSubsystem

    And a linear actuator to raise and lower the 
    color wheel reader mechanism.

*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

// import frc.robot.commands.HookReleaseCommand;



public class ColorWheelLiftSubsystem extends Subsystem {
    private Servo colorLifters;
    private final int _MAX_ANGLE = 180;
    private final int _MIN_ANGLE = 81;
    private double _ANGLE = 85;

    public ColorWheelLiftSubsystem(){
        colorLifters = new Servo (RobotMap.ACTUATORS_CHANNEL.value);
    }

    public void setAngle(boolean direction){
        if (direction){_ANGLE = _ANGLE -1;}else{_ANGLE = _ANGLE + 1;}
        if (_ANGLE > _MAX_ANGLE){ _ANGLE = _MAX_ANGLE;}
        if (_ANGLE < _MIN_ANGLE){ _ANGLE = _MIN_ANGLE;}
        colorLifters.setAngle(_ANGLE);
        // System.out.println(_ANGLE);
        SmartDashboard.putNumber("Lift Angle", _ANGLE);
    }

    public void execute(){
        colorLifters.setAngle(_ANGLE);
    }   

    @Override
    protected void initDefaultCommand() {
        // setDefaultCommand(new HookReleaseCommand());
        
    }
}
