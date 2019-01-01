package simulation;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueueSimulator {

  private Random random = new Random();

  private Processor processor;

  public static void main(String[] args) {
    QueueSimulator simulator = new QueueSimulator();

    Set<Integer> queueSizes =
        Stream.of(500, 250, 100, 50, 5).collect(Collectors.toCollection(LinkedHashSet::new));

    for (Integer queueSize : queueSizes) {
      simulator.run(queueSize, 10000, 10, 0.3);
    }
  }

  public void run(int queueLength, int minTime, int maxTaskTime, double taskChance) {
    int t = 0;

    int tasks = 0;

    System.out.format("Running simulation with the following parameters:%n%n");
    System.out.format("queueLength: %d%n", queueLength);
    System.out.format("minTime: %d%n", minTime);
    System.out.format("maxTaskTime: %d%n", maxTaskTime);
    System.out.format("taskChance: %f%n", taskChance);

    processor = new Processor(queueLength);

    while (t < minTime || !processor.free()) {
      if (t < minTime) {
        tasks += 1;
        generateNewTask(maxTaskTime, taskChance);
      }

      processor.tick();
      t += 1;
    }

    int drops = processor.drops();
    float percentDropped = (float) drops / tasks;
    int extraTime = t - minTime;

    System.out.format("Tasks processed: %d%n", tasks);
    System.out.format("Drops: %d%n", drops);
    System.out.format("Percent dropped: %f%n", percentDropped);
    System.out.format("Extra time required: %d%n", extraTime);
  }

  private void generateNewTask(int maxTaskTime, double taskChance) {
    double r = random.nextDouble();

    if (r < taskChance) {
      int taskTime = 1 + random.nextInt(maxTaskTime);

      processor.addTask(taskTime);
    }
  }
}
