package exceptionStack;

public class StackTest
{
    public static void main( String[] arg){
        Stack s = new Stack();
        System.out.println("Stack is created\n");

        // piece of code to test our exception mechanism
        try {
            s.pop();
        } catch (StackException e) {
            System.out.println("Exception thrown: " + e);
        }

        s.push(10); s.push(3); s.push(11); s.push(7);
        s.display();

        System.out.println("Stack sixe is " + s.size());

       /* int i = s.pop();
        System.out.println("Just popped " + i);
        s.display();
        */
    }
}
