import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static Node buildTree(int[] arr) {
        if (arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (i < arr.length) {
            Node curr = q.poll();

            if (i < arr.length) {
                curr.left = new Node(arr[i++]);
                q.offer(curr.left);
            }

            if (i < arr.length) {
                curr.right = new Node(arr[i++]);
                q.offer(curr.right);
            }
        }

        return root;
    }

    static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node root = buildTree(arr);

        System.out.print("Preorder: ");
        preOrder(root);

        System.out.print("\nInorder: ");
        inOrder(root);

        System.out.print("\nPostorder: ");
        postOrder(root);

        System.out.print("\nLevel Order: ");
        levelOrder(root);
    }
}
