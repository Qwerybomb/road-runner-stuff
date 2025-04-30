package org.firstinspires.ftc.teamcode.Paths;
import com.qualcomm.robotcore.eventloop.opmode.*;
import org.firstinspires.ftc.teamcode.Assemblies.ascentMechanism;


@TeleOp(name = "Test", group = "Robot")
public class operationTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        ascentMechanism arm = new ascentMechanism(hardwareMap, telemetry);
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("intendedRotation", arm.getPosistion());
            telemetry.update();
            arm.rise(gamepad1.dpad_up, gamepad1.dpad_down);
        }
    }
}