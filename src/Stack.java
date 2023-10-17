public class Stack {
    private Object[] stack;
    private int curIndex;
    public Stack(){
        stack = new Object[0];
        curIndex=0;
    }
    public void push(Object a){
        curIndex +=1;
        stack = append(stack, a);
    }
    private Object[] append(Object[] a, Object b){//add passed value to end of stack array
        Object[] rv = new Object[a.length + 1];
        for(int i = 0; i<=a.length-1; i++){
            rv[i] = a[i];
        }
        rv[a.length] = b;
        return rv;
    }
    public Object pop(){
        curIndex-=1;
        Object rv = stack[curIndex];
        return rv;
    }

}
