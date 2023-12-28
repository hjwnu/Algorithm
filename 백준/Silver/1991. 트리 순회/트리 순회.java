import java.util.*;
import java.io.*;
public class Main{
    static List<Node> tree = new ArrayList<>();
    static boolean[] visited;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        setTree(br);

        preOrder(0, tree.get(0));
        System.out.println();

        inOrder(0, tree.get(0));
        System.out.println();

        postOrder(0, tree.get(0));

    }

    private static void setTree(BufferedReader br) throws IOException {
        for (int i = 0; i < num; i++) {
            tree.add(new Node((char)(i+'A'),'.','.'));
        }
        StringTokenizer st;
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0)-'A';
            Node node = setSubNode(st, idx);
            tree.set(idx, node);
        }
    }


    private static Node setSubNode(StringTokenizer st, int idx) {
        Node node = tree.get(idx);
        node.setLeft(st.nextToken().charAt(0));
        node.setRight(st.nextToken().charAt(0));
        return node;
    }

    static void preOrder(int idx, Node node) {
        System.out.print(node.name);
        if(tree.get(idx).left != '.') {
            int leftIdx = tree.get(idx).left - 'A';
            preOrder(leftIdx, tree.get(leftIdx));
        }
        if(tree.get(idx).right != '.') {
            int rightIdx = tree.get(idx).right-'A';
            preOrder(rightIdx, tree.get(rightIdx));
        }
    }


    static void inOrder(int idx, Node node) {
        if(tree.get(idx).left != '.') {
            int leftIdx = tree.get(idx).left - 'A';
            inOrder(leftIdx, tree.get(leftIdx));
        }
        System.out.print(node.name);
        if(tree.get(idx).right != '.') {
            int rightIdx = tree.get(idx).right-'A';
            inOrder(rightIdx, tree.get(rightIdx));
        }
    }

    static void postOrder(int idx, Node node) {
        if(tree.get(idx).left != '.') {
            int leftIdx = tree.get(idx).left - 'A';
            postOrder(leftIdx, tree.get(leftIdx));
        }
        if(tree.get(idx).right != '.') {
            int rightIdx = tree.get(idx).right-'A';
            postOrder(rightIdx, tree.get(rightIdx));
        }
        System.out.print(node.name);
    }

    public static class Node {
        char name;
        char left;
        char right;

        public void setLeft(char left) {
            this.left = left;
        }

        public void setRight(char right) {
            this.right = right;
        }

        public Node(char name, char left, char right){
            this.name = name;
            this.left = left;
            this.right = right;
        }
    }

}
