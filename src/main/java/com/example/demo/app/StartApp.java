package com.example.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.demo.controller.SampleController;

import lombok.Data;

@SpringBootApplication
@Data
//LambdaがSpringBootアプリケーションを起動する際にキックするクラス
//RequestHandlerをimplements
public class StartApp implements RequestHandler<Object, Object> {
	
	//RequestHandlerのメソッド
	@Override
	public Object handleRequest(Object input, Context context) {
		String args[] = new String[0];
		
		try(ConfigurableApplicationContext ctx = SpringApplication.run(SampleController.class, args)) {
			SampleController app = ctx.getBean(SampleController.class);
			app.setInput(input);
			app.setContext(context);
			Object result = app.returnList();
			return result;
		}catch(Exception e) {
			return "error.";
		}
	}

}
