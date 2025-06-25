package org.firstinspires.ftc.teamcode.Assemblies;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw {
    // Set up variables
    static Servo rightServo, leftServo;
    Telemetry telemetry;

    double servoPosition = 0.0;
    static boolean clawOpen = false;

    public Claw(HardwareMap hwMap, Telemetry telemetry) {
        rightServo = hwMap.get(Servo.class,"rightservo");    // expansion servo slot 2
        leftServo  = hwMap.get(Servo.class,"leftservo");     // expansion servo slot 1
        rightServo.setPosition(servoPosition);
        leftServo.setPosition(1.0);
        this.telemetry = telemetry;
    }

    public static void open(boolean gamePad) {
        if (gamePad) {
            if (clawOpen) {
                rightServo.setPosition(1.0);
                leftServo.setPosition(0.0);
                clawOpen = !clawOpen;
            } else {
                rightServo.setPosition(0.0);
                leftServo.setPosition(1.0);
                clawOpen = true;
            }
        }
    }

    public void clawTelemetry() {
        telemetry.addData("ClawOpen", "%b", clawOpen);
        telemetry.addData("rightServoPos", "%4.2f", rightServo.getPosition());
        telemetry.addData("leftServoPos", "%4.2f", leftServo.getPosition());
    }

    // class for creating the toggle claw action
    static class toggleClaw implements Action {
        boolean clawToggle = false;

        // feed in the boolean
        toggleClaw(boolean b) {
            clawToggle = b;
        }

        // run the function
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            Claw.open(clawToggle);
            return false;

        }
    }

    // function for returning the Action created in toggleClaw
    public Action clawToggle(boolean b) {

        return new toggleClaw(b);
    }
}