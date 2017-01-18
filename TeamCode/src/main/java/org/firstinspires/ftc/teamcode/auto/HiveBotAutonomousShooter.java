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

import org.firstinspires.ftc.teamcode.supp.HardwareHiveBot;
import org.firstinspires.ftc.teamcode.supp.ShootMotors;

/**
 * This OpMode uses the common Pushbot hardware class to defined the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 * <p>
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively. * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * <p>
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 * <p>
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name = "Shooter Autonomous", group = "Pushbot")
//@Disabled // Remove if you want to disable this for some obscure reason
public class HiveBotAutonomousShooter extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareHiveBot robot = new HardwareHiveBot();   // Use a Pushbot's hardware

    @Override
    public void runOpMode() throws InterruptedException {

        ShootMotors shooter = new ShootMotors(robot);

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Yo, driver! Wazzup, man??? \nI know you be wantin' to drive this robo-bot all around this didgeridoo,\n but first you gotta press that there INIT button!");    // Yo
        telemetry.update();

        waitForStart();
        // Wait for the game to start (driver presses PLAY)

        robot.shootMotor_1.setPower(1.0);
        robot.shootMotor_2.setPower(1.0);

        robot.shooterServo.setPosition(5);
        telemetry.addData("Status", "Setting Position");

        robot.shooterServo.setPosition(0);
        telemetry.addData("Status", "Returning");

        robot.shootMotor_1.setPower(0.0);
        robot.shootMotor_2.setPower(0.0);

        while (opModeIsActive()) {

            // Null the void

        }

    }
}

