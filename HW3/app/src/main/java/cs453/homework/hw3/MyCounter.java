package cs453.homework.hw3;

public class MyCounter {
    private int currentCount;

    public MyCounter(){
        currentCount = 0;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public void plusOneCount(){
        currentCount += 1;
    }

    public void plusFiveCount(){
        currentCount += 5;
    }

    public void resetCount(){
        currentCount = 0;
    }
}
