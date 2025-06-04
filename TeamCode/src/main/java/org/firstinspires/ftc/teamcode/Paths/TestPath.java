package org.firstinspires.ftc.teamcode.Paths;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Assemblies.ContinuousRotationMechanism;
import org.firstinspires.ftc.teamcode.Assemblies.trajectoryDepot;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.tuning.TuningOpModes;

@Autonomous(name="TestPath", group="Robot")
public final class TestPath extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(0,0,0);
        ContinuousRotationMechanism arm = new ContinuousRotationMechanism(hardwareMap, telemetry);
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        trajectoryDepot paths = new trajectoryDepot(drive, arm);
        waitForStart();
        paths.horrorSquareMove(beginPose);

    }
}
