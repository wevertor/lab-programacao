package com.trindade.labprog.calc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Calculadora {
	
	@GetMapping("/soma")
	public String soma(@RequestParam(value="n1", required=true) String n1,
						@RequestParam(value="n2", required=true) String n2) {
		return String.valueOf(Double.parseDouble(n1)+Double.parseDouble(n2));
	}

	@GetMapping("/subtracao")
	public String subtracao(@RequestParam(value="n1", required=true) String n1,
						@RequestParam(value="n2", required=true) String n2) {
		return String.valueOf(Double.parseDouble(n1)-Double.parseDouble(n2));
	}

	@GetMapping("/multiplicacao")
	public String multiplicacao(@RequestParam(value="n1", required=true) String n1,
						@RequestParam(value="n2", required=true) String n2) {
		return String.valueOf(Double.parseDouble(n1)*Double.parseDouble(n2));
	}

	@GetMapping("/divisao")
	public String divisao(@RequestParam(value="n1", required=true) String n1,
						@RequestParam(value="n2", required=true) String n2) {
		return String.valueOf(Double.parseDouble(n1)/Double.parseDouble(n2));
	}

	@GetMapping("/potencia")
	public String potencia(@RequestParam(value="n1", required=true) String n1,
						@RequestParam(value="n2", required=true) String n2) {
		return String.valueOf(Math.pow(Double.parseDouble(n1),
			Double.parseDouble(n2)));
	}
}
