package zadanie1;

import javax.swing.*;
import java.text.DecimalFormat;

public class TempList extends AbstractListModel{

	@Override
	public Object getElementAt(int k) {
		k = k - 70;
		double f = (k * 1.8) + 32;
		String s = new DecimalFormat("#0.0").format(f);
		return k + " stopni C =" + s + " stopni F";
	}

	@Override
	public int getSize() {
		return 131;
	}
}