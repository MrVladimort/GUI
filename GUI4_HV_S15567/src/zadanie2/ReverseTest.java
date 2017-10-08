/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie2;


public class ReverseTest {

  public static void main(String[] args) {
  
        Reversible[] revers = new Reversible[] {
            new ReversibleString("Kot"),
            new ReversibleDouble(2),
            new ReversibleDouble(3),
            new ReversibleString("Pies"),
            new ReversibleString("Ala ma kota i psa"),
            new ReversibleDouble(10),
        };

        System.out.println("Normalne:");
        for (Reversible r : revers) {
          System.out.println(r);
        }

        for (Reversible r : revers) {
          r.reverse();
        }

        System.out.println("Odwrócone:");
        for (Reversible r : revers) {
          System.out.println(r);
        }

        System.out.println("Przywrócone i zmienione:");
        for (Reversible r : revers) {
           /*<-  co tu trzeba napisać */
        	r.reverse();
        	if(r.toString().charAt(0) > 47 && r.toString().charAt(0) < 58)
        		System.out.println(r);
        	else
        		System.out.println("Tekst " + r);
        }
      }
    }
