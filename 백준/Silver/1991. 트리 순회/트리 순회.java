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

        preOrder(tree.get(0));
        System.out.println();
        
        inOrder(tree.get(0));
        System.out.println();
        
        postOrder(tree.get(0));

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

    static void preOrder(Node node) {
        for(int i = 0; i < num; i++) {

            if(tree.get(i).name == node.name) {
                System.out.print(node.name);
                if(tree.get(i).left != '.') {
                    int leftIdx = tree.get(i).left - 'A';
                    preOrder(tree.get(leftIdx));
                }
                if(tree.get(i).right != '.') {
                    int rightIdx = tree.get(i).right-'A';
                    preOrder(tree.get(rightIdx));
                }
                break;
            }
        }
    }

    static void inOrder(Node node) {
        for(int i = 0; i < num; i++) {

            if(tree.get(i).name == node.name) {
                if(tree.get(i).left != '.') {
                    int leftIdx = tree.get(i).left - 'A';
                    inOrder(tree.get(leftIdx));
                }
                System.out.print(node.name);
                if(tree.get(i).right != '.') {
                    int rightIdx = tree.get(i).right-'A';
                    inOrder(tree.get(rightIdx));
                }
                break;
            }
        }
    }
    static void postOrder(Node node) {
        for(int i = 0; i < num; i++) {

            if(tree.get(i).name == node.name) {

                if(tree.get(i).left != '.') {
                    int leftIdx = tree.get(i).left - 'A';
                    postOrder(tree.get(leftIdx));
                }
                if(tree.get(i).right != '.') {
                    int rightIdx = tree.get(i).right-'A';
                    postOrder(tree.get(rightIdx));
                }
                System.out.print(node.name);
                break;
            }
        }
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
