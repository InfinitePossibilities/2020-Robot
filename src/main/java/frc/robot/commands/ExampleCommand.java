package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class ExampleCommand extends Command {
	private int xnum;
	private boolean _FINISHED = false;

	public ExampleCommand(int x) {
		xnum = x;
	}

	/**
     * Runs on first run
     */
	@Override
	protected void initialize()
	{
		System.out.println("Button Pressed2!: " + xnum);
	}

	/**
     * Runs every run
     */
	@Override
	protected void execute() {
		System.out.println("Button Pressed3!: " + xnum);

		/**
		 * Always set _FINISHED to true.
		 * Will cause a loop/crash if not.
		 */
		_FINISHED = true;
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
		System.out.println("End!");
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
