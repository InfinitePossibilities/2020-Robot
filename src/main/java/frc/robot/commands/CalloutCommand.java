package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class CalloutCommand extends Command {
	private int xnum;
	private boolean _FINISHED = false;

	public CalloutCommand(int x) {
		xnum = x;
	}

	/**
     * Runs on first run
     */
	@Override
	protected void initialize()
	{
		// Insert Initial Code Here :) <<
	}

	/**
     * Runs every run
     */
	@Override
	protected void execute() {
		System.out.println("Button Pressed1!: " + xnum);

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
