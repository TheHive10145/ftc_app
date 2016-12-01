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
Assistant Gamer - Bar Hodge

MENTORS:

Lead - Mike Dennis
Programming and Design Mentor - Valid Polygon
Programming Mentor - Aaron Elie "The Butt"
Professional Breaker Mentor - Dan Denver






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
package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.supp.Drive;
import org.firstinspires.ftc.teamcode.supp.HardwareHiveBot;
import org.firstinspires.ftc.teamcode.supp.ServoMap;
import org.firstinspires.ftc.teamcode.supp.ShootMotors;

/**
 * This OpMode uses the common Pushbot hardware class to defined the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively. * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.

 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Cap Ball Autonomous", group="Pushbot")
//@Disabled // Remove if you want to disable this for some obscure reason
public class HiveBotAutonomousShooter extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareHiveBot robot           = new HardwareHiveBot();   // Use a Pushbot's hardware
                                                               // could also use HardwarePushbotMatrix class.
    double          clawOffset      = 0;                       // Servo mid position
    final double    CLAW_SPEED      = 0.02 ;                    // sets rate to move servo

    @Override
    public void runOpMode() throws InterruptedException {

        ElapsedTime timer = new ElapsedTime(0);
        Drive DRIVE = new Drive();
        ShootMotors shooter = new ShootMotors();
        Servo trigger = robot.shooterServo;
        ServoMap Serv = new ServoMap();
        boolean bandf = false;
        int shooterDir = 1; // Either 1 or -1
        boolean f = true; // First cycle

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Yo, driver! Wazzup, man??? \nI know you be wantin' to drive this robo-bot all around this didgeridoo,\n but first you gotta press that there INIT button!");    // Yo
        telemetry.update();

        waitForStart();
        // Wait for the game to start (driver presses PLAY)

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            ShootMotors shooters = new ShootMotors();

            shooters.bundledShoot();

            telemetry.addData("Say", "Right Val: " + robot.rightMotor.getCurrentPosition());
            telemetry.addData("Say", "Left Val: " + robot.leftMotor.getCurrentPosition());
            telemetry.addData("Say", "I am a sentient being.");
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            /*robot.waitForTick(40);
            */

        }}}

