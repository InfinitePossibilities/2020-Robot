/*
    ColorWheelSensorSubsystem

    This a sensor to detect the current color.

*/
package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.Timer;

// import frc.robot.commands.HookReleaseCommand;



public class ColorWheelSensorSubsystem extends Subsystem {
    private final I2C.Port I2Cport = I2C.Port.kOnboard;
    private final ColorSensorV3 colorSensor = new ColorSensorV3(I2Cport);

    private final ColorMatch colorMatcher = new ColorMatch();
    private final Color blueTarget = ColorMatch.makeColor(0.114258, 0.4280155, 0.45678);
    private final Color greenTarget = ColorMatch.makeColor(0.15497, 0.591064, 0.2503);
    private final Color redTarget = ColorMatch.makeColor(0.526123, 0.345215, 0.12806);
    private final Color yellowTarget = ColorMatch.makeColor(0.310741, 0.571045, 0.118408);
    private final Color woodTarget = ColorMatch.makeColor(0.3219824,0.505615,0.174805);

    private Timer ColorDelayTimer = new Timer();
    private int prox;


    //Clockwise, wheel goes through 8 octants, R-G-B-Y-R-G-B-Y
    //                                         0 1 2 3 0 1 2 3
    //
    private int currentResolvedColor;

    private void resetWheelTracker()
    {
        ColorDelayTimer.reset();
        currentResolvedColor = -1;
    }
    public int getCurrentColor(){return currentResolvedColor;}

    // color is 0=red, 1=green, 2=blue, 3=yellow, -1=unknown
    private void updateWheelTrackerColor( int color )
    {
        currentResolvedColor = color;
    /*    if ( color != currentResolvedColor) {
            ColorDelayTimer.reset();
            ColorDelayTimer.start();
            currentResolvedColor = color; 
		    //System.out.println("*");
        } else {
            if ( !ColorDelayTimer.hasPeriodPassed(0.05))  {
               // System.out.println("!");
                return;
            }
            //System.out.println("OK");

        }
*/
        // Update smart dash
        SmartDashboard.putNumber("ResolvedWheelColor",currentResolvedColor);
    }


    public ColorWheelSensorSubsystem(){
        prox = 0;
        resetWheelTracker();
    
        colorMatcher.addColorMatch(blueTarget);
        colorMatcher.addColorMatch(greenTarget);
        colorMatcher.addColorMatch(redTarget);
        colorMatcher.addColorMatch(yellowTarget);
        // No need with taped wheel: colorMatcher.addColorMatch(woodTarget);

        // Set once at init and link it to the SmartDash so we
        // an change it for testing.
        
    }

    public int getProx(){return prox;}

    public void execute(){
        Color detectedColor = colorSensor.getColor();
        double ir = colorSensor.getIR();
        prox = colorSensor.getProximity();
        ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
        String colorString;
        int wheelColorIndex = -1;

        if ( match.color == blueTarget) {
            colorString = "Blue";
            wheelColorIndex = 2;
        } else if ( match.color == redTarget ) {
            colorString = "Red";
            wheelColorIndex = 0;
        } else if ( match.color == greenTarget ) {
            colorString = "Green";
            wheelColorIndex = 1;
        } else if ( match.color == yellowTarget ) {
            colorString = "Yellow";
            wheelColorIndex = 3;
        } else if ( match.color == woodTarget ) {
            colorString = "Wood";
        } else {
            colorString = "Unknown";
        }
		//System.out.println("color: " + colorString);
        updateWheelTrackerColor(wheelColorIndex);

        SmartDashboard.putNumber("RED", detectedColor.red);
        SmartDashboard.putNumber("GREEN", detectedColor.green);
        SmartDashboard.putNumber("BLUE", detectedColor.blue);
        SmartDashboard.putNumber("IR", ir);
        SmartDashboard.putNumber("PROX", prox);
        SmartDashboard.putString("Color",colorString);
        SmartDashboard.putNumber("Color#",wheelColorIndex);

    }   


    @Override
    protected void initDefaultCommand() {
        // setDefaultCommand(new HookReleaseCommand());
        
    }
}
