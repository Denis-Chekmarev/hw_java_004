public class MergeSort {


    
    static int[] sort_merge(int[] array){
        if (array == null){
            return null;
        }
        if (array.length < 2){
            return array;
        }

        int[] left_part = new int[array.length / 2];
        System.arraycopy(array, 0, left_part, 0, array.length / 2);

        int[] right_part = new int[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, right_part, 0, array.length - array.length / 2);

        left_part = sort_merge(left_part);
        right_part = sort_merge(right_part);

        return _merge(left_part, right_part);
    }


    public static int[] _merge(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int n = a1.length;
        int m = a2.length;
        int i = 0, j = 0, k = 0;
            while (i < n && j < m) {
                if (a1[i] <= a2[j]) {
                    res[k] = a1[i];
                    i++; }
                else {
                    res[k] = a2[j];
                    j++; }
                k++; }
                while (i < n) {
                    res[k] = a1[i];
                    i++;
                    k++; }
            while (j < m) {
                res[k] = a2[j];
                j++;
                k++; }
        return res;
    }


    public static void main(String[] args) {
        
        int[] array = {2,3,1,4, 3, 65, 3, 7, 94, 54};

        array = sort_merge(array);

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("\n");
    }
}
