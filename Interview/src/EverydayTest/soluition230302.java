package src.EverydayTest;

public class soluition230302 {
    public static String printBin(double num) {
        StringBuilder res = new StringBuilder("0.");
        int length =2;
        double n = num/0.5;
        while (n-(int)n>0){
            res.append((int)n);
            length++;
            n = (n-(int)n)/0.5;
            if (length>=32)return "ERROR";
        }
        res.append((int)n);
        return res.toString();
    }

    public static void main(String[] args) {
        printBin(0.078125);
    }
}
