package important.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by liyajin on 16/8/9.
 */
public class Traverse {

    public void preTraverse(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public void preTraverse1(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                System.out.print(root.val + " ");
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop().right;
            }
        }
    }

    public void inTraverse(TreeNode root){
        if(root == null) return;
        inTraverse(root.left);
        System.out.print(root.val + " ");
        inTraverse(root.right);
    }

    public void inTraverse1(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public void postTraverse(TreeNode root){
        if(root == null) return;
        postTraverse(root.left);
        postTraverse(root.right);
        System.out.print(root.val + " ");
    }

    public void postTraverse1(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                temp.push(root);
                root = root.right;
            }
            if(!stack.isEmpty()){
                root = stack.pop().left;
            }
        }

        while(!temp.isEmpty()){
            System.out.print(temp.pop().val + " ");
        }
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (leftHeight > rightHeight) ? leftHeight + 1: rightHeight + 1;
    }

    public void levelTraverse(TreeNode root){
        if(root == null) return;
        int num = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            while(num-- > 0){
                root = queue.poll();
                System.out.print(root.val + " ");
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
            }
            num = queue.size();
            System.out.println();
        }
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node5.right = node7;

        Traverse traverse = new Traverse();
        System.out.println("前序遍历(递归实现):");
        traverse.preTraverse(node1);
        System.out.println();

        System.out.println("前序遍历(循环实现):");
        traverse.preTraverse1(node1);
        System.out.println();

        System.out.println("中序遍历(递归实现):");
        traverse.inTraverse(node1);
        System.out.println();

        System.out.println("中序遍历(循环实现):");
        traverse.inTraverse1(node1);
        System.out.println();

        System.out.println("后序遍历(递归实现):");
        traverse.postTraverse(node1);
        System.out.println();

        System.out.println("后序遍历(循环实现):");
        traverse.postTraverse1(node1);
        System.out.println();


        System.out.println("树高");
        System.out.println(traverse.height(node1));

        System.out.println("层次遍历(循环实现):");
        traverse.levelTraverse(node1);
        System.out.println();

    }
}
