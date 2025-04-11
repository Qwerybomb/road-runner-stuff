package org.firstinspires.ftc.teamcode.tuning;

import static com.sun.tools.doclint.HtmlTag.U;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Assemblies.ascentMechanism;
import org.firstinspires.ftc.teamcode.MecanumDrive;
@Autonomous(name="squareMove", group="Robot")
public final class squareMove extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ascentMechanism arm = null;
        arm = new ascentMechanism(hardwareMap);
        Pose2d beginPose = new Pose2d(0, 0, 0);
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

            waitForStart();
            Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .turnTo(Math.PI / 2)
                        .lineToY(96)
                        .turnTo(0)
                        .lineToX(96)
                        .turnTo(Math.PI / -2)
                        .lineToY(0)
                        .turnTo(Math.PI)
                        .lineToX(0)
                        .build());
        }
    }
}
