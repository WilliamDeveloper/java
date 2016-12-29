package br.com.core.android.util;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;

public abstract class Mask {

	public static final String CPF = "###.###.###-##";
	public static final String DATE = "##/##/####";
	public static final String PHONE = "(##)####-####";
	public static final String NO_MASK = "";

	public static String unmask(String s) {
		return s.replaceAll("[_]", "")
                        .replaceAll("[-]", "")
                        .replaceAll("[.]", "")
                        .replaceAll("[/]", "")
                        .replaceAll("[%]", "")
                        .replaceAll("[R$]", "")
                        .replaceAll("[ ]", "")
                        .replaceAll("[(]", "")
                        .replaceAll("[)]", "");
	}

	public static TextWatcher insert(final String mask, final EditText ediTxt) {
		return new TextWatcher() {
			boolean isUpdating;
			String old = "";

			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				String str = Mask.unmask(s.toString());
				String mascara = "";
				if (isUpdating) {
					old = str;
					isUpdating = false;
					return;
				}
				int i = 0;
				for (char m : mask.toCharArray()) {
					if (m != '#' && str.length() > old.length()) {
						mascara += m;
						continue;
					}
					try {
						mascara += str.charAt(i);
					} catch (Exception e) {
						break;
					}
					i++;
				}
				isUpdating = true;
				ediTxt.setText(mascara);
				ediTxt.setSelection(mascara.length());
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
										  int after) {
			}

			public void afterTextChanged(Editable s) {
			}
		};
	}

	public static TextWatcher customMask(final String mask, final EditText ediTxt) {
		return new TextWatcher() {
			boolean isUpdating;
			String old = "";

			public void onTextChanged(CharSequence s, int start, int before,
									  int count) {
				String str = s.toString().replaceAll("[.]", "").replaceAll("[-]", "")
						.replaceAll("[/]", "").replaceAll("[(]", "")
						.replaceAll("[)]", "").replaceAll(" ", "");
				String mascara = "";
				if (isUpdating) {
					old = str;
					isUpdating = false;
					return;
				}
				int i = 0;

				for (char m : mask.toCharArray()) {
					if (m != '#' && m != '&') {
						mascara += m;
						continue;
					}

					try {
						if (m == '#' && !Character.isDigit(str.charAt(i))){
							break;
						}

						if (m == '&' && Character.isDigit(str.charAt(i))){
							break;
						}

						mascara += str.charAt(i);
					} catch (Exception e) {
						break;
					}
					i++;
				}

				if (str.length() <= old.length()){
					while (mascara.length() > 0 && !Character.isDigit(mascara.charAt(mascara.length()-1)) && !Character.isLetter(mascara.charAt(mascara.length()-1)))
						mascara = mascara.substring(0, mascara.length()-1);

				}
				isUpdating = true;
				ediTxt.setText(mascara.toUpperCase());
				ediTxt.setSelection(mascara.length());
			}

			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			public void afterTextChanged(Editable s) {
				if(s.length() > 3) {
					ediTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
				}
			}
		};
	}
}