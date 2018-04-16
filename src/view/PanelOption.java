package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ConstantList;

public class PanelOption extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton[] jButtons;
	
	public PanelOption(ActionListener listener) {
		setLayout(new GridLayout(1, 3));
		jButtons = new JButton[8];
		add(createPanel("d", listener));
		add(UtilityList.createJLabel(ConstantList.A_SEPARATOR, ConstantList.TITLE_FONT, ConstantList.BLUE));
		add(createPanelTo("a", listener));
	}

	private JPanel createPanel(String init, ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		jButtons[0] = UtilityList.createJButtonText(init + ConstantList.DECIMAL, ConstantList.DECIMAL,
				ConstantList.BLACK, ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		jButtons[1] = UtilityList.createJButtonText(init + ConstantList.BINARY, ConstantList.BINARY, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		jButtons[2] = UtilityList.createJButtonText(init + ConstantList.OCTAL, ConstantList.OCTAL, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		jButtons[3] = UtilityList.createJButtonText(init + ConstantList.HEXADECIMAL, ConstantList.HEXADECIMAL,
				ConstantList.BLACK, ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		panel.add(jButtons[0]);
		panel.add(jButtons[1]);
		panel.add(jButtons[2]);
		panel.add(jButtons[3]);
		return panel;
	}

	private JPanel createPanelTo(String init, ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(4, 1));
		jButtons[4] = UtilityList.createJButtonText(init + ConstantList.DECIMAL, ConstantList.DECIMAL,
				ConstantList.BLACK, ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		jButtons[5] = UtilityList.createJButtonText(init + ConstantList.BINARY, ConstantList.BINARY, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		jButtons[6] = UtilityList.createJButtonText(init + ConstantList.OCTAL, ConstantList.OCTAL, ConstantList.BLACK,
				ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		jButtons[7] = UtilityList.createJButtonText(init + ConstantList.HEXADECIMAL, ConstantList.HEXADECIMAL,
				ConstantList.BLACK, ConstantList.WHITE, ConstantList.WORD_FONT, listener);
		panel.add(jButtons[4]);
		panel.add(jButtons[5]);
		panel.add(jButtons[6]);
		panel.add(jButtons[7]);
		return panel;
	}
	
	public void setSelection(String command) {
		for (int i = 0; i < jButtons.length; i++) {
			if (jButtons[i].getActionCommand().equals(command)) {
				if (i < 4) {
					resetSelection(0, 4);
				} else {
					resetSelection(4, jButtons.length);
				}
				jButtons[i].setForeground(ConstantList.BLUE);
				break;
			}
		}
	}
	
	public void resetSelection(int init, int length) {
		for (int i = init; i < length; i++) {
			jButtons[i].setForeground(ConstantList.BLACK);
		}
	}
}