package xyz.cloorc.example.springboot.po;

import lombok.Data;

@Data
public class Example {

	private Long id;
	private String name;
	private Integer age;
	
	public Example(Long id, String name, Integer age) {
	    this.id = id;
	    this.name = name;
	    this.age = age;
	}
}
