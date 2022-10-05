package src.EverydayTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subdomainVisits {
    public static List<String> getsubdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainMap = new HashMap<>();
        for (String s: cpdomains){
            String[] splitStr = s.split(" ");
            int num = Integer.parseInt(splitStr[0]);
            String[] domains = splitStr[1].split("\\.");
            int len = domains.length;
            String basedomain = domains[len-1];
            int basenum = 0;
            if (domainMap.containsKey(basedomain)){
                basenum = domainMap.get(basedomain);
            }
            domainMap.put(basedomain, num + basenum);
            for (int i=len-2; i>=0; i--){
                basedomain = domains[i] +"."+basedomain;
                int extranum = 0;
                if (domainMap.containsKey(basedomain)){
                    extranum = domainMap.get(basedomain);
                }
                domainMap.put(basedomain, num + extranum);
            }
        }
        List<String> subdomains = new ArrayList<>();
        for (String key: domainMap.keySet()){
            int num = domainMap.get(key);
            subdomains.add(num +" "+ key);
        }
        return subdomains;

    }

    public static void main(String[] args) {
        subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    }
}
