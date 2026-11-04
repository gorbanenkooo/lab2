public class Polyline {
    Point[] points;

    public Polyline(Point... points) {
        this.points = points;
    }

    public void addPoints(Point... newPoints) {
        Point[] arr = new Point[points.length + newPoints.length];
        System.arraycopy(points, 0, arr, 0, points.length);
        System.arraycopy(newPoints, 0, arr, points.length, newPoints.length);
        this.points = arr;
    }

    public double getLength() {
        double len = 0;
        for (int i = 0; i < points.length - 1; i++) {
            len += Math.sqrt(Math.pow(points[i + 1].x - points[i].x, 2) + 
                             Math.pow(points[i + 1].y - points[i].y, 2));
        }
        return len;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i].toString());
            if (i < points.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}