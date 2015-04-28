package gwt.myproject.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("kalkulator")
public interface KalkulatorService extends RemoteService{
	public String Oblicz(String s1, String s2, String dzialanie) throws DelistedException;
}
