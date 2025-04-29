package org.firstinspires.ftc.teamcode.Paths;
import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.teamcode.Assemblies.ascentMechanism;


@TeleOp(name = "Test", group = "Concept")
public class operationTest extends LinearOpMode {
    ascentMechanism arm = new ascentMechanism(hardwareMap, telemetry);

    @Override
    public void runOpMode() {
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("intendedRotation", arm.getPosistion());
            arm.armMove((int) gamepad1.left_stick_x);
        }
    }
}