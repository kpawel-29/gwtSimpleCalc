package gwt.myproject.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Kalkulator implements EntryPoint {
	
	final Button sendButton = new Button("Send");
	final Label wynikLabel  = new Label();
	final TextBox tb1 = new TextBox();
	final TextBox tb2 = new TextBox();
	
	final RadioButton rbPlus = new RadioButton("dzialanie", "+");
	final RadioButton rbMinus = new RadioButton("dzialanie", "-");
	final RadioButton rbRazy = new RadioButton("dzialanie", "*");
	final RadioButton rbDziel = new RadioButton("dzialanie", "/");
	
	private int wynik;
	private KalkulatorServiceAsync kalkServ = GWT.create(KalkulatorService.class);
	
	private void refreshWatchList() {
		// Initialize the service proxy.
		if (kalkServ == null)
			kalkServ = GWT.create(KalkulatorService.class);
	}
	
	AsyncCallback<String> callback = new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("error");			
		}

		@Override
		public void onSuccess(String result) {
			wynikLabel.setText(result);			
		}		
	};
	
	@Override
	public void onModuleLoad() {
		RootPanel.get().add(tb1);
		RootPanel.get().add(rbPlus);
		rbPlus.setValue(true);
		RootPanel.get().add(rbMinus);
		RootPanel.get().add(rbRazy);
		RootPanel.get().add(rbDziel);
		
		RootPanel.get().add(tb2);
		
		RootPanel.get().add(sendButton);
		RootPanel.get().add(wynikLabel);
		sendButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(rbPlus.getValue())
					kalkServ.Oblicz(tb1.getText(),tb2.getText(),"+", callback);
				if(rbMinus.getValue())
					kalkServ.Oblicz(tb1.getText(),tb2.getText(),"-", callback);
				if(rbRazy.getValue())
					kalkServ.Oblicz(tb1.getText(),tb2.getText(),"*", callback);
				if(rbDziel.getValue()){
					if(tb2.getText().equals("0")) {
						Window.alert("Nie wolno dzielic przez 0!");
					}else{
						kalkServ.Oblicz(tb1.getText(),tb2.getText(),"/", callback);
					}					
				}
		}});
	}


	
}

