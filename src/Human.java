public class Human implements Competitor{
    String name;

    int maxRunDistance;
    int maxJumpHeight;

    boolean onDistance;

    public Human (String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.printf("%s успешно пробежал %d метров\n", name, dist);
        }
        else {
            System.out.printf("%s не смог пробежать %d метров\n", name, dist);
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.printf("%s успешно прыгнул %d метров\n", name, height);
        }
        else {
            System.out.printf("%s не смог прыгнуть %d метров\n", name, height);
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.printf("%s %b\n", name, onDistance);
    }
}
