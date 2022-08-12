package com.microservice.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consume {

	private Integer id;
	private String name;
	private String addr;
}
