package AConciseIntroductionToDataStructuresUsingJava.Queue;

import java.util.Random;

public class QueueSimulator {

    public QueueSimulator() {
    }

    public static void run(int queueLength, int minTime, int maxTaskTime, double taskChance){
        Processor gpu = new Processor(queueLength);
        gpu.setMinTime(minTime);
        int countTasks = 0;
        int t = 0;
        while(t < minTime || gpu.getSize() >= queueLength){
            while(t < minTime) {
                 Random rand = new Random();
                 if (!(rand.nextDouble() > taskChance)) {
                     int taskTime = rand.nextInt(0, maxTaskTime);
                     gpu.addTask(taskTime);
                     countTasks++;
                 }
                 gpu.tick();
                 t++;
            }
        }
        while(!gpu.free()) {
             gpu.tick();
             t++;
        }
        int countPerformedTasks = gpu.getPerformedTasks();
        int drops = gpu.drops();
        double percentLost = countTasks == 0 ? 0.0 : (double) drops / (double) countTasks * 100.0;

        System.out.format("""
                        Number of tasks performed: %d;
                        Percentage of tasks lost: %.2f;
                        Extra time needed to complete the tasks: %d.
                        """,
                        countPerformedTasks, percentLost, t - minTime);

     }

     public static void main(String[] args){
         run(5,10000,10,0.3);
     }
 }
