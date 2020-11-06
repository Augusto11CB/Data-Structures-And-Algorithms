package aug.bueno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        int numberOfTestCases = Integer.parseInt(s.readLine());

        for (int i = 1; i <= numberOfTestCases; i++) {

            int numberOfNodesPerTree = Integer.parseInt(s.readLine());

            List<Integer> list = Stream.of(s.readLine().split(" "))
                    .map(Integer::valueOf).collect(Collectors.toList());

            BinarySearchTree tree = buildTreeFromArray(list);

            StringBuilder builder = new StringBuilder();

            tree.buildPreOrderTree(tree.root, builder);
            final String pre = builder.deleteCharAt(builder.length() - 1).toString();

            builder.setLength(0);

            tree.buildInOrderTree(tree.root, builder);
            final String in = builder.deleteCharAt(builder.length() - 1).toString();

            builder.setLength(0);

            tree.buildPosOrderTree(tree.root, builder);
            final String pos = builder.deleteCharAt(builder.length() - 1).toString();


            System.out.println("Case " + i + ":");
            System.out.println("Pre.: " + pre);
            System.out.println("In..: " + in);
            System.out.println("Post: " + pos);
            System.out.println();

        }
    }

    /*public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("resources/input-file.txt"));

        int numberOfTestCases = Integer.parseInt(s.nextLine());

        for (int i = 1; i <= numberOfTestCases; i++) {

            int numberOfNodesPerTree = Integer.parseInt(s.nextLine());

            List<Integer> list = Stream.of(s.nextLine().split(" "))
                    .map(Integer::valueOf).collect(Collectors.toList());

            BinarySearchTree tree = buildTreeFromArray(list);

            StringBuilder builder = new StringBuilder();

            tree.buildPreOrderTree(tree.root, builder);
            final String pre = builder.deleteCharAt(builder.length() - 1).toString();

            builder.setLength(0);

            tree.buildInOrderTree(tree.root, builder);
            final String in = builder.deleteCharAt(builder.length() - 1).toString();

            builder.setLength(0);

            tree.buildPosOrderTree(tree.root, builder);
            final String pos = builder.deleteCharAt(builder.length() - 1).toString();


            System.out.println("Case " + i + ":");
            System.out.println("Pre.: " + pre);
            System.out.println("In..: " + in);
            System.out.println("Post: " + pos);
            System.out.println();

        }
    }*/


    public static BinarySearchTree buildTreeFromArray(List<Integer> list) {

        BinarySearchTree tree = new BinarySearchTree(null);
        list.forEach(tree::insert);

        return tree;
    }


    static class Node {
        Node leftNode;
        Node rightNode;
        int value;

        public Node(int value) {
            this.value = value;
            leftNode = null;
            rightNode = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        public BinarySearchTree(Node root) {
            this.root = root;
        }

        public void insert(int newValue) {

            Node newNode = new Node(newValue);
            Node parent = null;

            if (root == null) {

                this.root = newNode;

            } else {

                Node currentyNode = this.root;

                while (currentyNode != null) {

                    parent = currentyNode;

                    if (newNode.value > currentyNode.value) currentyNode = currentyNode.rightNode;
                    else currentyNode = currentyNode.leftNode;
                }

                if (newNode.value < parent.value) {

                    parent.leftNode = newNode;

                } else {

                    parent.rightNode = newNode;

                }
            }
        }

        public void buildInOrderTree(Node node, StringBuilder answer) {

            if (node != null) {
                if (node.leftNode != null) buildInOrderTree(node.leftNode, answer);

                answer.append(node.value).append(" ");

                if (node.rightNode != null) buildInOrderTree(node.rightNode, answer);
            }

        }

        public void buildPreOrderTree(Node node, StringBuilder answer) {

            if (node != null) {
                answer.append(node.value).append(" ");

                if (node.leftNode != null) buildPreOrderTree(node.leftNode, answer);

                if (node.rightNode != null) buildPreOrderTree(node.rightNode, answer);
            }
        }

        public void buildPosOrderTree(Node node, StringBuilder answer) {
            if (node != null) {

                if (node.leftNode != null) buildPosOrderTree(node.leftNode, answer);

                if (node.rightNode != null) buildPosOrderTree(node.rightNode, answer);

                answer.append(node.value).append(" ");
            }
        }
    }
}
