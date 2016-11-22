package org.firstinspires.ftc.teamcode.supp;

/**
 * Created by gusg21 on 11/17/16.
 */

public class Drive {

    HardwareHiveBot warez = new HardwareHiveBot();

    public void controlLeft(double power) {

        warez.leftMotor.setPower(-power);

    }

    public void controlRight(double power) {

        warez.rightMotor.setPower(-power);

    }

}
