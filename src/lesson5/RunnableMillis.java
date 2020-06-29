package lesson5;

public class RunnableMillis implements Runnable{
    float[] arr;

    public RunnableMillis(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + 5000000 / 5) * Math.cos(0.2f + 5000000 / 5) * Math.cos(0.4f + 5000000 / 2));
        }
    }
}
