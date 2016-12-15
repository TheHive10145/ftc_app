package org.firstinspires.ftc.teamcode.supp;

import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by gusg21 on 11/22/16.
 */

public class ShootMotors {

    HardwareHiveBot robot = new HardwareHiveBot();
    ServoMap Serv = new ServoMap();
    ElapsedTime timer = new ElapsedTime();

    public ShootMotors(HardwareHiveBot robot) {
        this.robot = robot;
    }

    public void go() {
        robot.shootMotor_1.setPower(0.9);
        robot.shootMotor_2.setPower(0.9);
    }

    public void stop() {
        robot.shootMotor_1.setPower(0.0);
        robot.shootMotor_2.setPower(0.0);
    }

    public void shoot() {
        /* Assumes in off direction */
        Serv.rotation(30, robot.shooterServo);
        while (timer.milliseconds() < 500) {
            // Nothing, a delay ...
            // Maybe ...
        }
        Serv.rotation(0, robot.shooterServo);
    }

    public void bundledShoot() {
        go();
        while (timer.milliseconds() < 500) {
            // Delay for .5 sec
        }
        shoot();
        stop();
    }

}
