package com.atguigu.tree;

/**
 * ************************
 *
 * @Description: 二叉树遍历（前序，中序，后序）--》取决于输父节点的位置
 * @Author: wanghaining
 * @Date: 2020/4/23 13:49
 * <p>
 * ************************
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(3, "吴用");
        HeroNode node3 = new HeroNode(6, "卢俊义");
        HeroNode node4 = new HeroNode(8, "林冲");
        HeroNode node5 = new HeroNode(10, "关胜");
        HeroNode node6 = new HeroNode(14, "xx");
        HeroNode node7 = new HeroNode(15, "qq");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node6.setLeft(node7);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println();
        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println();
        System.out.println("后序遍历");
        binaryTree.postOrder();

        int no = 51;
        System.out.println("----------------");
        System.out.println(binaryTree.preOrderSearch(no));
        System.out.println("----------------");
        System.out.println();
        System.out.println(binaryTree.infixOrderSearch(no));
        System.out.println("----------------");
        System.out.println();
        System.out.println(binaryTree.postOrderSearch(no));


    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }
}

class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    /**
     * 前序
     */
    public void preOrder() {
        System.out.print(this + "\t");

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.print(this + "\t");

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.print(this + "\t");
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序查找
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序查找~~" + this.id);
        if (this.id == no) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        if (heroNode != null) {
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    /**
     * 中序查找
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.infixOrderSearch(no);
        }

        if (heroNode != null) {
            return heroNode;
        }

        System.out.println("中序查找~~" + this.id);
        if (this.id == no) {
            return this;
        }

        if (this.right != null) {
            heroNode = this.right.infixOrderSearch(no);
        }
        return heroNode;
    }

    /**
     * 后序查找
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postOrderSearch(no);
        }

        if (heroNode != null) {
            return heroNode;
        }

        if (this.right != null) {
            heroNode = this.right.postOrderSearch(no);
        }

        if (heroNode != null) {
            return heroNode;
        }

        System.out.println("后序查找~~" + this.id);
        if (this.id == no) {
            return this;
        }
        return heroNode;
    }

}
