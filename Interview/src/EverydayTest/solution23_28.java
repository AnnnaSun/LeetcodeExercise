package src.EverydayTest;

import java.util.*;

//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
//
//如果文件夹folder[i]位于另一个文件夹folder[j]下，那么folder[i]就是folder[j]的 子文件夹 。
//
//文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/'后跟一个或者多个小写英文字母。
//
//例如，"/leetcode"和"/leetcode/problems"都是有效的路径，而空字符串和"/"不是。
//
public class solution23_28 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        Deque folderqueue = new LinkedList();
        for (String s: folder){
            if (folderqueue.isEmpty()){
                folderqueue.offer(s);
            }
            else {
                String pre = (String) folderqueue.peek();
                if (!compareFolder(pre, s)){
                    res.add(pre);
                    folderqueue.pollFirst();
                    folderqueue.offerLast(s);
                }
            }
        }
        if (!folderqueue.isEmpty())res.add((String) folderqueue.peek());
        return res;
    }

    public boolean compareFolder(String afolder, String bfolder){
        String[] splita = afolder.split("/");
        String[] splitb = bfolder.split("/");
        for (int i=0; i<Math.min(splitb.length, splita.length); i++){
            if (!splitb[i].equals(splita[i]))return false;
        }
        return true;
    }
}
