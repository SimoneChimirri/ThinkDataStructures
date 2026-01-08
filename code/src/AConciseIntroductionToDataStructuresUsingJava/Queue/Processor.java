package AConciseIntroductionToDataStructuresUsingJava.Queue;

public class Processor {

    private int drops, minTime;
    private final int capacity;
    private int size = 0;
    private int performedTasks = 0;

    public Processor(int capacity) {
        this.capacity = capacity;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addTask(int taskTime){
        if (this.size + taskTime > this.capacity) {
            this.drops++;
        } else {
            this.size += taskTime;
            this.performedTasks++;
        }
    }

    public int drops(){
        return this.drops;
    }

    public int getPerformedTasks() {
        return this.performedTasks;
    }

    public boolean free(){
        return size == 0;
    }

    public void tick(){
        if (size > 0) {
            size--;
        }
    }

    public static void main(String[] args){

    }

}
