package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.Robot;

public class ColorPickerCommand extends Command {
	// Define set Color and Spin variables on execute
	private int color;
	private int spin;
	private double speed;
	// Define Control/Spin options and chooser hash map for color wheel
	private static String[] ControlOptions = {"Red","Green","Blue","Yellow"};
	private static String[] SpinOptions = {"No Spin", "Spin1x", "Spin2x", "Spin3x", "Spin4x", "Spin5x"};
	private SendableChooser<Integer> OptionsChooser = new SendableChooser<Integer>();
	private SendableChooser<Integer> SpinChooser = new SendableChooser<Integer>();
	// Define Counter and current color variables
	private int spinCounter;
	private int currentColor;
	
	private boolean _FINISHED = false;

	public ColorPickerCommand() {
		// SmartDashboard.putStringArray("GoalColor", ControlOptions);
		for (int i = 0; i < ControlOptions.length; i++) {
			OptionsChooser.addOption(ControlOptions[i], i);
		}
		for (int i = 0; i < SpinOptions.length; i++) {
			SpinChooser.addOption(SpinOptions[i], i);
		}
		SmartDashboard.putData("ControlPanel", OptionsChooser);
		SmartDashboard.putData("SpinPanel", SpinChooser);
		SmartDashboard.putNumber("ColorWheelSpeed", .10);
		color = -1;
		spin = -1;
		speed = .10;
		spinCounter = 0;
		currentColor = 0;
	}

	/**
     * Runs on first run
     */
	@Override
	protected void initialize()
	{
		// Insert Initial Code Here :) <<
		// String[] ControlChoice = SmartDashboard.getStringArray("GoalColor", ControlOptions);

		// for (int i = 0; i < ControlOptions.length; i++) {
		// 	if(ControlOptions[i] == ControlChoice) { color = i; break; };
		// }

		Integer ControlChoice = OptionsChooser.getSelected();
		Integer SpinChoice = SpinChooser.getSelected();

		if (ControlChoice == null) { 
			_FINISHED = true;
			// System.out.println("Invalid Color Choice: " + ControlChoice);
		}else{ 
			_FINISHED = false;
			color = ControlChoice;
			spin = SpinChoice;
			spinCounter = 0;
			currentColor = -1;
			speed = SmartDashboard.getNumber("ColorWheelSpeed", .10);
			//
			System.out.println("Color Choice: " + color);
			System.out.println("Spin Value: " + spin);
		};
  	}

	/**
     * Runs every run
     */
	@Override
	protected void execute() {
		// Do nothing if invalid color choice
		if (_FINISHED) return;

		
		if (true)	{// Robot.colorWheel.getProx() == 2047){
			if (color >= 0 && spin == 0) {
				executeColorPicker();
			}else if (spin > 0) {
				executeSpinWheel(spin*8);
			}
		}else{
			//System.out.println("colorPicker END, arm not down");
			_FINISHED = true;
		}
	}

	void executeColorPicker() {
		int c_color = Robot.colorWheelSensor.getCurrentColor();
		//System.out.println( "colorPicker current color:" + c_color );
		if (c_color == color){
			System.out.println("colorPicker found color: " + color);

			_FINISHED = true;

		}else{
			//System.out.println("colorPicker: Searching for " + color);
			Robot.colorWheelSpin.setColorMotorSpeed(speed);
		}
	}

	void executeSpinWheel(int spinValue) {
		int c_color = Robot.colorWheelSensor.getCurrentColor();

		Robot.colorWheelSpin.setColorMotorSpeed(speed);

		if (currentColor == -1) { 
			currentColor = c_color;
		}else {
			int nextColor = currentColor + 1;
			if (nextColor > 3) { 
				nextColor = 0;
			}
			if (c_color == nextColor) {
				currentColor = nextColor;
				spinCounter++;
			}
		}

		SmartDashboard.putNumber("SpinCounter", spinCounter);

		if (spinCounter >= spinValue) {
			System.out.println("Spin Complete: " + spinCounter);
			_FINISHED = true;
		}
	}

	/**
	 * Calls until true
	 */
	@Override
	protected boolean isFinished() {
		return _FINISHED;
	}

	/**
	 * Calls when isFinished() returns true
	 */
	@Override
	protected void end()
	{
		_FINISHED=true;
		Robot.colorWheelSpin.hitColorMotorBrakes();
		System.out.println("ColorPicker:End!");
	}

	/**
	 * Calls when multiple commands using the same subsystems are run
	 */
	@Override
	protected void interrupted()
	{
		end();
	}

}
