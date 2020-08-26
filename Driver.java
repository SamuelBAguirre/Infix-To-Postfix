import java.io.*;
import java.util.Scanner;
/**
 * Driver class implements the other class running the program. 
 *
 * @author Samuel Aguirre, ID: 011137110
 * @version 9/26/2019
 */
public class Driver
{
    public static void main (String[] args ) throws IOException {

        Scanner fileScan = new Scanner(new File("infix.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));

        while(fileScan.hasNext()){
            String buf = fileScan.nextLine();

            CheckInfix check = new CheckInfix(buf);

            
            if(check.validateOperator() == false){
                System.out.println("[Error] - Adjacent Oprators: " + check.getCheckBuf() + "\n");
                pw.println("[Error] - Adjacent Oprators: " + check.getCheckBuf() + "\n");
            }
            else if(check.validateOperand() == false){

                System.out.println("[Error] - Adjacent Oprands: " + check.getCheckBuf() + "\n");
                pw.println("[Error] - Adjacent Oprands: " + check.getCheckBuf() + "\n");

            }
            else if (check.leftParen() == false){

                System.out.println("[Error] - Missing Parenthesis: " + check.getCheckBuf() + "\n");
                pw.println("[Error] - Missing Parenthesis: " + check.getCheckBuf() + "\n");
            }
            else if (check.rightParen() == false){

                System.out.println("[Error] - Extra Parenthesis: " + check.getCheckBuf() + "\n");
                pw.println("[Error] - Extra Parenthesis: " + check.getCheckBuf() + "\n");
            }
            else {
                InfixToPostfix expression = new InfixToPostfix(pw, buf);
                expression.outInfix();
                expression.outPostfix();

                String postf = expression.convertInfix();
                EvalPostfix evalExpression = new EvalPostfix(pw, postf);
                evalExpression.outEvaluate();

            }

        }
        fileScan.close();
        pw.close();
    }
}
