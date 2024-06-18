

//   https://leetcode.com/problems/smallest-sufficient-team/description/


import java.util.*;

class Main {

	static ArrayList<Integer> sol = new ArrayList<>();

	public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int skills) {

        if(cp == people.length){
            if(skills == ((1 << nskills) - 1)){
                if(sol.size() == 0 || onesol.size() < sol.size()){
                    sol = new ArrayList<>(onesol);
                }
            }
            return;
        }

        solution(people, nskills, cp + 1, onesol, skills);

        onesol.add(cp);
        solution(people, nskills, cp + 1, onesol, (skills | people[cp]));
        onesol.remove(onesol.size() - 1);

	}
}


//-------------------------------------------------2nd Approach--------------------------------------------
import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int target = (1 << n) - 1; 
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }
        
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        
        for (int i = 0; i < people.size(); i++) {
            int personSkillMask = 0;
            for (String skill : people.get(i)) {
                personSkillMask |= (1 << skillIndex.get(skill));
            }
            
            Map<Integer, List<Integer>> newDp = new HashMap<>(dp);
            
            for (int skillSet : dp.keySet()) {
                int newSkillSet = skillSet | personSkillMask; 
                if (!newDp.containsKey(newSkillSet) || newDp.get(newSkillSet).size() > dp.get(skillSet).size() + 1) {
                    List<Integer> newTeam = new ArrayList<>(dp.get(skillSet));
                    newTeam.add(i);
                    newDp.put(newSkillSet, newTeam);
                }
            }
            
            dp = newDp; }
        
        List<Integer> result = dp.get(target);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}
