package com.github.diegopacheco.sandbox.java.netflixoss.karyon.rest;

import java.util.Stack;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.diegopacheco.sandbox.java.netflixoss.karyon.ribbon.RibbonMathClient;

@Singleton
public class CalcService {
	
	private RibbonMathClient client;
	
	@Inject
	public CalcService(RibbonMathClient client) {
		this.client = client;
	}
	
	public Double calc(String expression){
		
		if ( expression==null || ("".equals(expression)) )
			throw new IllegalArgumentException("You must pass a valid expression. ");
		
		Stack<String> stack = new Stack<String>();
		String data;
		Double firstNum;
		Double secondNum;
		Double result = 0.0;
		
		for (int i = 0; i < expression.length(); i++){
			data = expression.charAt(i) + "";
		     
		     if (" ".equals(data)) continue;
		     
		     if(data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/") || data.equals("^")){
		          switch (data){
		                case "+":
							firstNum = new Double(stack.pop());
							secondNum = new Double(stack.pop());
		                    result = client.sum(firstNum, secondNum).toBlocking().first();
		                    break;
		                case "-":
							firstNum = new Double(stack.pop());
							secondNum = new Double(stack.pop());
		                    result = client.sub(firstNum, secondNum).toBlocking().first();
		                    break;
		                case "/":
							firstNum = new Double(stack.pop());
							secondNum = new Double(stack.pop());
		                    result = client.div(firstNum, secondNum).toBlocking().first();
		                    break;
		                case "*":
							firstNum = new Double(stack.pop());
							secondNum = new Double(stack.pop());
		                    result = client.mul(firstNum, secondNum).toBlocking().first();
		                    break;
					  case "^":
						  firstNum = new Double(stack.pop());
						  secondNum = new Double(stack.pop());
						  result = client.pow(firstNum, secondNum).toBlocking().first();
						  break;
		                }
		         }else{
		             stack.push(data);
		         }
		}
		return result;
		
	}
}