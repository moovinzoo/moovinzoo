public class mergesort {
    final static int TH = 2;
    static <E extends Comparable<? super E>> void mergesort(E[] A, E[] temp, int l, int r) {
        int mid = (l+r) / 2;
        if (l == r) return;
        mergesort(A, temp, l, mid);
        mergesort(A, temp, mid+1, r);

        for (int i = l; i <= r; i++)
            temp[i] = A[i];

        int i1 = l; int i2 = mid + 1;
        for (int curr = l; curr <= r; curr++) {
            if (i1 == mid + 1) {
                A[curr] = temp[i2++];
            } else if (i2 == r + 1) {
                A[curr] = temp[i1++];
            } else if (temp[i1].compareTo(temp[i2]) < 0) {
                A[curr] = temp[i1++];
            } else {
                A[curr] = temp[i2++];
            }
        }
    }

    static <E extends Comparable<? super E>> void mergesort2(E[] A, E[] temp, int l, int r) {
        int i, j, k, mid = (l + r) / 2;
        if (l == r) return;
        if (mid - l >= TH) mergesort(A, temp, l, mid);
        else inssort(A, l, mid - l + 1); // 갯수
        if (r - (mid + 1) >= TH) mergesort(A, temp, mid+1, r);
        else inssort(A, mid+1, r - mid);

        for (i = l; i <= mid; i++) temp[i] = A[i];
        for (j = 1; j <= r-mid; j++) temp[r-j+1] = A[mid];

        for (i = 1, j = r, k = l; k <= r; k++) {
            if (temp[i].compareTo(temp[j]) < 0)
                A[k] = temp[i++];
            else A[k] = temp[j--];
        }
    }

    static <E extends Comparable<? super E>>void inssort(E[] A, int l, int r) {}
}
