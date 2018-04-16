package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ConstantList;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelNumber panelNumber;
	private JLabel labelResult;

	public PrincipalFrame(ActionListener listener) {
		setTitle(ConstantList.TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON)).getImage());
		setSize(ConstantList.WIDTH, ConstantList.HEIGHT);
		panelNumber = new PanelNumber(listener);
		add(panelNumber, BorderLayout.NORTH);
		add(new PanelOption(listener), BorderLayout.CENTER);
		result();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void result() {
		labelResult = UtilityList.createJLabel(ConstantList.RESULT, ConstantList.WORD_FONT, ConstantList.BLUE);
		add(labelResult, BorderLayout.SOUTH);
	}
	
	public void setResult(String number) {
		labelResult.setText(ConstantList.RESULT + number);
		panelNumber.setText();
		repaint();
	}
	
	public String getNumber() {
		return panelNumber.getNumber();
	}
}