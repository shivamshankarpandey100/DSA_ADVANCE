import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String[] subdomains = domain.split("\\.");
            String currentDomain = "";

            for (int i = subdomains.length - 1; i >= 0; i--) {
                currentDomain = subdomains[i] + (i < subdomains.length - 1 ? "." : "") + currentDomain;
                domainCountMap.put(currentDomain, domainCountMap.getOrDefault(currentDomain, 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domainCountMap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
