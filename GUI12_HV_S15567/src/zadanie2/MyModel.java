package zadanie2;

import javax.swing.*;
import java.util.*;

public class MyModel extends AbstractListModel {
    Vector v = new Vector();   // elementy lista będą tu

    // domyślny konstruktor: do listy będziemy dodawać później, za pomocą metod add
    MyModel(){}

    // inicjalna lista podana jako tablica obiektów
    MyModel(Object[] o){ for (int i = 0; i<o.length; i++) v.addElement(o[i]); }

    public int getSize(){ return v.size(); }

    public Object getElementAt(int index){ return v.elementAt(index); }

    // Dodaje element na pozycji index-1
    public void add(int index, Object o){
        v.insertElementAt(o, index);
        fireIntervalAdded(this, index, index);
    }

    // Dodaje element na końcu listy
    public void add(Object o){ add(getSize(), o); }

    // Usuwa element na pozycji index
    void remove(int index){
        v.removeElementAt(index);
        fireIntervalRemoved(this, index, index);
    }
}
