/*--------------------------------Imports-----------------------*/
package frc.robot;

// import frc.robot.commands.ExampleCommand;
import frc.robot.commands.CalloutCommand;
import frc.robot.commands.ColorLifterCommand;
import frc.robot.commands.ColorPickerCommand;
import frc.robot.commands.ColorWheelMotorCommand;
import frc.robot.commands.FlyWheelCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.HookReleaseCommand;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ConveyorBeltCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LiftCommand;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;


public class OI {
    public static Joystick stick0 = new Joystick(0);
    // public static Joystick stick1 = new Joystick(1);
    public static final double JOYSTICK_Y_DEADBAND = 0.15;
    public static final double JOYSTICK_TWIST_DEADBAND = 0.15;
    public static final double JOYSTICK_Y_GAIN = 0.85;
    public static final double JOYSTICK_TWIST_GAIN = 0.5;



    AnalogInput distanceSensor = new AnalogInput(0);
    AnalogInput conveyorSensor = new AnalogInput(1);
    AnalogInput colorSensor    = new AnalogInput(2);
    DigitalInput liftSensorTop  = new DigitalInput(4);
    DigitalInput liftSensorBot  = new DigitalInput(5);
    DigitalInput BallLoadSensor  = new DigitalInput(6);


    public OI() {


        /**
         * Establishes Callout Buttons
         */
        final int buttonCount = 13;

        // Define buttons 0-13 into a when pressed callout object
        for (int i = 1; i < buttonCount; i++) {
            final JoystickButton i_Button = new JoystickButton(stick0, i);
            System.out.println(i);
            i_Button.whenPressed(new CalloutCommand(i));
        }


        /**
         * Button variables
         */
        final JoystickButton trigger0 = new JoystickButton(stick0, 1);
        final JoystickButton thumb0 = new JoystickButton(stick0, 2);
        final JoystickButton button3x = new JoystickButton(stick0, 3);
        final JoystickButton button4x = new JoystickButton(stick0, 4);
        final JoystickButton button5x = new JoystickButton(stick0, 5);
        final JoystickButton button6x = new JoystickButton(stick0, 6);
        final JoystickButton button7x = new JoystickButton(stick0, 7);
        final JoystickButton button8x = new JoystickButton(stick0, 8);
        final JoystickButton button9x = new JoystickButton(stick0, 9);
        final JoystickButton button10x = new JoystickButton(stick0, 10);
        final JoystickButton button11x = new JoystickButton(stick0, 11);
        final JoystickButton button12x = new JoystickButton(stick0, 12);
        final POVButton povUp = new POVButton(stick0, 0);
        final POVButton povDown = new POVButton(stick0, 180);
        final POVButton povRight = new POVButton(stick0, 90);
        final POVButton povLeft = new POVButton(stick0, 270);



        /**
         * Button Commands
         */
        trigger0.whileHeld(new ConveyorBeltCommand(-0.4));
        thumb0.whileHeld(new ConveyorBeltCommand(0.4));
        //button2x.whenPressed(new CalloutCommand(4));
        button4x.whileHeld(new LiftCommand(-1));// up
        button5x.whenPressed(new ColorPickerCommand());
        button6x.whileHeld(new LiftCommand(1));// down
        button7x.whenPressed(new FlyWheelCommand());
        // button8x.whileHeld(new ConveyorBeltCommand(-0.5));
        button9x.whenPressed(new IntakeCommand(-1));
        button10x.whenPressed(new CalloutCommand(10));
        button11x.whileHeld(new HookReleaseCommand(-1));
        button12x.whileHeld(new HookReleaseCommand(1));
        povUp.whenPressed(new ColorLifterCommand(true));
        povDown.whenPressed(new ColorLifterCommand(false));
       povRight.whileHeld(new ColorWheelMotorCommand(0.3));
       povLeft.whileHeld(new ColorWheelMotorCommand(-0.3));
    } 
    //drive Wheel stuff
    public double getDeadbandOutput(final double input, final double DB, final double Gain) {
        return (Math.abs(input) < DB ? 0.0 : ( input > 0 ? input - DB : input + DB )) * Gain;
    }

    public double getJoyY(){
        return getDeadbandOutput(stick0.getY(), JOYSTICK_Y_DEADBAND, JOYSTICK_Y_GAIN);
    }

    public double getJoySpin(){
        return getDeadbandOutput(stick0.getTwist(), JOYSTICK_TWIST_DEADBAND, JOYSTICK_TWIST_GAIN);
    }

    public double getLeftMotorValue() {  return ((/*change - if the y is backwards*/getJoyY() + getJoySpin())); }

    public double getRightMotorValue() { return ((/*change - if the y is backwards*/getJoyY() - getJoySpin())); }


    // Flywheel stuff
    public double getThrottle(){
        return(stick0.getThrottle());
    }

    public Joystick getJoystick(){
        return stick0;
    }

    public int getDistanceSensorRaw(){
        return distanceSensor.getValue();
    }

    public int getConveyorSensorRaw(){
        return conveyorSensor.getValue();
    }

    public int getColorSensor(){
        return colorSensor.getValue();
    }

    public double getSensor_mm() {
        return getDistanceSensorRaw() / 4.0 * 5.0;
    }

    public double getSensor_in() {
        return getSensor_mm() / 25.4;
    }

    public double getSensor_ft() {
        return getSensor_in() / 12.0;
    }

    public boolean getLiftBot() {
        return liftSensorBot.get();
    }

    public boolean getLiftTop() {
        return liftSensorTop.get();
    }

    public boolean getBallLoadSensor()
    {
        // Invert
        boolean x = !BallLoadSensor.get();
        SmartDashboard.putBoolean("BallLoadSwitch", x);
        return x;
    }

}
