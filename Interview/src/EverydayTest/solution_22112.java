package src.EverydayTest;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给你一个字符串s，它包含一些括号对，每个括号中包含一个 非空的键。
//
//比方说，字符串"(name)is(age)yearsold"中，有两个括号对，分别包含键"name" 和"age"。
//你知道许多键对应的值，这些关系由二维字符串数组knowledge表示，其中knowledge[i] = [keyi, valuei]，表示键keyi对应的值为valuei。
//
//你需要替换 所有的括号对。当你替换一个括号对，且它包含的键为keyi时，你需要：
//
//将keyi和括号用对应的值valuei替换。
//如果从 knowledge中无法得知某个键对应的值，你需要将keyi和括号用问号"?"替换（不需要引号）。
//knowledge中每个键最多只会出现一次。s中不会有嵌套的括号。
//
//请你返回替换 所有括号对后的结果字符串。
//
public class solution_22112 {
    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<String, String>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        List<List<String>> knowledge = new ArrayList<>();
        List<String> initStringList = new ArrayList<>();
        List<String> initStringList2 = new ArrayList<>();
        initStringList.add("name");
        initStringList.add("bob");
        initStringList2.add("age");
        initStringList2.add("two");
        knowledge.add(initStringList2);
        knowledge.add(initStringList);
        evaluate("(name)is(age)yearsold", knowledge);
    }
}
