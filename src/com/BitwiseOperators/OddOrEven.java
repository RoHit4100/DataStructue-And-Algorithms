public class OddOrEven{
    public static void main(String[] args){
        boolean isOdd = find(1);
        if(isOdd){
            System.out.println("Number is odd");
        }else{
            System.out.println("Number is even");
        }

    }
    /*
        If LSB of a number is 1 means that number is odd.
        LSB means last bit of any number.
        and if we use & operator with any number it will give the same number in bit.
    */ 
    static boolean find(int n){
        return (n & 1) == 1;
    }
}