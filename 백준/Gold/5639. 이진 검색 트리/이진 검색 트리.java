import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Node> tree = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            int nodeNum = Integer.parseInt(input);
            root.insert(nodeNum);
        }
        postOrder(root);
    }

    static void postOrder(Node curr) {
        if (curr == null) return;
        postOrder(curr.left);
        postOrder(curr.right);
        System.out.println(curr.num);
    }


    static class Node {
        int num;
        Node left;
        Node right;
        Node upper;

        public Node(int num, Node left, Node right, Node upper) {
            this.num = num;
            this.left = left;
            this.right = right;
            this.upper = upper;
        }

        public Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
}


