//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
  File: Calculator.java
  Exercise 16 - Calculator
  Programmer: Jeffrey Marron
  Date Created:  2.4.2017
  Last Modified: 2.4.2017

  Description: Implements a multifunction integer calculator.
  Here's how it works. All calculations are performed using
  two internal registers, the accumulator, which keeps a running
  total of ongoing calculations, and the displayRegister, which
  is set to the value displayed in the external display just
  before an operation is performed. Inputs to the calculator
  occur by pressing either digit keys, which signal that an
  integer operand is being input, and operation keys (+ - * / C =),
  which indicate that an operation should be performed.

  Control of the machine is managed by the handleKeyPress()
  method. Two internal state variables are used to control
  the machine. (1) The displayState variable keeps track of when
  a new number is being started (REPLACE) and when incoming digits
  should be APPENDed to the present value of the display. In APPEND
  mode, it appends each digit typed to the external display. In
  REPLACE mode, it replaces the external display with the digit
  typed. (2) The opCode variable stores the current operation.
  What makes control of the calculator somewhat tricky is that it
  uses INFIX notation, so operations take the form:
      Operand1 opCode Operand2
  The OpCode has to be remembered while Operand2 is being input.
  The following example shows the state of these control variables
  after each key press. The vertical lines (|)  show when each
  operation is done. For the expression 56 + 23 - 5 the calculator
  does the addition (+) after the - key is pressed. It does the
  subtraction (-) after the = key is pressed. The equal key resets
  everything but the accumulator, which always stores the present
   total. The accumulator is only reset after a Clear or an error.

    KEYPRESS:       5 6  +  |  2  3   -  |  5 =  |
    DISPLAY:      0 5 56 56 56 2  23  23 79 5    74
    DISPLAYREG:   0      56 0         23 0    5  0
    ACCUM:        0      0  56 56     56 79   79 74
    OPCODE       -1         1  1         2       -1
    DISPLAYSTATE: R A       R   A        R  A     R


  Assignment - See CalculatorGUI.java for more information
               See HINTs for more information


 */

import java.lang.*;

public class Calculator {
    public final static int NOOP = -1;  // Operations
    public final static int EQUAL = 0;
    public final static int ADD = 1;
    public final static int SUBTRACT = 2;
    public final static int MULTIPLY = 3;
    public final static int DIVIDE = 4;
    public final static int CLEAR = 5;
    public final static int SM = 6;
    public final static int RM = 7;
    public final static int CM = 8;
    public final static int X2 = 9;

    public final static int APPEND = 0; // Display states
    public final static int REPLACE = 1;

    private int Mem;
    private int accumulator; // The actual accumulator
    // Internal memory for the visible textField
    private int displayRegister;
    // The operation that's waiting for Operand2
    private int opCode;
    // State of the external display (REPLACE or APPEND)
    private int displayState;
    // Set true if divide-by-zero error
    private boolean error;

    /**
     * Calculator() constructor initializes the machine.
     */
    public Calculator () {
        initialize();
    } //END Calculator constructor

    /**
     * initialize() resets the two registers and the opCode
     * and displayState variables. This is invoked initially
     * and then after each clear (C) and after each Error.
     */
    private void initialize()  {
        // Reset the machine's registers
        accumulator = 0;
        displayRegister = 0;
        // Replace the display with the next digit typed
        displayState = REPLACE;
        opCode = NOOP; // No current operation
        error = false;
    } //END initialize()

    /**
     * keyToIntCode() converts key characters, such as '+',
     * to an integer code.
     * @return an int representing the key that was pressed
     */
    private int keyToIntCode(char keyCh) {
        switch (keyCh) {
            case 'C': return CLEAR;
            case '=': return EQUAL;
            case '+': return ADD;
            case '-': return SUBTRACT;
            case '*': return MULTIPLY;
            case '/': return DIVIDE;
            case 'S': return SM;
            case 'R': return RM;
            case ' ': return CM;//a space is used here because C case is already used for clear
            case 'x': return X2;
        }
        return -1;      // Error Return
    } //END keyToIntCode()

    /**
     * "SM", "RM", "CM", "x^2"
     * doCurrentOp() is invoked whenever C, =, +, -, *, or /
     * is pressed.  Except  for the Clear key, it performs
     * an operation, storing the result in the accumulator,
     * which is returned as the method's value. The Clear key
     * is treated as a special case and the machine is
     * reinitialized. For all other keys the opCode field
     * stores the operation that is waiting for its second
     * operand to be input. That operation is performed,
     * using the accumulator and displayRegister. After each
     * operation, the displayState is set to REPLACE, so the
     * next digit typed will start a new integer operand.
     * Note that EQUAL key, resets the opCode  to NOOP, thus
     * beginning another complete INFIX operation. All other
     * keys (+ - / *) set the opCode to their keyCodes, thus
     * getting the machine ready to complete that operation
     * the next time an operator key is pressed.
     * @param keyCode -- an int representing one of EQUAL, ADD,
     *    SUBTRACT, DIVIDE, MULT, CLEAR
     * @return an int representing the result of the calculation
     */
    private int doCurrentOp(int keyCode) { // do current opCode
        if (keyCode == CLEAR) {
            initialize();
            return accumulator;
        }
        switch (opCode) {
            case NOOP: accumulator = displayRegister; break;
            case ADD : accumulator =
                    accumulator + displayRegister; break;
            case SUBTRACT : accumulator =
                    accumulator - displayRegister; break;
            case MULTIPLY : accumulator =
                    accumulator * displayRegister; break;
            case DIVIDE :
                if (displayRegister == 0)
                    error = true;
                else
                    accumulator = accumulator/displayRegister;
                break;

            case SM:  break;//dummy case values were used for testing
            case RM:  break;
            case CM:  break;
            case X2:  break;

        } // switch
        if (keyCode == EQUAL)
            opCode = NOOP;  // Reset opCode
        else
            opCode = keyCode; // Set up for next operation
        displayState = REPLACE;
        displayRegister = 0;
        return accumulator;
    } //END doCurrentOp

    /**
     * handleKeyPress() handles all key presses. It
     * distinguishes two types of keys, digit keys, which
     * are used to create integer operands  by appending digits,
     * and opCode keys such as '+' and 'C'.
     * @return a String giving the value that should be displayed
     *     by the calculator.
     */
    public String handleKeyPress(String keyStr, String external_display) {

        String resultStr; // Stores the result

      //store memory
      if (keyStr.equals("SM")) {
			Mem = Integer.parseInt(external_display);
			resultStr = Integer.toString(Mem);
			return resultStr;//returns the result
		}
        //recall memory
		if (keyStr.equals("RM")) {
                displayState = APPEND;//sets to write over whats already displayed
                resultStr = Integer.toString(Mem);//gets value stored in Mem
                return resultStr;//returns the result
        }
        //clear memory
        if (keyStr.equals(" CM")) {
            Mem = 0;//sets value of memory to zero
            resultStr = Integer.toString(Mem); // parses to string
            return resultStr;//returns the result
        }

        if (keyStr.equals("x^2")) {
            int temp;
            temp = Integer.parseInt(external_display);//temp gets the display value
            temp = temp*temp;//temp gets its value times itself
            resultStr = Integer.toString(temp); // Return result
            return resultStr;
        }

        char keyCh = keyStr.charAt(0); // Convert the key label to a char
        if (Character.isDigit(keyCh)) { // If this was a digit key
            if (displayState == APPEND) //  either append it
                resultStr = external_display + keyCh;
            else { //  or use it to replace the display
                displayState = APPEND;
                resultStr = keyStr;
            }
        } else { // If not a digit key, it must be an opCode
            // Get display value
            displayRegister = Integer.parseInt(external_display);
            // Perform an operation
            int result = doCurrentOp(keyToIntCode(keyCh));
            if (!error)
                resultStr = Integer.toString(result); // Return result
            else {
                resultStr = "Error";
                initialize();
            }
        }
        return resultStr;  // return the result
    } //END handleKeyPress()

} //END Calculator Class