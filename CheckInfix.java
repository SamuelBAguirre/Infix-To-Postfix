
/**
 * The CheckInfix class determines the validity of an infix expression. 
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/26/2019
 */
public class CheckInfix
{
    private String checkBuf;
    private ObjectStack operandCheck;
    private ObjectStack operatorCheck;

    /**
     * Constructor for objects of class CheckInfix
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param s, passes the infix expression 
     */
    public CheckInfix(String s)
    {
        checkBuf = s;
        this.operandCheck = new ObjectStack();
        this.operatorCheck = new ObjectStack();
    }

    /**
     * The leftParen() uses a for loop to iterate through checkBuf, incremnets 
     * two local varaibles. Increments one varaible(ex. left) if charAt(i) is equal to a left parenthese,
     * incremnets another local varaible(ex. right) if at charAt(i) is equal to a right parenthese. Uses 
     * boolean data type to indicate if left is greater than right, or vice versa in order to validate 
     * the infix expression.  
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return true if valid infix expression, false if invalid infix expression
     */
    public boolean leftParen(){

        int left = 0;
        int right = 0;
        checkBuf = checkBuf.replaceAll(" ", "");
        for (int i = 0; i < checkBuf.length(); ++i){

            if(checkBuf.charAt(i) == '('){
                ++left;
            }
            else if(checkBuf.charAt(i) == ')'){

                ++right;
            }

        }

        if (left > right){

            return false;   
        }

        return true;
    }

    /**
     * The rightParen() uses a for loop to iterate through checkBuf, incremnets 
     * two local varaibles. Increments one varaible(ex. left) if charAt(i) is equal to a left parenthese,
     * incremnets another local varaible(ex. right) if at charAt(i) is equal to a right parenthese. Uses 
     * boolean data type to indicate if left is greater than right, or vice versa in order to validate 
     * the infix expression. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return true if valid infix expression, false if invalid infix expression
     */
    public boolean rightParen(){

        int left = 0;
        int right = 0;
        checkBuf = checkBuf.replaceAll(" ", "");
        for (int i = 0; i < checkBuf.length(); ++i){

            if(checkBuf.charAt(i) == '('){
                ++left;
            }
            else if(checkBuf.charAt(i) == ')'){

                ++right;
            }

        }

        if (left < right){

            return false;   
        }  

        return true;   
    }

    /**
     * The validateOperand() determines if the infix expression has adjacent operands.
     * Uses a for loop to iterate through checkBuf, pushes charAt(i) onto operandCheck. 
     * Then uses a conditional statements to determine if the top of the stack and the 
     * next character in checkBuf are operands. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return true if valid infix expression, false if invalid infix expression
     */
    public boolean validateOperand(){

        char nextChar;
        char topStack;
        checkBuf = checkBuf.replaceAll(" ", "");

        for (int i = 0; i < checkBuf.length()-1; ++i){

            nextChar = checkBuf.charAt(i+1);
            operandCheck.push(new Character(checkBuf.charAt(i)));
            topStack = (Character) operandCheck.top();

            if ( topStack <= '9' && topStack >= '0'){

                if (nextChar <= '9' && nextChar >= '0'){

                    return false;
                }

            }

        }

        return true;
    }

    /**
     * The validateOperator() determines if the infix expression has adjacent operator.
     * Uses a for loop to iterate through checkBuf, pushes charAt(i) onto operatorCheck. 
     * Then uses a conditional statements to determine if the top of the stack and the 
     * next character in checkBuf are operators.
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return true if valid infix expression, false if invalid infix expression
     */
    public boolean validateOperator(){

        char nextChar;
        char topStack;
        checkBuf = checkBuf.replaceAll(" ", "");

        for (int i = 0; i < checkBuf.length()-1; ++i){

            nextChar = checkBuf.charAt(i+1);
            operatorCheck.push(new Character(checkBuf.charAt(i)));
            topStack = (Character) operatorCheck.top();

            if(topStack == '+' ||topStack == '-' || topStack == '*' || topStack == '/' || topStack == '^'){
                if (nextChar == '+' || nextChar == '-' || nextChar == '*' || nextChar == '/' || nextChar == '^'){

                    return false;
                }

            }
        }

        return true;
    }

    /**
     * getCheckBuf() returns the infix expression after it has been validated
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return the infix expression
     */
    public String getCheckBuf(){

        return checkBuf;

    }
}
