import java.io.*;
/**
 * The EvalPostfix class evaluates the postfix expression 
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/26/2019
 */
public class EvalPostfix
{
    // instance variables 
    private String postFix;
    private int numberTotal;
    private ObjectStack stack2;
    private PrintWriter pw;
    /**
     * Constructor for objects of class EvalPostfix
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param pw, PrintWriter used to write to the output file; c, passes the infix expression
     */
    public EvalPostfix(PrintWriter pw, String c)
    {
        // initialise instance variables

        this.stack2 = new ObjectStack();
        postFix = c;
        this.pw = pw;
    }

    /**
     * The evaluatedPost() uses a for loop to iterate through the postfix expression(string),
     * if charAt(i) equals an operator,the operator is then pushed on the stack. If at charAt(i) 
     * is equal to an operator, the stack is then popped and evaluated using the operator. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @return integer value of the evaluated postfix expression. 
     */
    private int evaluatePost(){

        int pop1 = 0;
        int pop2 = 0;
        int push1 = 0;
        int power = 0;

        for(int i = 0; i < postFix.length(); ++i){

            if (postFix.charAt(i) <= '9' && postFix.charAt(i) >= '0'){

                
                stack2.push(new Integer(postFix.charAt(i)-'0'));
            }

            else if (postFix.charAt(i) == '+' && !stack2.isEmpty()){

                pop1 = (Integer) stack2.pop();
                pop2 = (Integer) stack2.pop();

                stack2.push(new Integer(pop2 + pop1));
            }

            else if (postFix.charAt(i) == '-' && !stack2.isEmpty()){

                pop1 = (Integer) stack2.pop();
                pop2 = (Integer) stack2.pop();

                stack2.push(new Integer(pop2 - pop1));
            }

            else if (postFix.charAt(i) == '*' && !stack2.isEmpty()){

                pop1 = (Integer) stack2.pop();
                pop2 = (Integer) stack2.pop();

                stack2.push(new Integer(pop2 * pop1));
            }

            else if (postFix.charAt(i) == '/' && !stack2.isEmpty()){

                pop1 = (Integer) stack2.pop();
                pop2 = (Integer) stack2.pop();

                stack2.push(new Integer(pop2 / pop1));
            }

            else if (postFix.charAt(i) == '^' && !stack2.isEmpty()){

                pop1 = (Integer) stack2.pop();
                pop2 = (Integer) stack2.pop();

                power = (int) Math.pow(pop2, pop1);

                stack2.push(new Integer(power));

            }
        }

        return (Integer) stack2.pop();
    }

    /**
     * The outEvaluate() expression prints out the evaluated postfix expression 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void outEvaluate(){

        System.out.println("Evaluated: " + evaluatePost() + "\n");  
        pw.println("Evaluated: " + evaluatePost() + "\n");
    }
}
