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
    public trajectoryDepot(MecanumDrive inputDrive) {
        drive = inputDrive;
    }

    public void horrorSquareMove(Pose2d pose) {
        Actions.runBlocking(
        drive.actionBuilder(pose)
                .turnTo(Math.PI / 2)
                .build());
    }
    public void squareMove(Pose2d pose) {
        Actions.runBlocking(
        drive.actionBuilder(pose)
                .waitSeconds(2)
                .waitSeconds(2)
                .build());
    }
}
