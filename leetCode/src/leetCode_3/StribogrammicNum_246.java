package leetCode_3;

public class StribogrammicNum_246 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isStrobogrammatic(String num) {
		 if(num.length()==0) return false;
	        char[] numChar= num.toCharArray();
	        int len= numChar.length;
	        boolean res= true;
	        int i=0;
	        int j=len-1;
	        while(i<=j&&res){
	            if(i==j){
	                if(numChar[i]!='0'&&numChar[i]!='1'&&numChar[i]!='8') res=false;
	            }else{
	                switch(numChar[i]){
	                    case '1': if(numChar[j]!='1') res=false;
	                        break;
	                    case '0': if(numChar[j]!='0') res=false;
	                        break;
	                    case '6': if(numChar[j]!='9') res=false;
	                        break;
	                    case '8': if(numChar[j]!='8') res=false;
	                        break;
	                    case '9': if(numChar[j]!='6') res=false;
	                        break;
	                    default: res=false;
	                        break;
	                }
	            }
	            i++;
	            j--;
	        }
	        return res;
	        
        
    }

}
