package org.firstinspires.ftc.teamcode.Assemblies;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ContinuousRotationMechanism {
    // initialize servo and telemetry
    static CRServo servo = null;
    Telemetry telemetry = null;
    private static final ElapsedTime runtime = new ElapsedTime(ElapsedTime.SECOND_IN_NANO);
    // construct the class
    public ContinuousRotationMechanism(HardwareMap hwMap, Telemetry telemetry) {
        servo = hwMap.get(CRServo.class, "left_hand");
        this.telemetry = telemetry;
    }
    public static void Wait(double Seconds) {
        runtime.reset();
        while (runtime.nanoseconds() < Seconds * 1E+09) {
            // do nothing type sh
        }
    }
    public static void powerUpdate(double power, double time) {
        servo.setPower(power);
        Wait(time);
        servo.setPower(0);
    }
    // runs the action described in the setPosistionPobject Class
    public Action posistionUpdateAction(double power, double time) {
        return new setPosistionPobject(power, time);
    }
}
class setPosistionPobject implements Action {
    double power = 0;
    double timeInSeconds = 0;
    public setPosistionPobject(double p, double t) {
        power = p;
        timeInSeconds = t;
    }
    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        ContinuousRotationMechanism.powerUpdate(power, timeInSeconds);
        return false;
    }
}