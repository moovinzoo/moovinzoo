package com.dmlab.bst;

public class BinarySearchTree<Key extends Comparable<? super Key>, E> {

    /**
     * root of this tree
     */
    private BinaryNode<Key, E> root;
    private int nodeCount = 0;

    // Declare more variables HERE
    private static final int INITIAL_ORDER = 0;
    private int order = INITIAL_ORDER;
    Key returnKey = null;

    /**
     * Constructor
     * Do not modify this function.
     */
    public BinarySearchTree() {
        root = null;
        nodeCount = 0;
    }

    /**
     * This function returns the root of the BST.
     * Do not modify this function.
     *
     * @return root of the BinarySearchTree
     */
    public BinaryNode<Key, E> getRoot() {
        return root;
    }

    /**
     * Reinitialize tree
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Insert an item into the tree.
     *
     * @param key   of the item
     * @param value of the item
     */
    public void insert(Key key, E value) {
        // TODO 1. insert node from root
        if (getRoot() == null) {
            root = new BinaryNode<>(key, value);
        } else {
            insertHelp(getRoot(), key, value); // return value
        }

//        this.nodeCount++;
        nodeCount = updateNodeSizes(getRoot());
    }

    /**
     * Insert the item <key,value> into the tree rt.
     *
     * @param rt    of the tree.
     * @param key   of the item to be inserted.
     * @param value of the item to be inserted.
     * @return the tree after insertion
     */
    private BinaryNode<Key, E> insertHelp(BinaryNode<Key, E> rt, Key key, E value) {
        // TODO: Fill in this function

        int compare = key.compareTo(rt.getKey());
        BinaryNode<Key, E> newNode = new BinaryNode<>(key, value);
        if (compare < 0) {
            if (rt.getLeft() == null) {
                rt.setLeft(newNode);
//                rt.getLeft().increaseSize();
            } else {
//                rt.increaseSize();
                insertHelp(rt.getLeft(), key, value);
            }
        } else { // compare > 0
            if (rt.getRight() == null) {
                rt.setRight(newNode);
//                rt.getRight().increaseSize();
            } else {
//                rt.increaseSize();
                insertHelp(rt.getRight(), key, value);
            }
        }

        return rt;
    }

    /**
     * Remove an item from the tree.
     *
     * @param key of the item to be removed.
     * @return the value of the removed item. If no such item, return null.
     */
    public E remove(Key key) {
        // TODO: Fill in this function
//        if (getRoot() == null) return null;
//        else {
//            BinaryNode<Key, E> removedNode = removeHelp(getRoot(), key);
//            if (removedNode != null) {
//                nodeCount = updateNodeSizes(getRoot());
//                return removedNode.getValue();
//            } else return null;
//        }
//
        if (getRoot() == null) return null;
        E removedItem = find(key);
        if (removedItem == null) return null;

        root = removeHelp(getRoot(), key);
        nodeCount = updateNodeSizes(getRoot());

        return removedItem;
    }

    /**
     * Remove a node with given key from the tree rt.
     *
     * @param rt  of the tree.
     * @param key of the item to be removed.
     * @return the tree after removing.
     */
    private BinaryNode<Key, E> removeHelp(BinaryNode<Key, E> rt, Key key) {
        // TODO: Fill in this function
//        if (rt == null) return null; // Nothing found

        int compare = key.compareTo(rt.getKey());
        if (compare == 0) { // FOUND, removing this Node(as root)
            if (rt.isLeaf()) {
                return null;
            } else if (rt.hasLeft() && !rt.hasRight()) {
                return rt.getLeft();
            } else if (!rt.hasLeft() && rt.hasRight()) {
                return rt.getRight();
            } else { // has Two children
                BinaryNode<Key, E> minNode = getMin(rt.getRight()); // step1 in delete
                rt.setKey(minNode.getKey());
                rt.setValue(minNode.getValue()); // step2 in delete
                deleteMin(rt.getRight()); // step3 in delete
                return rt;
            }

        } else if (compare < 0) { // key is on Left side
            rt.setLeft(removeHelp(rt.getLeft(), key));
            return rt;
        } else { // key is on the Right side
            rt.setRight(removeHelp(rt.getRight(), key));
            return rt;
        }
    }

    /**
     * Given a tree rt, get its smallest node.
     * The smallest node is the node with the minimum key.
     *
     * @param rt
     * @return the smallest node.
     */
    private BinaryNode<Key, E> getMin(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
        if(rt.getLeft() == null) return rt;
        else {
           return getMin(rt.getLeft());
        }
    }

    /**
     * Given a tree rt, delete the smallest node and return this tree.
     *
     * @param rt is the root of the tree
     * @return the tree after deletion.
     */
    private BinaryNode<Key, E> deleteMin(BinaryNode<Key, E> rt) {
        // TODO: Fill in this function
//        BinaryNode<Key, E> minNode = getMin(rt);
//        rt.setValue(minNode.getValue());
//        rt.setKey(minNode.getKey());
//         TODO : return deleting Node's copy
//        BinaryNode<Key, E> deletingNode = getMin(rt);
//        //BinaryNode<Key,E> tmpNode = new BinaryNode<>(deletingNode.getKey(), deletingNode.getValue());
////        removeHelp(rt, deletingNode.getKey());
//        if (deletingNode.isLeaf()) deletingNode = null;
//        else deletingNode = deletingNode.getRight();
//
//        return deletingNode;

        BinaryNode<Key, E> minNode = getMin(rt);
        removeHelp(rt, minNode.getKey());

        return null;
    }


    /**
     * Find the item with given key.
     *
     * @param key of the item
     * @return the value if the item. If no such item, return null.
     * Do not modify this function.
     */
    public E find(Key key) {
        return findHelp(root, key);
    }

    /**
     * @return The number of nodes in the tree.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * Find the item with given key in the tree rt.
     *
     * @param rt  is the root of the tree.
     * @param key is the key that we want to find in tree rt.
     * @return the value of the wanted item. If no such item, return null.
     */
    private E findHelp(BinaryNode<Key, E> rt, Key key) {
        // TODO: Fill in this function
        if (rt == null) return null; // None in this tree

        int compare = key.compareTo(rt.getKey());
        if (compare == 0) return rt.getValue(); // match
        else if (compare < 0) return findHelp(rt.getLeft(), key);
        else return findHelp(rt.getRight(), key);
    }

    /**
     * Prints all keys in the tree in ascending order.
     * Do not modify this function.
     */
    public void printBookList() {
        if (getRoot() == null) {
            System.out.println("BookSearch does not have any book");
        } else {
            printBookListHelper(getRoot());
        }
    }

    /**
     * Prints all keys in the tree with given root using inorder traversal.
     *
     * @param rt is the root of the tree. This param is used for the recursion.
     */
    public void printBookListHelper(BinaryNode<Key, E> rt) {
        ///TODO: Fill in this function
        System.out.print(rt.inorder());
    }

    /**
     * Given the order of the item, find the key of the corresponding item.
     *
     * @param order is the order of the item
     * @return the key of corresponding item. If no such item, return null.
     */
    public Key orderSearch(int order) {
        ///TODO: Fill in this function
        if (order > size() || order < 1) return null; // over spec

        initReturnKey();
        initOrder();
        orderSearchHelper(getRoot(), order);

        return getReturnKey();
    }

    /**
     * Given the order of the item and rt of the tree,
     * find the key of the corresponding item in the tree.
     *
     * @param rt    is the root of the tree.
     * @param _order is the order of the item
     * @return the key of corresponding item. If no such item, return null.
     */
    private void orderSearchHelper(BinaryNode<Key, E> rt, int _order) {
        ///TODO: Fill in this function

        if (rt.hasLeft()) orderSearchHelper(rt.getLeft(), _order);

        if (hasReturnKey()) return;
        increaseOrder();
        if (getOrder() == _order) {
            setReturnKey(rt.getKey());
        }
        if (!hasReturnKey() && rt.hasRight()) orderSearchHelper(rt.getRight(), _order);
    }

    /**
     * Given the key of the item, find the order of the item.
     *
     * @param key of the item
     * @return the order of the item. If no such item, return 0.
     */

    public int orderSearch(Key key) {
        ///TODO: Fill in this function

        initReturnKey();
        initOrder();
        orderSearchHelper(getRoot(), key);

        if (!hasReturnKey()) return 0;
        else return getOrder();
    }

    /**
     * Given the key of the item and the root of the tree,
     * find the order of the item in the tree.
     *
     * @param rt    of the tree
     * @param key   of the item
//     * @param cnt is the number of small items found before.
     * @return the order of the item. If no such item, return 0.
     */
    private void orderSearchHelper(BinaryNode<Key, E> rt, Key key) {
        ///TODO: Fill in this function

        if (rt.hasLeft()) orderSearchHelper(rt.getLeft(), key);

        if (hasReturnKey()) return;
        increaseOrder();
        if (key.compareTo(rt.getKey()) == 0) { // equals
            setReturnKey(key);
            return;
        }

        if (!hasReturnKey() && rt.hasRight()) orderSearchHelper(rt.getRight(), key);
    }
    // Implement more functions HERE
    // TODO :: getNodeCount

    private int updateNodeSizes(BinaryNode<Key, E> rt) {

        int weight = 0;
        if (rt == null) return 0;

        // Check every nodes
        else { // rt is not empty
            weight++;
            if (rt.hasLeft() && rt.hasRight()) {
                rt.setSize(weight + updateNodeSizes(rt.getLeft()) + updateNodeSizes(rt.getRight()));
            } else if (rt.hasLeft()) {
                rt.setSize(weight + updateNodeSizes(rt.getLeft()));
            } else if (rt.hasRight()){
                rt.setSize(weight + updateNodeSizes(rt.getRight()));
            } else { // leaf
                rt.setSize(weight);
            }

            return rt.getSize();
        }
    }

    private void initOrder() {
        order = INITIAL_ORDER;
    }

    private int getOrder() {
        return order;
    }

    private void setOrder(int _order) {
        order = _order;
    }

    private void increaseOrder() {
        order++;
    }

    private void initReturnKey() {
        returnKey = null;
    }

    private boolean hasReturnKey() {
        return returnKey != null;
    }

    private void setReturnKey(Key _key) {
        returnKey = _key;
    }

    private Key getReturnKey() {
        return returnKey;
    }
//    private BinaryNode<Key, E> getNode(BinaryNode<Key, E> rt, Key key) {
//        if (rt == null) return null;
//
//        int compare = key.compareTo(rt.getKey());
//        if (compare == 0) return rt;
//        if (compare < 0) return getNode(rt.getLeft(), key);
//        else return getNode(rt.getRight(), key);
//    }
}
