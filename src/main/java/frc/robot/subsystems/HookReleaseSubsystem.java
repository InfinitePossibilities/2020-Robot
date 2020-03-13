package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
// import frc.robot.RobotMap;

// import frc.robot.commands.HookReleaseCommand;
import frc.robot.RobotMap;


public class HookReleaseSubsystem extends Subsystem {
    private Spark hookMotor;

    public HookReleaseSubsystem(){
        hookMotor = new Spark(RobotMap.HOOK_RELEASE_CHANNEL.value);
    }

    
    public void setMotorSpeed(double x) {
        hookMotor.set(x);
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new HookReleaseCommand());
        
    }
}
