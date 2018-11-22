public class Camera {

    Vertex location;
    double yaw;
    double pitch;
    double sensitivity;
    double speed;

    public Camera(Vertex location, double yaw, double pitch, double sensitivity, double speed) {
        this.location = location;
        this.yaw = yaw;
        this.pitch = pitch;
        this.sensitivity = sensitivity;
        this.speed = speed;
    }

    public void rotateBy(double dx, double dy) {
        setYaw(getYaw() + dx * sensitivity);
        setPitch(getPitch() + dy * sensitivity);

    }

    public void moveForward() {
        location.setZ(location.getZ() - Math.cos(yaw) * speed);
        location.setX(location.getX() - Math.sin(yaw) * speed);
    }

    public void moveBackward() {
        location.setZ(location.getZ() + Math.cos(yaw) * speed);
        location.setX(location.getX() + Math.sin(yaw) * speed);
    }

    public void moveLeft() {
        location.setZ(location.getZ() - Math.sin(yaw) * speed);
        location.setX(location.getX() + Math.cos(yaw) * speed);
    }

    public void moveRight() {
        location.setZ(location.getZ() + Math.sin(yaw) * speed);
        location.setX(location.getX() - Math.cos(yaw) * speed);
    }

    public void moveUp() {
        location.setY(getY() + speed);
    }

    public void moveDown() {
        location.setY(getY() - speed);
    }

    // TODO : Create move and turn functions (forwards, backwards, left, right, turn horizontal, turn vertical)

    public Vertex getLocation() {
        return location;
    }

    public void setLocation(Vertex location) {
        this.location = location;
    }

    public double getX() {
        return location.getX();
    }

    public void setX(double x) {
        location.setX(x);
    }

    public double getY() {
        return location.getY();
    }

    public void setY(double y) {
        location.setY(y);
    }

    public double getZ() {
        return location.getZ();
    }

    public void setZ(double z) {
        location.setZ(z);
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        if (pitch < Math.toRadians(-90)) pitch = Math.toRadians(-90);
        else if (pitch > Math.toRadians(90)) pitch = Math.toRadians(90);
        else this.pitch = pitch;
    }

    public double getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(double sensitivity) {
        this.sensitivity = sensitivity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
