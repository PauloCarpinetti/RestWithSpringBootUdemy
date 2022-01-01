package br.com.betocode.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.betocode.exception.UnsuportedMathOperationException;
import br.com.betocode.math.SimpleMath;
import br.com.betocode.request.converters.NumberConverter;

@RestController	
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/soma/{num1}/{num2}", method=RequestMethod.GET)
	public Double soma(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.soma(NumberConverter.covertToDouble(num1), NumberConverter.covertToDouble(num2));		
	}
	
	@RequestMapping(value="/subtracao/{num1}/{num2}", method=RequestMethod.GET)
	public Double subtracao(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.subtracao(NumberConverter.covertToDouble(num1), NumberConverter.covertToDouble(num2));		
	}
	
	@RequestMapping(value="/multiplicacao/{num1}/{num2}", method=RequestMethod.GET)
	public Double multiplicacao(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.multiplicacao(NumberConverter.covertToDouble(num1), NumberConverter.covertToDouble(num2));		
	}
	
	@RequestMapping(value="/divisao/{num1}/{num2}", method=RequestMethod.GET)
	public Double divisao(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.divisao(NumberConverter.covertToDouble(num1), NumberConverter.covertToDouble(num2));		
	}
	
	@RequestMapping(value="/media/{num1}/{num2}", method=RequestMethod.GET)
	public Double media(@PathVariable("num1") String num1, @PathVariable("num2") String num2) throws Exception {
		if (!NumberConverter.isNumeric(num1) || !NumberConverter.isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.media(NumberConverter.covertToDouble(num1), NumberConverter.covertToDouble(num2));		
	}
	
	@RequestMapping(value="/raiz/{num1}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("num1") String num1) throws Exception {
		if (!NumberConverter.isNumeric(num1)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return math.raiz(NumberConverter.covertToDouble(num1));		
	}
}

