package model;

import javax.swing.JOptionPane;

import controller.ConstantList;

public class ManagerCon {

	private String [] convertBases;
	
	public ManagerCon() {
		convertBases = new String[2];
		convertBases[0] = "";
		convertBases[1] = "";
	}
	
	public String convert(String number) {
		if (!convertBases[0].equals("") && !convertBases[1].equals("")) {
			if (convertBases[0].equals(ConstantList.BINARY)) {
				return binaryTo(number);
			} else if (convertBases[0].equals(ConstantList.DECIMAL)) {
				return decimalTo(number);
			} else if (convertBases[0].equals(ConstantList.OCTAL)) {
				return octalTo(number);
			} else if (convertBases[0].equals(ConstantList.HEXADECIMAL)) {
				return hexadecimalTo(number);
			}
		}
		return "";
	}

	private String hexadecimalTo(String number) {
		if (convertBases[1].equals(ConstantList.BINARY)) {
			return hexaToBinary(number);
		} else if (convertBases[1].equals(ConstantList.DECIMAL)) {
			return String.valueOf(hexaToDecimal(number));
		} else if (convertBases[1].equals(ConstantList.OCTAL)) {
			return hexaToOctal(number);
		}
		return number;
	}

	private String octalTo(String number) {
		if (convertBases[1].equals(ConstantList.BINARY)) {
			return octalToBinary(number);
		} else if (convertBases[1].equals(ConstantList.DECIMAL)) {
			return String.valueOf(octalToDecimal(number));
		} else if (convertBases[1].equals(ConstantList.HEXADECIMAL)) {
			return octalToHexa(number);
		}
		return number;
	}

	private String decimalTo(String number) {
		if (convertBases[1].equals(ConstantList.BINARY)) {
			return decimalToBinary(number);
		} else if (convertBases[1].equals(ConstantList.HEXADECIMAL)) {
			return decimalToHexa(number);
		} else if (convertBases[1].equals(ConstantList.OCTAL)) {
			return decimalToOctal(number);
		}
		return number;
	}

	private String binaryTo(String number) {
		if (convertBases[1].equals(ConstantList.HEXADECIMAL)) {
			return binaryToHexa(number);
		} else if (convertBases[1].equals(ConstantList.DECIMAL)) {
			return String.valueOf(binaryToDecimal(number));
		} else if (convertBases[1].equals(ConstantList.OCTAL)) {
			return String.valueOf(binaryToOctal(number));
		}
		return number;
	}

	public String decimalToBinary(String decimal) {
		try {
			int num = Integer.parseInt(decimal);
			return Integer.toBinaryString(num);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}

	public String binaryToDecimal(String binary) {
		try {
			Integer num = Integer.valueOf(binary, 2);
			return String.valueOf(num.intValue());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}

	public String binaryToOctal(String binary) {
		try {
			int num = Integer.valueOf(binary, 2);
			return Integer.toOctalString(num);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public String binaryToHexa(String binary) {
		try {
			int num = Integer.valueOf(binary, 2);
			return Integer.toHexString(num);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public String decimalToHexa(String decimal) {
		try {
			int num = Integer.parseInt(decimal);
			return Integer.toHexString(num);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public String decimalToOctal(String decimal) {
		try {
			int num = Integer.parseInt(decimal);
			return Integer.toOctalString(num);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public int octalToDecimal(String octal) {
		try {
			Integer num = Integer.valueOf(octal, 8);
			return num.intValue();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return 0;
	}
	
	public String octalToBinary(String octal) {
		try {
			Integer num = Integer.valueOf(octal, 8);
			return Integer.toBinaryString(num.intValue());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public String octalToHexa(String octal) {
		try {
			Integer num = Integer.valueOf(octal, 8);
			return Integer.toHexString(num.intValue());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public int hexaToDecimal(String hexa) {
		try {
			Integer num = Integer.valueOf(hexa, 16);
			return num.intValue();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return 0;
	}
	
	public String hexaToBinary(String hexa) {
		try {
			Integer num = Integer.valueOf(hexa, 16);
			return Integer.toBinaryString(num.intValue());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}

	public String hexaToOctal(String hexa) {
		try {
			Integer num = Integer.valueOf(hexa, 16);
			return Integer.toOctalString(num.intValue());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return "0";
	}
	
	public void setFirstBase(String firstBase) {
		convertBases[0] = firstBase;
	}
	
	public void setSecondBase(String secondBase) {
		convertBases[1] = secondBase;
	}
	
	public void resetBases() {
		convertBases[0] = "";
		convertBases[1] = "";
	}
}