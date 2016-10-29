package day10;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotCopyPaster {

	public static void main(String[] args) throws AWTException, InterruptedException {

		// Create instance of Robot class
		Robot robot = new Robot();
		// Create instance of Clipboard class

		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		// Set the String to Enter

		StringSelection stringSelection = new StringSelection("String to enter");
		
		Thread.sleep(5000);
		
		// Copy the String to Clipboard

		clipboard.setContents(stringSelection, null);
		// Use Robot class instance to simulate CTRL+C and CTRL+V key events :

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Simulate Enter key event
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
