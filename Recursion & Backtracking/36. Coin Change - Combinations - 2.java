class Main{

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        
        if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf + ".");
            }
            return;
    }
        int ramt = tamt - amtsf;
        for(int j = ramt / coins[i]; j > 0; j--){
            String toadd = "";
            for(int k = 0; k < j; k++){
                toadd += coins[i] + "-";
            }
            coinChange(i + 1, coins, amtsf + coins[i] * j, tamt, asf + toadd);
        }
    coinChange(i + 1, coins, amtsf, tamt, asf);
    }
        public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}