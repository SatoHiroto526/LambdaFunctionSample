package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.lambda.runtime.Context;
import com.example.demo.entity.SampleEntity;
import com.example.demo.service.SampleService;

import lombok.Data;

@RestController
//inputとcontextのgetter/setterを使えるようにする。
@Data
@RequestMapping("/sample")
public class SampleController {
	
	private SampleService service;
	//Lambdaがキックするクラスで使用するために定義
	private Object input;
	private Context context;
	
	//コンストラクタインジェクション（フィールドインジェクションが使えないため）
	@Autowired
	public SampleController(SampleService service){
		this.service = service;
	}
	
	@GetMapping("/api")
	public List<SampleEntity> returnList(){
		return service.createList();
	}

}
