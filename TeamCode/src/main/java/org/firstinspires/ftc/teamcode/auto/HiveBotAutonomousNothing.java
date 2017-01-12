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
package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.supp.Drive;
import org.firstinspires.ftc.teamcode.supp.HardwareHiveBot;

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
 * Griffin had nothing to do with this code. if it breaks, it's not his fault
 */

@Autonomous(name="Cap Ball Autonomous", group="Pushbot")
//@Disabled // Remove if you want to disable this for some obscure reason
public class HiveBotAutonomousNothing extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareHiveBot robot           = new HardwareHiveBot();

    @Override
    public void runOpMode() throws InterruptedException {

        ElapsedTime timer = new ElapsedTime(0);
        Drive DRIVE = new Drive(robot);

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Yo, driver! Wazzup, man??? \nI know you be wantin' to drive this robo-bot all around this didgeridoo,\n but first you gotta press that there INIT button!");    // Yo
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            DRIVE.controlLeft(1.0);
            DRIVE.controlRight(1.0);

            telemetry.addData("Say", "Right Val: " + robot.rightMotor.getCurrentPosition());
            telemetry.addData("Say", "Left Val: " + robot.leftMotor.getCurrentPosition());
            telemetry.addData("Say", "I am a sentient being.");
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            /*robot.waitForTick(40);
            */

        }}}

