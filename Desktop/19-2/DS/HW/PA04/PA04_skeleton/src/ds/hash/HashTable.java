package ds.hash;

public class HashTable {
    private int[] table; // array 형태 해시
    private int c1, c2, c3;
    private int delMarker = -1;
    private int tableSize; // include deleted element

    public HashTable(int n) {
        //TODO: fill your code
        table = new int[n];
        tableSize = 0;
    }

    public void create(int c1, int c2, int c3) {
        //TODO: fill your code
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    public void insert(int key) {
        //TODO: fill your code
        int i = 0;
        int j = quadProb(key, i);
        while (!isEmpty(j)) {
            j = quadProb(key, ++i);
        }

        table[j] = key;
        tableSize++;
        System.out.println("INSERT: " + key + " / INDEX: " + j);
    }

    public void delete(int key) {
        int index = search(key, true);
        if (index == -1) return;
        else {
            table[index] = -1;
            System.out.println("DELETE: " + key + " / INDEX: " + index);
//            tableSize--;
        }
    }

    public int search(int key, boolean fromDelete) {
        //TODO: fill your code
        int i = 0;
        int j = quadProb(key, i);
        while (isDeleted(j)) {
            j = quadProb(key, ++i);
        }

        if (table[j] == 0) {
            System.out.println("Failed to find " + key);
            return -1;
        } // empty
        else if (table[j] == key) {
            if (!fromDelete)
                System.out.println("SEARCH: " + key + " / INDEX: " + j);
            return j;
        } // found
        else {
            System.out.println("ERR");
            return -1;
        }
    }

    public void printAll() {
        //TODO: fill your code
        // 6453(107), 132(133), 321(322), 435(436)
        int i = 0;
        int cnt = 0;
        int capacity = table.length;
        while (cnt < tableSize && i < capacity) {
//        while (cnt < tableSize) {
            if (isEmpty(i)) {
                i++;
                continue;
            }
            else {
                if (cnt == 0) {
                    System.out.print(table[i] + "(" + i + ")");
                } else {
                    System.out.print(", " + table[i] + "(" + i + ")");
                }
                i++;
                cnt++;
            }
        }
        System.out.println();
    }

//    public String search(int key) {
//        //TODO: fill your code
//        int i = 0;
//        int j = quadProb(key, i);
//        while (isDeleted(j)) {
//            j = quadProb(key, ++i);
//        }
//
//        if (table[j] == 0) {
//            return ("Failed to find " + key);
//        } // empty
//        else if (table[j] == key) {
//            return ("SEARCH: "+ key +" / INDEX: " + j);
//        } // found
//        else {
//            System.out.println("ERR");
//            return "ERR";
//        }
//    }

    private int quadProb(int k, int i) {
        //TODO: fill your code
        return (hash(k) + (c1 * i * i) + (c2 * i) + c3);
    }

    private int hash(int x) {
        return (x % table.length);
    }
    private boolean isEmpty(int index) {
        return (this.table[index] == 0);
    }
    
    private boolean isDeleted(int index) {
        return (table[index] == -1);
    }
}
