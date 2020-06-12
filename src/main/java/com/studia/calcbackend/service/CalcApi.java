package com.studia.calcbackend.service;

import com.studia.calcbackend.util.IncorrectExpressionException;


/**
 * JShell API frontend
 */
public class CalcApi {

    /**
     * Convert input argument to valid form for JShell
     * <br> It is used to make sure that all input number for API are integers - otherwise, result of some operations could be invalid (for instance: (int) 5 / (int) 2 == 2)
     * @param arg string representing input number
     * @return argument suitable to use with executeExpression method
     */
    static private String parseArgument(String arg) {
        if (arg.equals(""))
            arg = "0";
        else if (!arg.equals("0") && !arg.contains("."))
            arg += ".0";
        return arg;
    }

    /**
     * Convert result of JShell expression to user friendly form
     * <br> In particular: remove unnecessary precision, negative zero.
     * @param result string containing JShell API result
     * @return user friendly form of provided argument
     */
    static private String parseResult(String result) {
        if (result.endsWith(".0"))
            result = result.substring(0, result.length() - 2);
        if (result.equals("-0"))
            result = "0";
        System.out.println(" > \"" + result + "\"");
        return result;
    }

    /**
     * Execute expression of form func(arg)
     * @param arg string representing function argument
     * @param func id of function to be invoked
     * @return value of provided expression
     * @throws IncorrectExpressionException It is thrown in case of computation errors
     */
    static public String executeOneArgExpr(String arg, String func) throws IncorrectExpressionException {
    	try {
	    	double aArg = Double.parseDouble(parseArgument(arg));
	    	String result = "";
	
	        switch(func) {
	        case "sqrt":
	        	result = Double.toString(Math.sqrt(aArg));
	        	break;
	        case "cbrt":
	        	result = Double.toString(Math.cbrt(aArg));
	        	break;
	        case "exp":
	        	result = Double.toString(Math.exp(aArg));
	        	break;
	        default:
	        	throw new IncorrectExpressionException("Invalid function");
	        }
	    	
	    	return parseResult(result);
    	} catch(Exception e) {
    		throw new IncorrectExpressionException(e.getMessage());
    	}
    }

    /**
     * Execute expression of form 1st_arg operator second_arg
     * @param first
     * @param operator
     * @param second
     * @return value of provided expression
     * @throws IncorrectExpressionException It is thrown in case of computation errors
     */
    static public String executeTwoArgsExpr(String first, String operator, String second) throws IncorrectExpressionException {
    	try {
	    	double aFirst = Double.parseDouble(parseArgument(first));
	    	double aSecond = Double.parseDouble(parseArgument(second));
	    	String result = "";
	
	        switch(operator) {
	        case "+":
	        	result = Double.toString(aFirst + aSecond);
	        	break;
	        case "-":
	        	result = Double.toString(aFirst - aSecond);
	        	break;
	        case "*":
	        	result = Double.toString(aFirst * aSecond);
	        	break;
	        case "/":
	        	result = Double.toString(aFirst / aSecond);
	        	break;
	        default:
	        	throw new IncorrectExpressionException("Invalid operator");
	        }
	    	
	        if(result == "NaN" || result == "Infinity" || result == "-Infinity")
	        	throw new IncorrectExpressionException("Invalid arguments were provided");
	        
	    	return parseResult(result);
    	} catch(Exception e) {
    		throw new IncorrectExpressionException(e.getMessage());
    	}
    }
}