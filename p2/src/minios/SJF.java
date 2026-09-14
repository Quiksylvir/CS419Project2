package minios;

import java.util.List;

public class SJF implements  SchedulingAlgo{


    @Override
    public void addProcess(List<Process> readyQueue, Process p) {
        if (readyQueue.isEmpty()) {
            System.out.println(p.pid + " " + p.getCurrentInstruction().duration);
            readyQueue.add(p);
        } else {
            System.out.println(p.pid + " " + p.getCurrentInstruction().duration);
            for (int x = 0; x < readyQueue.size() - 1; x++) {
                if (readyQueue.get(x).getCurrentInstruction().duration > p.getCurrentInstruction().duration) {
                    readyQueue.add(x, p);
                } else {
                    readyQueue.addLast(p);
                }
            }
        }
    }

    @Override
    public Process selectNextProcess(List<Process> readyQueue) {
        if (readyQueue.isEmpty()) {
            return null;
        } else {
            return readyQueue.remove(0);
        }
    }
}
