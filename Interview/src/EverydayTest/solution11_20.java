package src.EverydayTest;
//香槟塔问题
public class solution11_20 {
    public double champagneTower(int poured, int query_row, int query_glass){
        double[] row = {poured};
        for(int i=1; i<=query_row; i++){
            double[] nextrow = new double[i+1];
            for (int j=0; j<i; j++){
                double volume= row[j];
                if (volume>1){
                    nextrow[j]+=(volume-1)/2;
                    nextrow[j+1]+=(volume-1)/2;
                }
            }
            row = nextrow;
        }
        return Math.min(1, row[query_glass]);
    }
}
