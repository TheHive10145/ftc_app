package org.firstinspires.ftc.teamcode.supp;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by anthonyd21 and gusg21 on 10/27/16.
 */

public class ServoMap {

    public void rotation(int angle, Servo servo) {

        servo.setPosition(angle * 0.005555555556);

    }

    public double getPos(Servo servo) {

        return servo.getPosition();

    }

}
