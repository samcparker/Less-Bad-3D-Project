import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    boolean VK_W, VK_A, VK_S, VK_D, VK_SHIFT, VK_SPACE, VK_LEFT, VK_RIGHT, VK_UP, VK_DOWN;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
                VK_W = true;
                break;
            case KeyEvent.VK_A:
                VK_A = true;
                break;
            case KeyEvent.VK_S:
                VK_S = true;
                break;
            case KeyEvent.VK_D:
                VK_D = true;
                break;
            case KeyEvent.VK_UP:
                VK_UP = true;
                break;
            case KeyEvent.VK_DOWN:
                VK_DOWN = true;
                break;
            case KeyEvent.VK_LEFT:
                VK_LEFT = true;
                break;
            case KeyEvent.VK_RIGHT:
                VK_RIGHT = true;
                break;
            case KeyEvent.VK_SHIFT:
                VK_SHIFT = true;
                break;
            case KeyEvent.VK_SPACE:
                VK_SPACE = true;
                break;
            case KeyEvent.VK_C:
                Main.lockMouse = !Main.lockMouse;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
                VK_W = false;
                break;
            case KeyEvent.VK_A:
                VK_A = false;
                break;
            case KeyEvent.VK_S:
                VK_S = false;
                break;
            case KeyEvent.VK_D:
                VK_D = false;
                break;
            case KeyEvent.VK_UP:
                VK_UP = false;
                break;
            case KeyEvent.VK_DOWN:
                VK_DOWN = false;
                break;
            case KeyEvent.VK_LEFT:
                VK_LEFT = false;
                break;
            case KeyEvent.VK_RIGHT:
                VK_RIGHT = false;
                break;
            case KeyEvent.VK_SHIFT:
                VK_SHIFT = false;
                break;
            case KeyEvent.VK_SPACE:
                VK_SPACE = false;
                break;
        }
    }
}
