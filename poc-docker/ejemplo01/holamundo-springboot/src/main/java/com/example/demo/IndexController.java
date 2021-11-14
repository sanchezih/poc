package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	@GetMapping("/")
	@ResponseBody
	public String holaMundo() {
		System.out.println("Entrando al metodo holaMundo...");
		return "Hola mundo!";
	}
}