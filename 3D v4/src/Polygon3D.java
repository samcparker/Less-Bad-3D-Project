import java.awt.*;
import java.util.ArrayList;

public class Polygon3D {

    Polygon polygon;
    double distance;
    double depth;
    ArrayList<Vertex> vertices;

    public Polygon3D() {
        polygon = new Polygon();
        vertices = new ArrayList<>();

    }

    public void draw(Graphics2D g2d) {

        g2d.fill(polygon);
    }

    public void update() {
        this.polygon = createPolygon2D();
        this.depth = getDepth();
        this.distance = getDistance();
        // TODO : Calculate the distance from Camera to the central point of this polygon using calculateDistance()
        // TODO : Calculate the depth of this polygon from Camera using calculateDepth()
        // TODO : Calculate screen position of polygon
    }

    public Polygon createPolygon2D() {
        polygon = new Polygon();

        for (Vertex vertex : vertices) {
            int[] screenLocation = vertex.getScreenLocation(Main.canvas.getCamera());
            polygon.addPoint(screenLocation[0], screenLocation[1]);

        }
        return polygon;
    }

    public void fillPolygon(Graphics2D g2d) {
        if (getDepth() > 0) {
            g2d.fill(polygon);
        }
    }

    public void drawPolygon(Graphics2D g2d) {
        if (getDepth() >= 0) {
            g2d.draw(polygon);
        }
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public double getDepth() {
        return getMiddleVertex().calculateDepth(Main.canvas.camera);


    }

    public double getDistance() {
        return getMiddleVertex().calculateDistance(Main.canvas.getCamera().getLocation());
    }

    private Vertex getMiddleVertex() {
        double x = 0;
        double y = 0;
        double z = 0;

        for (Vertex vertex : vertices) {
            x += vertex.getX();
            y += vertex.getY();
            z += vertex.getZ();
        }

        x /= vertices.size();
        y /= vertices.size();
        z /= vertices.size();

        return new Vertex(x, y, z);
    }

}
