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


        int numberOfTests = Integer.parseInt(s.readLine());

        for (int i = 1; i <= numberOfTests; i++) {
            getBestPresents();
        }

    }

    private static void getBestPresents() throws IOException {

        String[] lineTwo = s.readLine().split(" ");

        int noelGift = Integer.parseInt(lineTwo[0]);
        int brunoGift = Integer.parseInt(lineTwo[1]);

        List<Gift> listOfGifts = new ArrayList<>();

        for (int i = 0; i < noelGift; i++) {
            String[] lineTree = s.readLine().split(" ");
            listOfGifts.add(new Gift(lineTree));
        }

        listOfGifts.sort(Comparator.comparing(Gift::getVolume).reversed().thenComparing(Gift::getId));

        List<Gift> newArray = new ArrayList<>(listOfGifts.subList(0, brunoGift));
        newArray.sort(Comparator.comparing(Gift::getId));

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < brunoGift; i++) {
            result.append(newArray.get(i).getId()).append(" ");
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }

    public static class Gift {
        int volume;
        int id;
        int length;
        int width;
        int height;

        public Gift(String[] parameters) {
            this.id = Integer.parseInt(parameters[0]);
            this.length = Integer.parseInt(parameters[1]);
            this.width = Integer.parseInt(parameters[2]);
            this.height = Integer.parseInt(parameters[3]);
            this.volume = length * width * height;
        }

        public int getId() {
            return id;
        }

        public int getVolume() {
            return volume;
        }
    }
}
