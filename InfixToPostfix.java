import java.io.*;
/**
 * The InfixToPostfix class converts the infix expression to a postfix expression 
 * and prints them out. 
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/26/2019
 */
public class InfixToPostfix
{
    private ObjectStack stack;
    private String buf;
    private String postFix;
    private PrintWriter pw;

    /**
     * Constructor for the InfixToPostfix class. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     * @param pw, PrintWriter used to write to the output file; buf, passes the infix expression
     */
    public InfixToPostfix(PrintWriter pw, String buf){
        this.stack = new ObjectStack();
        this.buf = buf;
        this.pw = pw;
        postFix = "";

    }

    /**
     * The outInfix() prints out the infix expression. 
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void outInfix(){

        System.out.println("    Infix: " + buf);
        pw.println("    Infix: " + buf);
    }

    /**
     * The outPostfix() prints out the converted infix expression.
     * 
     * @author Samuel Aguirre, ID: 011137110
     */
    public void outPostfix(){

        System.out.println("  Postfix: " + convertInfix() );
        pw.println("  Postfix: " + convertInfix() );
    }

    /**
     * The convertedInfix() converts the infix expression into postfix notation. Utilizes a for 
     * loop that iterates through the infix expression (string), character by character. At each 
     * iteration, determines what rule to implement. 
     * 
     * @return the postfix expression
     * @author Samuel Aguirre, ID: 011137110
     */
    public String convertInfix(){

        buf = buf.replaceAll(" ", "");

        for(int i = 0; buf.length() > i; ++i){

            if(buf.charAt(i) <= '9' && buf.charAt(i) >= '0'){

                postFix += buf.charAt(i);

            }

            else if (buf.charAt(i) == '+' || buf.charAt(i) == '-' || buf.charAt(i) == '*' || buf.charAt(i) == '/' || buf.charAt(i) == '^'){ 

                while(!stack.isEmpty()){

                    if(priority((Character) stack.top()) >= priority(buf.charAt(i))){
                        postFix += (Character) stack.pop();

                    }

                    else if (priority((Character) stack.top()) <= priority(buf.charAt(i))){

                        break;
                    }
                }

                stack.push(new Character(buf.charAt(i)));
            }

            else if(buf.charAt(i) == '('){

                stack.push(new Character(buf.charAt(i)));
            }

            else if(buf.charAt(i) == ')'){

                while(!stack.isEmpty() && (Character) stack.top() != '('){

                    postFix += (Character) stack.pop();
                }

                stack.pop();
            }
        }

        //
        while(!stack.isEmpty()){

            postFix += (Character) stack.pop();
        }
        return postFix;
    }

    /**
     * Indicates what operator has higher priority
     * 
     * @return an integer value idicating the operator 
     */
    private int priority(char op){
        switch (op) {

            case '^' : return 3;
            case '*' : 
            case '/' : return 2;
            case '+' : 
            case '-' : return 1;
            default  : return 0;
        }

    }

}
