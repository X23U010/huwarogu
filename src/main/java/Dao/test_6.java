package Dao;

public class test_6 {

	public static void main(String[] args) {
		
		boolean tf = isId_2("y23u010");

		System.out.println(tf);
	}

	public static boolean isId_2(String values) {
		
		System.out.println(values.charAt(0));
		
		if (!(values.startsWith("x")) && !(values.startsWith("t"))) {
			
			if(!(values.startsWith("x"))) {
				System.out.println("xの処理に該当");
			}
			
			if(!(values.startsWith("t"))) {
				System.out.println("tの処理に該当");

			}
			return true;
		}

		if(!(values.startsWith("x"))) {
			System.out.println("xの処理に該当");
		}
		
		if(!(values.startsWith("t"))) {
			System.out.println("tの処理に該当");

		}
		return false;
	}
	
	
}

