/*
PROGRAMMING TEAM:

Lead - Gus Gopher Lol
Programmer - Anthony Denver RAFFLED

BUILD TEAM:

Builder - Luc Krishna's moo
Builder - Logan Sober
Builder - Nicholas Miller

DESIGN TEAM:

Designer - Elijah Polygon
Assistant Designer - Luc Krishna's

MENTORS:

Lead - Mike Dennis
Git and Design Mentor - Valid Polygon
The Favorite Child That is very much liked way more than the evile Logan - Griffin Sober
(Programming Mentor - Aaron Elie "The Butt")
Professional Breaker Mentor - Dan Denver
*/

package org.firstinspires.ftc.teamcode.tele;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.supp.Drive;
import org.firstinspires.ftc.teamcode.supp.HardwareHiveBot;
import org.firstinspires.ftc.teamcode.supp.ShootMotors;

@TeleOp(name = "Mariposa Laser Tag Arena", group = "Pushbot")
//@Disabled
public class HiveBotTeleop extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareHiveBot robot = new HardwareHiveBot();
    Drive DRIVE = new Drive(robot);
    ShootMotors shooters = new ShootMotors(robot);

    @Override
    public void runOpMode() throws InterruptedException {

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        telemetry.addData("say", "Init() Succeeded");
        telemetry.addData("say", "Update() Succeeded");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("say", "Op is active");
            telemetry.update();

            telemetry.addData("Say", "Go " +
                    "gamepads read");
            telemetry.update();

            DRIVE.controlLeft((double) gamepad1.left_stick_y);
            DRIVE.controlRight((double) gamepad1.right_stick_y);

            if (gamepad1.y) {
                shooters.bundledShoot();
            }

            telemetry.addData("Say", "Right Val: " + robot.rightMotor.getCurrentPosition());
            telemetry.addData("Say", "Left Val: " + robot.leftMotor.getCurrentPosition());
            telemetry.update();

        }
    }
}

