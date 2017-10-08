/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie1;

public class Main {
  public static void main(String[] args)
  {
	  
    Spiewak s1 = new Spiewak("Carrey"){
		@Override
		public String spiewaj() {
			String s = "oooooooooooo";
			
			return s;
		}
    };

    Spiewak s2 = new Spiewak("Houston"){
    	@Override
		public String spiewaj() {
			String s = "a4iBBiii";
			
			return s;
    	}
    };

    Spiewak s3 = new Spiewak("Madonna"){
    	@Override
		public String spiewaj() {
			String s = "aAa";
			
			return s;
		}
    };

    Spiewak sp[] = {s1, s2, s3};

    for (Spiewak s : sp)
      System.out.println(s);

    System.out.println("\n" + Spiewak.najglosniej(sp));
    
  }
}
