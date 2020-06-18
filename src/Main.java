public class Main {
    public static void main(String[] args) {

        String[][] arr;
        int sum = 0;
        int valueInt;

        try {
            arr = initArray(4, 4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    valueInt = Integer.parseInt(arr[i][j]);
                    sum += valueInt;
                } catch (RuntimeException e) {
                   System.err.println(new MyArrayDataException("В ячейке [" + i + "][" + j + "] лежат неверные данные"));
                }
            }
        System.out.println("Сумма опознанных элементов массива = " + sum);
    }

    public static String[][] initArray(int row, int col) throws MyArraySizeException {
        if (row != 4 || col != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4х4");
        }
        return new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "*", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
    }
}
/*
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

 */