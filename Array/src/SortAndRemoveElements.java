import java.util.Arrays;

public class SortAndRemoveElements {

    public static void sort(String[] strings) {
        /* reshenie 1 */
        // Arrays.sort(strings);

        /* reshenie 2 */
        int i = 0;
        while (i < strings.length) {
            int j = 0;
            while (j < strings.length - 1) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    String pom = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = pom;
                }
                j++;
            }
            i++;
        }
    }

    public static int removeDuplicates(String[] strings) {

        int n = strings.length;
        if (n == 0 || n == 1)
            return n;

        String[] temp = new String[n];

        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (strings[i] != strings[i + 1]) {
                temp[j++] = strings[i];
            }
        }
        temp[j++] = strings[n - 1];

        for (int i = 0; i < j; i++)
            strings[i] = temp[i];

        return j;

    }

    public static void main(String[] args) {
        String[] strings = {"k", "j", "a", "b", "c", "c", "d", "e", "f", "g", "h", "i"};

        sort(strings);

        int length = removeDuplicates(strings);
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                System.out.print(strings[i] + ", ");
            } else {
                System.out.print(strings[i]);
            }
        }
        System.out.print("]");
    }
}
