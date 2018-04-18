package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import model.ManagerCon;
import view.PrincipalFrame;

public class Controller implements ActionListener, KeyListener {

	private ManagerCon managerCon;
	private PrincipalFrame pFrame;

	public Controller() {
		managerCon = new ManagerCon();
		pFrame = new PrincipalFrame(this);
	}

	public void convert() {
		if (!pFrame.getNumber().equals("")) {
			String num = managerCon.convert(pFrame.getNumber());
			if (!num.equals("")) {
				pFrame.setResult(num);
			} else {
				errorMessage(ConstantList.ERROR_SELECTED);
			}
			managerCon.resetBases();
		} else {
			errorMessage(ConstantList.MISSING_INFO);
		}

	}

	private void errorMessage(String error) {
		JOptionPane.showMessageDialog(null, error, ConstantList.ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand().toString();
		if (command.substring(0, 1).equals("d")) {
			managerCon.setFirstBase(command.substring(1, command.length()));
			pFrame.setSelection(command);
		} else if (command.substring(0, 1).equals("a")) {
			managerCon.setSecondBase(command.substring(1, command.length()));
			pFrame.setSelection(command);
		} else {
			switch (ActionCommand.valueOf(e.getActionCommand())) {
			case COMMAND_CONVERT:
				convert();
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			convert();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
