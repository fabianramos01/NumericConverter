package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ActionCommand;
import controller.ConstantList;

public class PanelNumber extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public PanelNumber(ActionListener listener) {
		setLayout(new GridLayout(2, 1));
		add(UtilityList.createJLabel(ConstantList.TITLE, ConstantList.TITLE_FONT, ConstantList.BLUE));
		JPanel panel = new JPanel(new GridLayout(1, 2));
		textField = new JTextField();
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

	public void setText() {
		textField.setText("");
	}
}