public static int[] sort(int[] array){ int[] aux = new int[array.length]; int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++){ if (array[i] < min){
        min = array[i];
        }else if (array[i] > max){
        max = array[i]; }
        }
        int[] counts = new int[max - min + 1]; for (int i=0; i<counts.length; i++) {
        counts[i] = 0; }
        for (int i = 0; i < array.length; i++){ counts[array[i] - min]++;
        } counts[0]--; for (int i =
        1; i < counts.length; i++){ = counts[i] + counts[i-1];
        }
        ★
        counts[i]
        array.length - 1; i >= 0; i--){
        for (int i =
        aux[counts[array[i] - min]--] = array[i];
        }
        return aux; }