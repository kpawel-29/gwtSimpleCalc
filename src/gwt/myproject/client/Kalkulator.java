package gwt.myproject.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Kalkulator implements EntryPoint {
	
	Button sendButton = new Button("Send");
	Label nameField  = new Label();
	int count = 0;
	
	public void onModuleLoad() {
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("nameFieldContainer").add(nameField);
		
		sendButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				nameField.setText("klinkniecie nr: "+ ++count);
				
			}
		});

	}
}
