public class Block {

    double x, y, z;
    Vertex a, b, c, d, e, f, g, h;

    public Block(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        a = new Vertex(x, y, z);
        b = new Vertex(x + 1, y, z);
        c = new Vertex(x, y, z + 1);
        d = new Vertex(x + 1, y, z + 1);
        e = new Vertex(x, y + 1, z);
        f = new Vertex(x + 1, y + 1, z);
        g = new Vertex(x, y + 1, z + 1);
        h = new Vertex(x + 1, y + 1, z + 1);
    }


}
