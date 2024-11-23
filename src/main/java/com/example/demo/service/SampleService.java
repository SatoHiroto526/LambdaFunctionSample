package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.constant.DataConf;
import com.example.demo.entity.SampleEntity;

@Service
public class SampleService {
	
	public List<SampleEntity> createList(){
		List<SampleEntity> list = new ArrayList<>();
		
		SampleEntity entity1 = new SampleEntity();
		SampleEntity entity2 = new SampleEntity();
		SampleEntity entity3 = new SampleEntity();
		SampleEntity entity4 = new SampleEntity();
		
		entity1.setNo(DataConf.no1);
		entity1.setMs(DataConf.ms1);
		entity2.setNo(DataConf.no2);
		entity2.setMs(DataConf.ms2);
		entity3.setNo(DataConf.no3);
		entity3.setMs(DataConf.ms3);
		entity4.setNo(DataConf.no4);
		entity4.setMs(DataConf.ms4);
		
		list.add(entity1);
		list.add(entity2);
		list.add(entity3);
		list.add(entity4);
		
		return list;
	}

}
