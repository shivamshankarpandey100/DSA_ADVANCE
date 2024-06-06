

import java.util.*;
class Main{

	public static int solutionfork1(String str){

		int ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		int i = -1;
		int j = -1;

		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < str.length() - 1){
				f1 = true;

				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if(map.size() == 2){
					removeInMap(map, ch);i--;
					break;
				}
			}

			while(j < i){
				f2 = true;

				if(map.size() == 1){
					ans += i - j;
				}

				j++;
				char ch = str.charAt(j);
				removeInMap(map, ch);

				if(map.size() == 0){
					break;
				}
			}

			if(f1 == false && f2 == false){
				break;
			}
		}


		return ans;
	}
	
	public static int solution(String str, int k){
		int ans = 0;
		
		if(k == 1){
			return solutionfork1(str);
		}

		HashMap<Character, Integer> bmap = new HashMap<>();
		HashMap<Character, Integer> smap = new HashMap<>();

		int ib = -1;
		int is = -1; 
		int j = -1;

		while(true){

			boolean f1 = false;
			boolean f2 = false;
			boolean f3 = false;
			
			while(ib < str.length() - 1){
				f1 = true;

				ib++;
				char ch = str.charAt(ib);
				bmap.put(ch, bmap.getOrDefault(ch, 0) + 1);

				if(bmap.size() == k + 1){
					removeInMap(bmap, ch);
					ib--;
					break;
				}
			}

			while(is < str.length() - 1){
				f2 = true;

				is++;
				char ch = str.charAt(is);
				smap.put(ch, smap.getOrDefault(ch, 0) + 1);

				if(bmap.size() == k){
					removeInMap(smap, ch);
					is--;
					break;
				}
			}


			while(j < is){
				f3 = true;

				if(bmap.size() == k && smap.size() == k - 1){
					ans += ib - is;
				}

				j++;
				char ch = str.charAt(j);
				removeInMap(smap, ch);
				removeInMap(bmap, ch);

				if(smap.size() < k - 1 || bmap.size() < k){
					break;
				}

	      	}

			if(f1 == false && f2 == false && f3 == false){
				break;
			}

		}

		return ans;
	}

	public static void removeInMap(HashMap<Character, Integer> map, char ch){
		if(map.get(ch) == 1){
			map.remove(ch);
		}else{
			map.put(ch, map.get(ch) - 1);
		}
	}
}