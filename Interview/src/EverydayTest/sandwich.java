package src.EverydayTest;
//学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
//餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
//
//如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
//否则，这名学生会放弃这个三明治并回到队列的尾部。
//这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sandwich {
    public int countStudents(int[] students, int[] sandwiches) {
        int studentL = students.length;
        boolean flag = false;
        List<Integer> indexs = new ArrayList<Integer>();
        for(int j=0; j<sandwiches.length;j++){
            for (int i = 0;i<studentL;i++){
                if (students[i] == sandwiches[j] && !indexs.contains(i)){
                    indexs.add(i);
                    break;
                }
                if (i == studentL-1 && students[i] != sandwiches[j]){
                    flag = true;
                }
            }
            if (flag){
                break;
            }
        }
        return studentL- indexs.size();
    }

    public int countStudentsTrue(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

}
