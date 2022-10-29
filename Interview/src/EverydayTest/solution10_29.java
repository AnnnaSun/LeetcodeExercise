package src.EverydayTest;
//给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
//
//另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
//
//如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
//
//ruleKey == "type" 且 ruleValue == typei 。
//ruleKey == "color" 且 ruleValue == colori 。
//ruleKey == "name" 且 ruleValue == namei 。
//统计并返回 匹配检索规则的物品数量 。

import java.util.List;

public class solution10_29 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int result =0;
        for (List item: items){
            String s="";
            if (ruleKey.equals("type"))s= (String) item.get(0);
            else if (ruleKey.equals("color"))s= (String) item.get(1);
            else if (ruleKey.equals("name"))s= (String) item.get(2);
            if (s.equals(ruleValue)){
                result++;
            }
        }
        return result;
    }
}
