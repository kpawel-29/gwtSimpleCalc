package gwt.myproject.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface KalkulatorServiceAsync {

	void Oblicz(String s1, String s2, String dzialanie,
			AsyncCallback<String> callback);

}
