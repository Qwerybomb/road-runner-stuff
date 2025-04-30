package org.firstinspires.ftc.teamcode.Assemblies;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ContinuousRotationMechanism {
    static CRServo servo = null;
    Telemetry telemetry = null;
    public ContinuousRotationMechanism(HardwareMap hwMap, Telemetry telemetry) {
        servo = hwMap.get(CRServo.class, "left_hand");
        this.telemetry = telemetry;
    }
    public static void powerUpdate(double power, double time) {
        servo.setPower(power);
        try {
            Thread.sleep((long) (time * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public class setPosistionPobject implements Action {
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
    public Action posistionUpdateAction(double posistion, double time) {
        return new setPosistionPobject(posistion, time);
    }
}
