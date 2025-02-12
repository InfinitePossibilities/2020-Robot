package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

// import frc.robot.commands.IntakeCommand;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class IntakeSubsystem extends Subsystem{
    private Spark intakeMotor;
    private boolean intakeToggle = false;

    public IntakeSubsystem(){
        intakeMotor = new Spark(RobotMap.INTAKE_CHANNEL.value);
    }

    public void setIntake(double intakeSpeed){
        if (intakeToggle){intakeMotor.set(-intakeSpeed);
        }else{intakeMotor.set(0);}
    }
    
    public void toggleIntake(){intakeToggle = !intakeToggle;}

    public boolean getIntakeToggle(){return intakeToggle;}

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        
    }
}