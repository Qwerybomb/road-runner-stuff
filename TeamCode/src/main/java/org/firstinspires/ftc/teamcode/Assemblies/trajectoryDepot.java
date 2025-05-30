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
                .lineToY(12)
                .waitSeconds(1)
                .afterTime(0.25,arm.CRAction(0))
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
    public void stupidTest(Pose2d pose) {
        Action driveAction = drive.actionBuilder(pose)
                .lineToX(36)
                // Start servo spin at t=0
                .afterTime(0, arm.CRAction(1.0))
                // Stop servo spin at t=3 seconds
                .afterTime(3, arm.CRAction(0.0))
                .build();
        TelemetryPacket telem = null;
      while(driveAction.run(telem)) {
          // please god work
        }
    }
}
