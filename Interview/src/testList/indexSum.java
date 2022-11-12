package src.testList;

public class indexSum {
    public static int indexSum(int c, int x, int[] num){
        int res = 0;
        for (int i=0; i<c; i++){
            int sum = 0;
            for (int j=i; j<c; j++){
                sum+=num[j];
                if (sum>=x)res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(indexSum(3, 6, new int[]{2,4,7}));
    }
}
