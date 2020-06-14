public class Main {
    public static void main(String[] args) {

    Competitor[] competitors = {
      new Human("Ivan", 3000, 2),
      new Robot("RoboSport", 10000, 5),
      new Cat("Bars", 300, 1)
    };

    Obstacle[] obstacles = {
       new Treadmill(1000),
       new Wall(3)
    };

    for (Competitor c : competitors) {
        for (Obstacle o : obstacles) {
            o.doIt(c);
            if (!c.isOnDistance()) {
                break;
            }
        }
    }

    for (Competitor competitor : competitors) {
        competitor.info();
    }

    }
}
