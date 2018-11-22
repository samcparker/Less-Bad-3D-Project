public class Vertex {

    double x, y, z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Calculate the distance from this Vertex to another Vertex
     */
    public double calculateDistance(Vertex from) {
        double dx = from.getX() - getX();
        double dy = from.getY() - getY();
        double dz = from.getZ() - getZ();

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double calculateDepth(Camera camera) {
        double cx = camera.getX();
        double cy = camera.getY();
        double cz = camera.getZ();

        double cos_yaw = Math.cos(camera.getYaw());
        double cos_pitch = Math.cos(camera.getPitch());
        double sin_yaw = Math.sin(camera.getYaw());
        double sin_pitch = Math.sin(camera.getPitch());

        double z = (cz - getZ()) * cos_yaw + (cx - getX()) * sin_yaw;
        z = z * cos_pitch + (cy - getY()) * sin_pitch;
        return z;
    }

    public int[] getScreenLocation(Camera camera) {
        double cx = camera.getX();
        double cy = camera.getY();
        double cz = camera.getZ();

        double cos_yaw = Math.cos(camera.getYaw());
        double cos_pitch = Math.cos(camera.getPitch());
        double sin_yaw = Math.sin(camera.getYaw());
        double sin_pitch = Math.sin(camera.getPitch());

        double x = (cx - getX()) * cos_yaw - (cz - getZ()) * sin_yaw;
        double z = (cz - getZ()) * cos_yaw + (cx - getX()) * sin_yaw;
        double y = (cy - getY()) * cos_pitch - z * sin_pitch;
        z = z * cos_pitch + (cy - getY()) * sin_pitch;
        z = Math.abs(z);

        int width = (int) Main.canvas.getScreenSize().getWidth();
        int height = (int) Main.canvas.getScreenSize().getHeight();

        double f = width / (2 * z);
        int rx = (int) (x * f) + (width / 2);
        int ry = (int) (y * f) + (height / 2);

        return new int[]{rx, ry};
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
