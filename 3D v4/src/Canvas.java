import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Canvas extends JPanel {

    ArrayList<Polygon3D> polygons;
    Dimension screenSize;
    Camera camera;


    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

        for (Polygon3D polygon : polygons) {
            polygon.update();
        }

        polygons.sort(Comparator.comparing(Polygon3D::getDistance).reversed());

        for (Polygon3D polygon : polygons) {

            g2d.setColor(Color.green);
            polygon.fillPolygon(g2d);
            g2d.setColor(Color.black);
            polygon.drawPolygon(g2d);


        }
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public Canvas() {
        polygons = new ArrayList<>();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        camera = new Camera(new Vertex(0.0836405097669848, 0.2, -0.264863941158761), -2.07, -0.42, 0.005, 0.1);

        setPreferredSize(screenSize);

        Polygon3D a = new Polygon3D();
        a.addVertex(new Vertex(0, 0, 1));
        a.addVertex(new Vertex(0, 1, 1));
        a.addVertex(new Vertex(1, 1, 1));
        a.addVertex(new Vertex(1, 0, 1));
        polygons.add(a);

        Polygon3D b = new Polygon3D();
        b.addVertex(new Vertex(0, 0, 1));
        b.addVertex(new Vertex(1, 0, 1));
        b.addVertex(new Vertex(1, 0, 0));
        b.addVertex(new Vertex(0, 0, 0));
        polygons.add(b);


    }

    public Camera getCamera() {
        return camera;
    }
}
