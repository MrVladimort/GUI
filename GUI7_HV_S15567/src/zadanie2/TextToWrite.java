package zadanie2;

public class TextToWrite {
    String txt;
    boolean newTxt = false;

    public TextToWrite(String text){this.txt = text;}
    
    synchronized String getTxt() {
        while (newTxt == false) {
          try {
            wait();
          } catch(InterruptedException exc) {}
        }
        newTxt = false;
        notifyAll();
        return txt;
    }
    
    synchronized void setTxt(String s) {
        while (newTxt == true) {
          try {
            wait();
          } catch(InterruptedException exc) {}
        }
        txt = s;
        newTxt = true;
        notifyAll();
    }
}