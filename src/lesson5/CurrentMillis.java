package lesson5;

public class CurrentMillis {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        CurrentMillis currentMillis = new CurrentMillis();
        currentMillis.longMillis();
        currentMillis.shortMillis();
    }

    public void longMillis() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.printf("Время работы первого метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
        System.out.println("arr[5000000] - " + arr[5000000]);
    }

    public void shortMillis() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new RunnableMillis(a1));
        Thread t2 = new Thread(new RunnableMillis(a2));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.printf("Время работы второго метода = %d",(System.currentTimeMillis() - a));
        System.out.println();
        System.out.println("arr[5000000] - " + arr[5000000]);
    }

}
