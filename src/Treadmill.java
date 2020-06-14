public class Treadmill extends Obstacle{
    private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }
    @Override
    public void doIt(Competitor c) {
      c.run(dist);
    }
}
