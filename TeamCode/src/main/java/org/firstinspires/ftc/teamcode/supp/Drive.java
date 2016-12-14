package org.firstinspires.ftc.teamcode.supp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by gusg21 on 11/17/16.
 */

public class Drive {

    public void controlLeft(double power, HardwareHiveBot warez) {

        warez.leftMotor.setPower(power);

    }

    public void controlRight(double power, HardwareHiveBot warez) {

        warez.rightMotor.setPower(power);

    }

}
