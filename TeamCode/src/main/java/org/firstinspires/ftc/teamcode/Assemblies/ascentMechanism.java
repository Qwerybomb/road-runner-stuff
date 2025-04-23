package org.firstinspires.ftc.teamcode.Assemblies;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ascentMechanism {

    Telemetry telemetry;
    static final double INCREMENT   = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final double MAX_POS     =  1.0;     // Maximum rotational position
    static final double MIN_POS     =  0.0;     // Minimum rotational position

    // Define class members
    static Servo   servo;

    double position = (MAX_POS - MIN_POS) / 2; // Start at halfway position

    public ascentMechanism(HardwareMap hwMap, Telemetry telemetry) {

        // initiates servo name
        servo = hwMap.get(Servo.class, "left_hand");
        this.telemetry = telemetry;
    }
    // class for parallelism
    public class setPosistion implements Action {
        int pos = 0;
        public setPosistion(int p) {
            pos = p;
        }
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            ascentMechanism.SetPosistion(pos);
            return false;
        }
    }

    // action for setPosistion
    public Action armMove(int turn) {
        return new setPosistion(turn);
    }
    public void rise(boolean rise, boolean lower) {
        if (rise) { // Makes the robot's arm rise
            // Keep stepping up until we hit the max value.
            position += INCREMENT;
            if (position >= MAX_POS) {
                position = MAX_POS;
            }
        }
        else if (lower) { // Makes the robot's arm lower
            // Keep stepping down until we hit the min value.
            position -= INCREMENT;
            if (position <= MIN_POS ) {
                position = MIN_POS;
            }
        }
        // Set the servo to the new position and pause;
        servo.setPosition(position);
    }

    public void armPosition(double armPosition) {
        if (position < armPosition) { // Tells arm to rise
            position += INCREMENT;
            if (position >= MAX_POS) {
                position = MAX_POS;
            }
        }
        else if (position > armPosition) { // Makes the robot's arm lower
            position -= INCREMENT;
            if (position <= MIN_POS ) {
                position = MIN_POS;
            }
        }
        // Set the servo to the new arm position and pause;
        servo.setPosition(position);
    }

    public static void SetPosistion(double Posistion) {
        servo.setPosition(Posistion);
    }
}
