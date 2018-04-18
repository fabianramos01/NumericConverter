package view;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ActionCommand;
import controller.ConstantList;
import controller.Controller;

public class PanelNumber extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public PanelNumber(Controller listener) {
		setLayout(new GridLayout(2, 1));
		add(UtilityList.createJLabel(ConstantList.TITLE, ConstantList.TITLE_FONT, ConstantList.BLUE));
		JPanel panel = new JPanel(new GridLayout(1, 2));
		textField = new JTextField();
		textField.addKeyListener(listener);
		textField.setFont(ConstantList.WORD_FONT);
		panel.add(textField);
		panel.add(UtilityList.createJButtonText(ActionCommand.COMMAND_CONVERT.getCommand(),
				ActionCommand.COMMAND_CONVERT.getTitle(), ConstantList.WHITE, ConstantList.BLUE, ConstantList.WORD_FONT,
				listener));
		add(panel);
	}

	public String getNumber() {
		return textField.getText();
	}
}