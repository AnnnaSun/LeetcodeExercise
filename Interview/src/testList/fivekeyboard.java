package src.testList;


public class fivekeyboard {
    public static int fivekeys(String s){
        String[] orderlist = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();//最终返回
        String copyStr = "";//剪切板
        String screenStr = "";//选择的屏幕显示的字符
        for (String intS: orderlist){
//            新增，会清空选择的字符
            if (intS.equals("1")){
                if(!screenStr.isEmpty()){
                    stringBuilder = new StringBuilder(stringBuilder.toString().replace(screenStr, ""));
                    screenStr="";
                }
                stringBuilder.append("a");
            }
//            ctrl-c 没有选择字符串的时候为空
            else if (intS.equals("2")){
                copyStr = screenStr;
            }
//            ctrl-x 复制字符串并且清空选择的字符串
            else if (intS.equals("3")){
                copyStr = screenStr;
                stringBuilder = new StringBuilder(stringBuilder.toString().replace(screenStr, ""));
                screenStr = "";
            }
//            粘贴并且清空scrrenStr
            else if (intS.equals("4")){
                if(!screenStr.isEmpty()){
                    stringBuilder = new StringBuilder(stringBuilder.toString().replace(screenStr, ""));
                    screenStr="";
                }
                stringBuilder.append(copyStr);
            }
//            选择所有
            else if (intS.equals("5")){
                screenStr = stringBuilder.toString();
            }
        }
        return stringBuilder.toString().length();
    }

    public static void main(String[] args){

        System.out.println(fivekeys("1 1 5 1 5 2 4 4"));
    }
}


