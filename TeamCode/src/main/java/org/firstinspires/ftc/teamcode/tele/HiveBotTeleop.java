/*

PROGRAMMING TEAM:

Lead - Gus Gopher Lol
Programmer - Anthony Denver RAFFLED

BUILD TEAM:

Builder - Luc Krishna's
Builder - Nathan Vices
Builder - Cabin Choir
Builder - Logan Sober
Builder - Nicholas Miller

DESIGN TEAM:

Designer - Elijah Polygon
Assistant Designer - Luc Krishna's

GAMING TEAM:

Lead Gamer - Charley Davis
Unsuccessfully Trying - Bar Hodge

MENTORS:

Lead - Mike Dennis
Git and Design Mentor - Valid Polygon
Programming Mentor - Aaron Elie "The Butt"
Professional Breaker Mentor - Dan Denver
Third Wheel - Griffin Sober






Copyright (c) 2016 Robert Atkinson, The Hive Programming Team

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
    HardwareHiveBot robot = new HardwareHiveBot();   // Use a Pushbot's hardware
    Drive DRIVE = new Drive();
    // could also use HardwarePushbotMatrix class.
    double clawOffset = 0;                       // Servo mid position
    final double CLAW_SPEED = 0.02;                   // sets rate to move servo
    ShootMotors shooters = new ShootMotors(robot);

    @Override
    public void runOpMode() throws InterruptedException {
        double leftP;
        double rightP;
        double max;
        int spd_factor;
        int inta;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        telemetry.addData("say", "Init() Succeeded");
        // Send telemetry message to signify robot waiting;
        //telemetry.addData("Say", "Yo, driver! Wazzup, man??? \nI know you be wantin' to drive this robo-bot all around this didgeridoo,\n but first you gotta press that there INIT button!");    // Yo
        //telemetry.addData("Say", "Don't crash me I'm cooler than you and I'll sell you on eBay!");
        telemetry.addData("say", "Update() Succeeded");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("say", "Op is active");
            telemetry.update();
            //Get Y's
            leftP = gamepad1.left_stick_y / 2.0; //Amount of Left Drive
            rightP = gamepad1.right_stick_y / 2.0; //Amount of Right Drive
            telemetry.addData("Say", "Go" +
                    "gamepads read");
            telemetry.update();
            // Normalize the values so neither exceed +/- 1.0
            max = Math.max(Math.abs(leftP), Math.abs(rightP));
            if (max > 1.0) {
                leftP /= max;
                rightP /= max;
            }

            //Speed Up
            if (gamepad1.right_bumper) {
                inta = 1;
            } else {
                inta = 0;
            }

            DRIVE.controlLeft((double) gamepad1.left_stick_y, robot);
            DRIVE.controlRight((double) gamepad1.right_stick_y, robot);

            if (gamepad1.y) {
                shooters.bundledShoot();
            }

            telemetry.addData("Say", "Right Val: " + robot.rightMotor.getCurrentPosition());
            telemetry.addData("Say", "Left Val: " + robot.leftMotor.getCurrentPosition());
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            /*robot.waitForTick(40);
            */

        }
    }
}

