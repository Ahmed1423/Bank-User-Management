package com.wellsfargo.batch2Group2.BankUserManagement.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ServiceUtils {
	
	public static <T> String convertJava2JSON(T t) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule()); 

		return mapper.writeValueAsString(t);
	}

}
