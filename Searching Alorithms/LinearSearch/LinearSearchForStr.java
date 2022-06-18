public class LinearSearchForStr {
    public static void main(String[] args) {
        String str = "Rohit Laxman Udamale";
        str = str.toLowerCase();
        char target_char = 's';
        int count = search(str, target_char);
        if (count > 0) {
            System.out.println("Charaacter is present" + count + " times");
        } else {
            System.out.println("Character is not present");
        }
    }

    static int search(String str, char target_char) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target_char) {
                count++;
            }
        }
        if (count > 0) {
            return count;
        }
        return -1;
    }
}
