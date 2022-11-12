package src.testList;

public class findEndPoint {
    public static int findEndsteps(String s){
        String[] sarray = s.split(" ");
        int arraylength  = sarray.length;
        int minsteps = 100;
//        第一 步长度
        for (int steplength = 1; steplength<arraylength/2; steplength++){
//            第一步到达的地方
            int length = steplength;
            int steps=1;
            while(length<arraylength){
                int num = Integer.parseInt(sarray[length-1]);
                length+=num;
                steps++;
                if (length==arraylength){
                    minsteps = Math.min(steps, minsteps);
                }
                else if (length>arraylength){
                    break;
                }
            }
        }
        return minsteps==100?-1:minsteps;
    }

    public static void main(String[] args) {
        System.out.println(findEndsteps("1 2 3 7 1 5 9 3 2 1"));
    }
}
