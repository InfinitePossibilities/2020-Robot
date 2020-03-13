package frc.robot.subsystems;

// import javax.swing.text.StyledEditorKit.BoldAction;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class FlyWheelSubsystem extends Subsystem {

    private Spark flyMotor;
    private boolean flywheelActive;

    public FlyWheelSubsystem(){
        flyMotor = new Spark(frc.robot.RobotMap.FLYWHEEL_CHANNEL.value);
        flywheelActive = false;
    }

    public void setRaw(double value) {
        if ( flywheelActive ) {
            flyMotor.set(-value/2);
        }else{
            flyMotor.set(0);
        }
     }

    public void toggleFlywheelActive(){
        flywheelActive = !flywheelActive;
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new FlyWheelCommand());  
    }
}