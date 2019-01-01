package simulation;

import queue.FixedLengthQueue;

public class Processor {
  private static final int FREE = -1;

  private int currentTaskTime = FREE;

  private FixedLengthQueue<Integer> fifo;

  public Processor(int fifoCapacity) {
    fifo = new FixedLengthQueue<>(fifoCapacity);
  }

  public void addTask(int taskTime) {
    if(currentTaskTime == FREE) {
      currentTaskTime = taskTime;
    } else {
      fifo.enqueue(taskTime);
    }
  }

  public int drops() {
    return fifo.drops();
  }

  public boolean free() {
    return currentTaskTime == FREE;
  }

  public void tick() {
    if (currentTaskTime > 0) {
      currentTaskTime -= 1;
    }

    if(currentTaskTime == 0) {
      if (!fifo.isEmpty()) {
        currentTaskTime = fifo.dequeue();
      } else {
        currentTaskTime = FREE;
      }
    }
  }
}
