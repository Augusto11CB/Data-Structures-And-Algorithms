package aug.bueno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTests = Integer.parseInt(s.readLine());

        for (int i = 1; i <= numberOfTests; i++) {

            int numberOfPackeges = Integer.parseInt(s.readLine());
            int[] vectorOfOrnamentsPerPackage = new int[numberOfPackeges + 1];
            int[] vectorOfWeightPerPackage = new int[numberOfPackeges + 1];

            int weightSupportedByBranch = Integer.parseInt(s.readLine());
            int[] dynamicVector = new int[weightSupportedByBranch + 1];
            int[][] packageXWeight = new int[numberOfPackeges + 1][weightSupportedByBranch + 1];

            fillArray(packageXWeight);
            for (int j = 1; j <= numberOfPackeges; j++) {
                String[] lineOne = s.readLine().split(" ");
                vectorOfOrnamentsPerPackage[j] = Integer.parseInt(lineOne[0]);
                vectorOfWeightPerPackage[j] = Integer.parseInt(lineOne[1]);
            }

            int x = calculateNumberOfOrnamentsForATree(numberOfPackeges, weightSupportedByBranch, vectorOfWeightPerPackage, vectorOfOrnamentsPerPackage, packageXWeight, 1);
//            calculateNumberOfOrnamentsForATree(numberOfPackeges, weightSupportedByBranch, vectorOfWeightPerPackage, vectorOfOrnamentsPerPackage, dynamicVector);
            System.out.println("Galho " + i + ":");
            System.out.println("Numero total de enfeites: " + x);
            System.out.println();

        }

    }

    public static int calculateNumberOfOrnamentsForATree(
            int numberOfPackages,
            int maxWeightBranch,
            int[] vectorOfWeightPerPackage,
            int[] vectorOfOrnamentsPerPackage,
            int[][] packageXWeight,
            int currentItem
    ) {
        if (currentItem > numberOfPackages || maxWeightBranch == 0) {
            return 0;
        }

        if (packageXWeight[currentItem][maxWeightBranch] != -1) {
            return packageXWeight[currentItem][maxWeightBranch];
        }

        int amount = -1;

        if (vectorOfWeightPerPackage[currentItem] > maxWeightBranch) {
            amount = calculateNumberOfOrnamentsForATree(numberOfPackages, maxWeightBranch, vectorOfWeightPerPackage, vectorOfOrnamentsPerPackage, packageXWeight, currentItem + 1);

        } else {

            int skipCurrentPackage = calculateNumberOfOrnamentsForATree(numberOfPackages, maxWeightBranch, vectorOfWeightPerPackage, vectorOfOrnamentsPerPackage, packageXWeight, currentItem + 1);

            int remainWeight = (maxWeightBranch - vectorOfWeightPerPackage[currentItem]);
            int usingCurrentPackage = vectorOfOrnamentsPerPackage[currentItem] + calculateNumberOfOrnamentsForATree(numberOfPackages, remainWeight, vectorOfWeightPerPackage, vectorOfOrnamentsPerPackage, packageXWeight, currentItem + 1);

            amount = Math.max(skipCurrentPackage, usingCurrentPackage);
        }
        return packageXWeight[currentItem][maxWeightBranch] = amount;
    }

    private static void fillArray(int[][] matrix) {
        // Fill each row with -1
        for (int[] row : matrix)
            Arrays.fill(row, -1);
    }

    public static int calculateNumberOfOrnamentsForATree(
            int numberOfPackages,
            int maxWeightBranch,
            int[] vectorOfWeightPerPackage,
            int[] vectorOfOrnamentsPerPackage,
            int[] dynamicVector
    ) {
        System.out.println("numberOfPackages" + numberOfPackages);
        System.out.println("maxWeightBranch" + maxWeightBranch);

        for (int i = 1; i <= numberOfPackages; i++) {

//            for (int j = maxWeightBranch; j >= vectorOfWeightPerPackage[i]; j--) {
            for (int j = maxWeightBranch; j >= (vectorOfWeightPerPackage[i] / vectorOfOrnamentsPerPackage[i]); j--) {
//            for (int j = 1; j <= maxWeightBranch; j++) {

//                    for (int k = 1; k <= vectorOfOrnamentsPerPackage[i] && k * vectorOfWeightPerPackage[i] <= j; k++) {
                double ornamentIndividualValue = vectorOfWeightPerPackage[i] / vectorOfOrnamentsPerPackage[i];
                for (int k = 1; k <= vectorOfOrnamentsPerPackage[i] && k * ornamentIndividualValue <= j; k++) {


//                    dynamicVector[j] = Math.max(dynamicVector[j], (dynamicVector[j - (k * vectorOfWeightPerPackage[i])] + k));
                    dynamicVector[j] = Math.max(dynamicVector[j], (dynamicVector[(int) (j - (k * ornamentIndividualValue))] + k));
//                    dynamicVector[j] = dynamicVector[j] + Math.max(dynamicVector[j], (dynamicVector[j - (k * (vectorOfWeightPerPackage[i] / vectorOfOrnamentsPerPackage[i]))] + k));

                }
            }
        }
        printVector(dynamicVector);
        return 0;
    }

    public static void printVector(int[] dynamicVector) {
        for (int j : dynamicVector) {
            System.out.println(j);
        }
    }
}
