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

    static void postOrder(Node cur) {
        if (cur== null) return;
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.println(cur.num);
    }


    static class Node {
        int num;
        Node left;
        Node right;
        
        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
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


