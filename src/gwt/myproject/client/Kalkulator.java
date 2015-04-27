package gwt.myproject.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
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
					wynikLabel.setText(Oblicz(tb1.getText(),tb2.getText(),"+"));
				if(rbMinus.getValue())
					wynikLabel.setText(Oblicz(tb1.getText(),tb2.getText(),"-"));
				if(rbRazy.getValue())
					wynikLabel.setText(Oblicz(tb1.getText(),tb2.getText(),"*"));
				if(rbDziel.getValue()){
					if(tb2.getText().equals("0")) {
						Window.alert("Nie wolno dzielic przez 0!");
					}else{
						wynikLabel.setText(Oblicz(tb1.getText(),tb2.getText(),"/"));
					}					
				}
					
					
			}
		});

	}
	public String Oblicz(String s1, String s2, String dzialanie){
		int wynik = 0;
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
		}
		return String.valueOf(wynik);
	}
	
}

