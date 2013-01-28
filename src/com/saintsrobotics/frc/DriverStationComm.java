package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Allows the robot to communicate with the driver station.
 * @author Saints Robotics
 */
public class DriverStationComm {
    private DriverStation driverStation;
    private DriverStationEnhancedIO enhancedIO;
    private DriverStationLCD LCD;
    
    public DriverStationComm() {
        driverStation = DriverStation.getInstance();
        enhancedIO = driverStation.getEnhancedIO();
        LCD = DriverStationLCD.getInstance();
    }
    
    /**
     * Print a boolean message to the User Messages box.
     * @param line
     * @param startingColumn
     * @param booleanMessage 
     */
    public void printMessage(DriverStationLCD.Line line, int startingColumn,
            boolean booleanMessage) {
        String message = (booleanMessage ? "True" : "False");
        printMessage(line, startingColumn, message);
    }
    
    /**
     * Print a message to the User Messages box.
     * @param line
     * @param startingColumn
     * @param message 
     */
    public void printMessage(DriverStationLCD.Line line, int startingColumn,
            String message) {
        String shortenedMessage = shortenMessage(message);
        LCD.println(line, startingColumn, shortenedMessage);
        LCD.updateLCD();
    }
    
    /**
     * Set the state of an LED on the IO board.
     * @param channel
     * @param on 
     */
    public void setLED(int channel, boolean on) {
        try {
            enhancedIO.setLED(channel, on);
        }
        catch (Exception exception) {
            Logger.log(exception);
        }
    }
    
    /**
     * Shorten the message for the LCD.
     * @param message
     * @return 
     */
    private String shortenMessage(String message) {
        return message.substring(0, DriverStationLCD.kLineLength);
    }
}
