package org.firstinspires.ftc.teamcode.Assemblies;
import com.acmerobotics.roadrunner.*;
import com.acmerobotics.roadrunner.ParallelAction;
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
                .stopAndAdd(arm.posistionUpdateAction(1, 1.5))
                .lineToY(96)
                .turnTo(0)
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
