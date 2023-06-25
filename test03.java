package Test;

public class test03 {
	   public static String funcC() {           
	        System.out.println("funcC() 동작 !");
	        
	        return "apple";                       
	    }

	    public static void main(String[] args) {
	    	
	        funcC();                        

	        System.out.println("main() 공간 : " + funcC());  
	        
	        String msg = funcC();
	        System.out.println("msg : " + msg);
	        msg += " banana";
	        System.out.println(msg);
	    }
}
