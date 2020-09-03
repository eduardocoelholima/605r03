

// Program output:
// 1.	true
// 2.	true
// 3.	false
// 4.	false
// 5.	false
// 6.	false
// 7.	true
// 8.	true
// 9.	false



class StringThing {
  public static String method1()	{
	return "123";
  }
  public static String method2()	{
	return method1();
  }
  public static void main( String args[] ) {
	int counter = 0;
	int theNumberThree = 3;
// first block begins 		/////////////////////////////////////////////////////////////
	String aString = "123";
	String bString = "123";
	String cString = "12" + "3";
	String dString = "12" + theNumberThree;
	String eString = "123" + aString;
	String fString = "123123";
	
	System.out.println("" + ++counter + ".	" +   ( aString  == bString ) );
	System.out.println("" + ++counter + ".	" +   ( bString  == cString ) );
	System.out.println("" + ++counter + ".	" +   ( cString  == dString ) );
	System.out.println("" + ++counter + ".	" +   ( eString  == fString ) );
// first block ends 		/////////////////////////////////////////////////////////////

// second block begins 		/////////////////////////////////////////////////////////////
	String aaString = "123";
	String bbString = new String("123");
	String ccString = new String(aString);
	String ddString = method1();
	String eeString = method2();
	String ffString = method1() + method2();

	System.out.println("" + ++counter + ".	" +   ( aaString  == bbString ) );
	System.out.println("" + ++counter + ".	" +   ( aaString  == ccString ) );
	System.out.println("" + ++counter + ".	" +   ( aaString  == ddString ) );
	System.out.println("" + ++counter + ".	" +   ( aaString  == eeString ) );
	System.out.println("" + ++counter + ".	" +   ( ffString  == "123123" ) );
// second block ends 		/////////////////////////////////////////////////////////////

  }
}
