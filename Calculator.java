public class Calculator {
    static int count = 0;
    static int add(int a, int b){
        count ++;
        return (a + b);
    }
    static int sub(int a, int b){
        count++;
        return a - b;
        
    }
    static int mul(int a, int b){
        count++;
        return a * b;
    }
    static int div(int a, int b){
        count++;
        return a / b;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(Calculator.add(5,7));
        System.out.println(Calculator.sub(3,6));
        System.out.println(Calculator.mul(2,9));
        System.out.println(Calculator.div(5,2));
        System.out.println("count: "+Calculator.count);
    }

}
