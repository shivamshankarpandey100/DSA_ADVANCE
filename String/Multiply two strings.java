//https://www.geeksforgeeks.org/problems/multiply-two-strings/1

 public String multiplyStrings(String str1, String str2) {
        // code here.
        int signS1= str1.charAt(0)=='-'?-1:1;
        str1=str1.charAt(0)=='-'?str1.substring(1,str1.length()):str1;
        int signS2= str2.charAt(0)=='-'?-1:1;
        str2=str2.charAt(0)=='-' ? str2.substring(1,str2.length()):str2;
        int [] s1=deleteLeadingZeroes(str1);
        int [] s2=deleteLeadingZeroes(str2);
        if(s1.length==0 || s2.length==0) return "0";
        if(s1.length<s2.length){
             var t=s1;
             s1=s2;
             s2=t;
        }
        
        int ans[]= new int[s1.length+s2.length+1];
        
        for(int i=0;i<s2.length;i++){
            int ith[]=new int[s1.length+1];
            int carry=0;
            for(int j=s1.length-1;j>=0;j--){
                int num=s1[j]*s2[s2.length-1-i];
                num+=carry;
                int newCarry=num/10;
                num=num%10;
                ith[j+1]=num;
                
                carry=newCarry;
            }
            ith[0]=carry;
            addArrays(i,ans,ith);
        }
        
        StringBuilder sb=new StringBuilder();
        
        if(signS1*signS2<0) sb.append('-');
        
        answerAppend(sb,ans);
        
        return sb.toString();
        
        
    }
    void answerAppend(StringBuilder sb,int []ans){
        int i=0;
        for( i=0;i<ans.length;i++){
            if(ans[i]!=0) break;
        }
        
        for(;i<ans.length;i++){
            sb.append((char)(ans[i]+'0'));
        }
    }
    
    void addArrays(int offset,int []ans ,int []ith){
        int carry=0;
        for(int i=0;i<ith.length;i++){
            
            ans[ans.length-1-offset-i]+=(ith[ith.length-1-i]+carry);
            carry=ans[ans.length-1-offset-i]/10;
            ans[ans.length-1-offset-i]=ans[ans.length-1-offset-i]%10;
        }
    }
    
    int[] deleteLeadingZeroes(String s){
        int i=0;
        while(i<s.length() && s.charAt(i)=='0' ) i++;
        
        char[] arr=s.substring(i,s.length()).toCharArray();
        int [] ans=new int[arr.length];
        
        for(i=0;i<arr.length;i++){
            ans[i]=arr[i]-'0';
        }
        
        return ans;
    }