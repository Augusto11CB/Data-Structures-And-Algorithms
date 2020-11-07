package aug.bueno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = s.readLine()) != null & !line.equals("-1")) {

            List<Pair> tasks = new ArrayList<>();
            int numberOfTasks = Integer.parseInt(line);

            for (int i = 1; i <= numberOfTasks; i++) {
                String[] lineOfTask = s.readLine().split(" ");
                tasks.add(new Pair(Integer.parseInt(lineOfTask[0]), Integer.parseInt(lineOfTask[1])));
            }

            result.append(getShortestTimeLastTask(tasks)).append("\n");
//            System.out.println(result.toString());
        }
        s.close();
        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }

    public static int getShortestTimeLastTask(List<Pair> tasks) {
        tasks.sort(Comparator.comparing(Pair::getStartTime));

        int time = 1;

        for (Pair task : tasks) {
            if (task.startTime > time) {
                // Espera a task chegar == (task.startTime - time)
                // Depois que ela chegou executa == (task.duration)
                time = time + (task.startTime - time) + task.duration;
            } else {
                // Executa task Imediatamente
                time = time + task.duration;
            }
        }
        return time;
    }

    static class Pair {
        int startTime;
        int duration;

        public Pair(int startTime, int duration) {
            this.startTime = startTime;
            this.duration = duration;
        }

        public int getStartTime() {
            return startTime;
        }
    }
}
