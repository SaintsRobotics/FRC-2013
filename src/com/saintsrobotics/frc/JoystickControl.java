package com.saintsrobotics.frc;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The joystick control for the robot.
 * @author Saints Robotics
 */
public class JoystickControl {
    // USB ports for the joysticks
    private static final int JOYSTICK_LEFT_DRIVE_PORT = 1;
    private static final int JOYSTICK_RIGHT_DRIVE_PORT = 2;
    private static final int JOYSTICK_OPERATOR_PORT = 3;
    
    // Constant to convert joystick value to between -1 to 1
    private final int JOYSTICK_CONSTANT = 200;
    
    private Joystick leftDriveJoystick;
    private Joystick rightDriveJoystick;
    private Joystick operatorJoystick;
    
    public JoystickControl() {
        leftDriveJoystick = new Joystick(JOYSTICK_LEFT_DRIVE_PORT);
        rightDriveJoystick = new Joystick(JOYSTICK_RIGHT_DRIVE_PORT);
        operatorJoystick = new Joystick(JOYSTICK_OPERATOR_PORT);
    }
    
    public double readLeftJoystick() {
        return leftDriveJoystick.getRawAxis(1) / JOYSTICK_CONSTANT;
    }
    
    public double readRightJoystickX() {
        return leftDriveJoystick.getRawAxis(2) / JOYSTICK_CONSTANT;
    }
    
    public double readRightJoystickY() {
        return leftDriveJoystick.getRawAxis(1) / JOYSTICK_CONSTANT;
    }
}
