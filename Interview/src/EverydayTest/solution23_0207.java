package src.EverydayTest;

import javax.management.Query;
import java.util.*;

//力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告。
//
//给你字符串数组keyName和keyTime ，其中[keyName[i], keyTime[i]]对应一个人的名字和他在某一天 内使用员工卡的时间。
//
//使用时间的格式是 24小时制，形如"HH:MM"，比方说"23:51" 和"09:49"。
//
//请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序排序后返回。
//
//请注意"10:00" - "11:00"视为一个小时时间范围内，而"23:51" - "00:10"不被视为一小时内，因为系统记录的是某一天内的使用情况。
//
public class solution23_0207 {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> timeMap = new HashMap<String, List<Integer>>();
            int n = keyName.length;
            for (int i = 0; i < n; i++) {
                String name = keyName[i];
                String time = keyTime[i];
                timeMap.putIfAbsent(name, new ArrayList<Integer>());
                int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
                int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
                timeMap.get(name).add(hour * 60 + minute);
            }
            List<String> res = new ArrayList<String>();
            Set<String> keySet = timeMap.keySet();
            for (String name : keySet) {
                List<Integer> list = timeMap.get(name);
                Collections.sort(list);
                int size = list.size();
                for (int i = 2; i < size; i++) {
                    int time1 = list.get(i - 2), time2 = list.get(i);
                    int difference = time2 - time1;
                    if (difference <= 60) {
                        res.add(name);
                        break;
                    }
                }
            }
            Collections.sort(res);
            return res;
        }

}
