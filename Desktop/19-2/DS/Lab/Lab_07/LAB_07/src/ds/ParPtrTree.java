package ds;

import java.util.Arrays;

/**
 * General Tree class implementation for UNION/FIND
 */
public class ParPtrTree {
    private Integer[] array; // Node array
    private Integer[] size; // groupsize array. Consider only values of root nodes. We don't need to care others.
    private int maxSize;

    public ParPtrTree(int maxsize) {
        this.maxSize = maxsize;
        array = new Integer[this.maxSize]; // Create node array
        size = new Integer[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            array[i] = null;
            size[i] = 1;
        }
    }

    public void clear() {
        array = new Integer[this.maxSize]; // Create node array
        size = new Integer[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            array[i] = null;
            size[i] = 1;
        }
    }

    /**
     * Determine if nodes are in different trees
     */
    public boolean differ(Integer a, Integer b) {
        //TODO: fill your code
        Integer aParent = find(a);
        Integer bParent = find(b);

        return !aParent.equals(bParent);
    }

    /**
     * Merge two subtrees using weighted union rule
     */
    public void union(Integer a, Integer b) {

        //TODO: fill your code
        // follow "weighted union rule"
        // if group size of two values are equal, hang b's root to a's.
        Integer aSize = groupSize(a);
        Integer bSize = groupSize(b);

        if (aSize.compareTo(bSize) >= 0) getArray()[find(b)] = find(a);
        else getArray()[find(a)] = find(b);
    }

    /**
     * Find the root of the node using path compression
     */
    public Integer find(Integer curr) {
        //TODO: fill your code
//        Integer tmp;
//        for (int i = 0; i < this.maxSize; i++) {
//            tmp = getArray()[i];
//            if (tmp.equals(curr)) return find(tmp);
//
//        }
//        return null; // this one is root node
        // when find(1)
        Integer tmp = getArray()[curr];
        if (tmp == null) return curr;
        else return find(tmp);
    }

    /**
     * Return the size of the graph that the node belongs to
     */
    public Integer groupSize(Integer curr) {
        //TODO: fill your code
        return getSize()[find(curr)];
    }

    public Integer[] getSize() {
        return this.size;
    }

    public Integer[] getArray() {
        return this.array;
    }

    public void print() {
        System.out.println(Arrays.toString(array).replace("null", "N"));
    }


}
