package com.tsystems.javaschool.tasks.calculator;



import java.util.Stack;

public class Calculator {
    Stack<Double> stack = new Stack<>();
    String postfix;

    public Calculator() {
        stack = new Stack<>();
        postfix = "";
    }


    public String evaluate(String statement) {
        if(statement==null)return null;
        InToPost convertor = new InToPost(statement);
        postfix = convertor.doTrans();
        double val;
        double tmpResult = 0;
        double num1, num2;
        if(postfix.isEmpty()) return null;
        String[] tmp = postfix.split(" ");
        for(int j=0; j<tmp.length; j++){
            if(tmp[j].isEmpty())
                return null;
            if(!tmp[j].equals("+") && !tmp[j].equals("-") &&
                    !tmp[j].equals("*") && !tmp[j].equals("/")){
                try{
                    val = Double.valueOf(tmp[j]);
                }catch(NumberFormatException ex){
                    return null;
                }
                stack.push(val);
            }else{
                num2 = Double.valueOf(stack.pop());
                num1 = Double.valueOf(stack.pop());
                if(tmp[j].equals("+")){
                    tmpResult = num1 + num2;
                }
                if(tmp[j].equals("-")){
                    tmpResult = num1 - num2;
                }
                if(tmp[j].equals("*")){
                    tmpResult = num1 * num2;
                }
                if(tmp[j].equals("/")){
                    if(num2 == 0)
                        return null;
                    tmpResult = num1 / num2;
                }
                stack.push(tmpResult);
            }
        }
        int result=(int)tmpResult;
        if(tmpResult-result!=0)return String.format("%.4f",tmpResult);
        return String.valueOf(result);
    }

}
