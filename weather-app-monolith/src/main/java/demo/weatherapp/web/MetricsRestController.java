package demo.weatherapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsRestController {

	@GetMapping(value="/ats-metrics") 
	public Test getMetrics() {
		System.out.println("request received...");
		
		Test test = new Test();
		test.setAge(22l);
		return test;
	}
	
}

class Test {
	private Long age;
	
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
}