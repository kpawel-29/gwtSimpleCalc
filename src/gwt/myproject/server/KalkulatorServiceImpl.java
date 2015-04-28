package gwt.myproject.server;

import gwt.myproject.client.DelistedException;
import gwt.myproject.client.Kalkulator;
import gwt.myproject.client.KalkulatorService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class KalkulatorServiceImpl extends RemoteServiceServlet implements KalkulatorService{
	
	private static int wynik = 0;
	@Override
	public String Oblicz(String s1, String s2, String dzialanie) throws DelistedException{
		int val1 = Integer.valueOf(s1);
		int val2 = Integer.valueOf(s2);
		switch (dzialanie){
		case "+":
			wynik = val1 + val2;
			break;
		case "-":
			wynik = val1 - val2;
			break;
		case "*":
			wynik = val1 * val2;
			break;
		case "/":
			wynik = val1 / val2;
			break;
		default: 
			wynik = 0;
		}
		return String.valueOf(wynik);
	}

}
