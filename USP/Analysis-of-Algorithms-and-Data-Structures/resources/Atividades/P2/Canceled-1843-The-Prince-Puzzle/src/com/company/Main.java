package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

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
}
