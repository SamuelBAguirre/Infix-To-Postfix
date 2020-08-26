
/**
 * ObjectStack Class
 *
 * @author Richard Stegman 
 * @version 9/27/2019
 */
public class ObjectStack implements ObjectStackInterface
{

    private Object[] item;
    private int top;

    /**
     * Constructor for the ObjectStack Class
     */
    public ObjectStack(){

        item = new Object[1];
        top = -1;

    }

    /**
     * Determines if the stack is empty
     * 
     * @return true if stack is empty, false if the stack is not empty
     */
    public boolean isEmpty(){

        return top == -1;

    }

    /**
     * Determines if the stack is full
     * 
     * @return true if stack is full, false if the stack is not full
     */
    public boolean isFull() {
        return top == item.length-1;
    }

    /**
     * Removes all elements from the ObjectStack  
     * 
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }

    /**
     * Pushes an object onto the ObjectStack
     * 
     * @param o, the object that is pushed onto the stack
     */
    public void push(Object o) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = o;
    }

    /**
     * Resizes the array once it is half full
     * 
     * @param size, the size the array 
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }

    /**
     * Returns the top object of the stack by removing
     * the top element of the Objectstack 
     * 
     * @return the top object of the Objectstack
     */
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }

    /**
     * Returns the top object of the stack but does not remove 
     * the top object of the stack. 
     * 
     * @return the top object of the Objectstack
     */
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }    
        return item[top];
    }
}

