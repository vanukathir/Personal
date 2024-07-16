public class StackUsingArray {
    int top = -1;
    public static void main(String[] args){
        StackUsingArray stack = new StackUsingArray();
        int size = 5;
        int[] arr = new int[size];

        stack.push(arr,stack.top,10);
        stack.push(arr,stack.top,11);
        stack.push(arr,stack.top,15);
        int val = stack.pop(arr,stack.top);
        System.out.println("popped element:"+val);
    }

    int pop(int[] arr,int top){
        if(top == -1){
            System.out.println("stack is underflow");
        }else{
            int val = arr[top];
            top--;

            return val;
        }
        return -1;
    }
    void push(int[] arr,int top,int val){
        top++;
        if(top == arr.length){
              System.out.println("Stack overflow");

        }else{
            arr[top] = val;
        }
    }
}
