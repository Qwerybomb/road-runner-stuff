package org.firstinspires.ftc.teamcode.Assemblies;
import com.acmerobotics.roadrunner.*;
import com.acmerobotics.roadrunner.ftc.Actions;

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
                .afterTime(0,arm.CRAction(1))
                .lineToY(96)
                .waitSeconds(1)
                .afterTime(0,arm.CRAction(0))
                .turnTo(0)
//                .afterTime(0,arm.CRAction(-1, 1.5))
//                .lineToX(96)
//                .turnTo(Math.PI / -2)
//                .afterTime(0,arm.CRAction(1, 1.5))
//                .lineToY(0)
//                .turnTo(Math.PI)
//                .afterTime(0,arm.CRAction(-1, 1.5))
//                .lineToX(0)
                .build());
    }
    public void squareMove(Pose2d pose) {
        Actions.runBlocking(
        drive.actionBuilder(pose)
                .turnTo(Math.PI / 2)
//              .stopAndAdd(arm.armMove(1))
                .lineToY(96)
                .turnTo(0)
                .build());
    }
}
