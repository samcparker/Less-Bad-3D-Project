import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main extends JFrame {

    static Canvas canvas = new Canvas();
    static KeyManager keyManager = new KeyManager();
    static boolean lockMouse;

    public Main() {
        super("3D v4");
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make cursor blank
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        getContentPane().setCursor(blankCursor);

        // Add elements to frame
        add(canvas);
        addKeyListener(keyManager);

        // Initialise and run UpdateThread
        Main.lockMouse = true;
        new UpdateThread().start();

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
