package org.firstinspires.ftc.teamcode.Paths;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Assemblies.*;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;

@Autonomous(name="TestPath", group="Robot")
public final class TestPath extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(0,0,0);
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        Claw claw = new Claw(hardwareMap, telemetry);
        trajectoryDepot paths = new trajectoryDepot(drive, claw);
        waitForStart();
        paths.horrorSquareMove(beginPose);

    }
}
