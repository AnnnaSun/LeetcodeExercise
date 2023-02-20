package src.EverydayTest;

public class solution230214 {
    public static int longestWPI(int[] hours) {
        int[] record = new int[hours.length];
        for (int i=0; i<hours.length; i++){
            if (hours[i]>8)record[i]=1;
            else record[i] =-1;
        }
        int[] points = new int[hours.length+1];
        int[] points1 = new int[hours.length+1];
        points[0]=0;
        for (int i=0; i<hours.length; i++){
            points[i+1] = record[i]+points[i];
        }
        for (int i=hours.length-1; i>=0; i--){
            points1[hours.length-i] = record[i]+points[hours.length-i-1];
        }
        int recordnum = 0, recordnum1=0;
        int res=0;
        for (int i=0; i<points.length; i++){
            if (points[i]>0)recordnum++;
            else {
                res = Math.max(recordnum, res);
                recordnum=0;
            }
            if (points1[i]>0)recordnum1++;
            else {
                res = Math.max(recordnum1, res);
                recordnum1=0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        longestWPI(new int[]{6,6,9});
    }
}
