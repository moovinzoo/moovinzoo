import java.util.Collections;

public class Quicksort {
    private static Collections DSutil;

    static <E extends Comparable<? super E>> void qsort(E[] A, int i, int j) {
        int pivotindex = findpivot(A, i, j);
        Collections.swap(A, pivotindex, j);

        // k will be first position in right subarray
        int k = partition(A, i-1, j, A[j]);
        Collections.swap(A, k, j);
        if ((k - i) > 1) qsort(A, i, k-1);
        if ((j - k) > 1) qsort(A, k+1, j);
    }

    private static <E extends Comparable<? super E>> int partition(E[] A, int l, int r, E pivot) {
        do {
            while (A[++l].compareTo(pivot) < 0);
            while ((r != 0) && (A[--r].compareTo(pivot) > 0));
            Collections.swap(A, l, r);
        } while (l < r); // 같은 것을 가리키거나 교차할 때까지;
        Collections.swap(A, l, r);
        return l;
    }

    private static int findpivot(E[] a, int i, int j) {
        return (i + j) / 2;
    }

}
