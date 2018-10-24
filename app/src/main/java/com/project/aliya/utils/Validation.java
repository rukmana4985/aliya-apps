package com.project.aliya.utils;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by faizf on 4/13/2017.
 */

public class Validation {
    private static final String EMAIL_ERROR = "Masukkan Email yang valid";
    private static final String INPUT_ERROR = "Kolom ini harus diisi";
    private static final String INPUT_MIN_ERROR = "Kolom ini harus diisi minimal ";
    private static final String INPUT_NOTES = "Harap berikan catatan untuk memudahkan driver";
    private static final String CHARACTER = " karakter";
    private static final String PASSWORD_NOT_SAME = "Kata Kunci yang dimasukkan tidak sama";

    public static boolean checkEmail(EditText editText) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = editText.getText().toString();
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (editText.getText().toString().equals("") && editText.getText().length() == 0) {
            editText.setError(INPUT_ERROR);
            return false;
        } else {
            if (matcher.matches()) {
                return true;
            } else {
                editText.setError(EMAIL_ERROR);
                editText.requestFocus();
                return false;
            }

        }
    }

    public static boolean checkEdittext(EditText editText) {
        if (editText.getText().toString().equals("") && editText.getText().length() == 0) {
            editText.setError(INPUT_ERROR);
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkNotes(EditText editText) {
        if (editText.getText().toString().equals("") && editText.getText().length() == 0) {
            editText.setError(INPUT_NOTES);
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkLength(EditText editText, int min) {
        if (editText.getText().toString().equals("") || editText.getText().length() < min || editText.getText().length() == 0) {
            editText.setError(INPUT_MIN_ERROR + String.valueOf(min) + CHARACTER);
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkPasswordSame(EditText password, EditText passwordConfirm){
        if (!password.getText().toString().equals(passwordConfirm.getText().toString())) {
            passwordConfirm.setError(PASSWORD_NOT_SAME);
            passwordConfirm.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}
