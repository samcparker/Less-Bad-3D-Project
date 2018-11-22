import java.awt.*;

public class UpdateThread extends Thread {

    Robot robot;

    public void run() {
        while(true) {

            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }

            // Move the camera using keyboard controls
            if (Main.keyManager.VK_W) {
                Main.canvas.getCamera().moveForward();
            }

            if (Main.keyManager.VK_S) {
                Main.canvas.getCamera().moveBackward();
            }

            if (Main.keyManager.VK_A) {
                Main.canvas.getCamera().moveLeft();
            }

            if (Main.keyManager.VK_D) {
                Main.canvas.getCamera().moveRight();
            }

            if (Main.keyManager.VK_SHIFT) {
                Main.canvas.getCamera().moveDown();
            }

            if (Main.keyManager.VK_SPACE) {
                Main.canvas.getCamera().moveUp();
            }

            if (Main.lockMouse) {
                // Rotate the camera by dx or dy.
                // Calculates the current location minus the centre
                int dx = (int) (MouseInfo.getPointerInfo().getLocation().x - Main.canvas.screenSize.getWidth() / 2);
                int dy = (int) (MouseInfo.getPointerInfo().getLocation().y - Main.canvas.screenSize.getHeight() / 2);

                Main.canvas.getCamera().rotateBy(dx, dy);

                // Reset the mouse location back to the centre of the screen
                robot.mouseMove((int) Main.canvas.screenSize.getWidth() / 2, (int) Main.canvas.screenSize.getHeight() / 2);
            }



            Main.canvas.repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
