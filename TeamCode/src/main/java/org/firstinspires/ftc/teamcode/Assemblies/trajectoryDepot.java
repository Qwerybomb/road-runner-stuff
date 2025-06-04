package org.firstinspires.ftc.teamcode.Assemblies;
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.*;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ParallelAction;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import java.lang.Math;

public class trajectoryDepot {
    MecanumDrive drive;
    ContinuousRotationMechanism arm;
    public trajectoryDepot(MecanumDrive inputDrive, ContinuousRotationMechanism inputArm) {
        drive = inputDrive;
        arm = inputArm;
    }

    public void horrorSquareMove(Pose2d pose) {
        Actions.runBlocking(
        drive.actionBuilder(pose)
                .turnTo(Math.PI / 2)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(1))
                .lineToY(96)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(0))
                .turnTo(0)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(-1))
                .lineToX(96)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(0))
                .turnTo(Math.PI / -2)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(1))
                .lineToY(0)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(0))
                .turnTo(Math.PI)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(-1))
                .lineToX(0)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(0))
                .build());
    }
    public void squareMove(Pose2d pose) {
        Actions.runBlocking(
        drive.actionBuilder(pose)
                .waitSeconds(2)
                .afterTime(0.25, arm.CRAction(1))
                .waitSeconds(2)
                .build());
    }
}
