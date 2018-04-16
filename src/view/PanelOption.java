package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.ConstantList;

public class PanelOption extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelOption(ActionListener listener) {
		setLayout(new GridLayout(1, 3));
		add(createPanel("d", listener));
		add(UtilityList.createJLabel(ConstantList.A_SEPARATOR, ConstantList.TITLE_FONT, ConstantList.BLUE));
		add(createPanel("a", listener));
	}
	
	private JPanel createPanel(String init, ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		panel.add(UtilityList.createJButtonText(init + ConstantList.DECIMAL, ConstantList.DECIMAL, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener));
		panel.add(UtilityList.createJButtonText(init + ConstantList.BINARY, ConstantList.BINARY, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener));
		panel.add(UtilityList.createJButtonText(init + ConstantList.OCTAL, ConstantList.OCTAL, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener));
		panel.add(UtilityList.createJButtonText(init + ConstantList.HEXADECIMAL, ConstantList.HEXADECIMAL,
				ConstantList.BLACK, ConstantList.WHITE, ConstantList.WORD_FONT, listener));
		return panel;
	}
}