package src.EverydayTest;

//如果所给格子的颜色是白色，请你返回true，如果是黑色，请返回false。
//
//给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
//
public class solution12_8 {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0)-'a';
        int y = Integer.parseInt(coordinates.substring(1));
        int sum = x+y-1;
        if(sum%2==0)return false;
        else return true;
    }
}
