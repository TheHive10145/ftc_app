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
        robot.shootMotor_1.setPower(10.0);
        robot.shootMotor_2.setPower(-10.0);
    }

    public void stop() {
        robot.shootMotor_1.setPower(0.0);
        robot.shootMotor_2.setPower(0.0);
    }

    public void shoot() {
        robot.shooterServo.setPosition(30);
    }

    public void bundledShoot() {
        go();
        shoot();
        stop();
    }

}
