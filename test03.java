package Test;

public class test03 {
	   public static String funcC() {           
	        System.out.println("funcC() ���� !");
	        
	        return "apple";                       
	    }

	    public static void main(String[] args) {
	    	
	        funcC();                        

	        System.out.println("main() ���� : " + funcC());  
	        
	        String msg = funcC();
	        System.out.println("msg : " + msg);
	        msg += " banana";
	        System.out.println(msg);
	    }
}
