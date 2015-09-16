package examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {	
	private void initialiseButtons(){
		JButton okButton = new JButton();
		okButton.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				submitForm();
			}
		});
		
		JButton cancelButton = new JButton();
		cancelButton.addActionListener( event -> cleanUpAndExit());
	}
	
	private void submitForm(){ return;}
	private void cleanUpAndExit() { return;}
}
