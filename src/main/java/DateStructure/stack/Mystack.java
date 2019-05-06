package DateStructure.stack;

import java.util.Iterator;
import java.util.Stack;

public class Mystack {
    public static void main(String[] args) {

        //堆栈实现字符串逆序

        Stack stack=new Stack();
        String string="Hello World!";
        char[] chars=string.toCharArray();
        for(char c:chars){
            stack.push(c);
        }
        Iterator iterable=stack.iterator();
        while (iterable.hasNext()){
            System.out.print(iterable.next()+" ");
        }
        System.out.println();
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
