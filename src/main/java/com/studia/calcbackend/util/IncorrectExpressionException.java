package com.studia.calcbackend.util;

import java.util.HashMap;

/**
 * Exception thrown by JShellApi in case of error during expression execution
 */
@SuppressWarnings("serial")
public class IncorrectExpressionException extends Exception {
    /**
     * Map storing exception messages to be converted
     */
    private HashMap<String, String> exceptionsLocale = new HashMap<String,String>();

    public IncorrectExpressionException(String e) {
        super(e);
	exceptionsLocale.put("/ by zero", "Attempted to divide by zero");
    }

    /**
     * Convert exception text to more user-friendly form
     * @return converted exception message
     */
    @Override
    public String getMessage() {
        String exceptionReason = exceptionsLocale.get(super.getMessage());
        if (exceptionReason != null)
            return exceptionReason;
        else
            return super.getMessage();
    }
}
