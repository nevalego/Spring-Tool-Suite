package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping ("/nerea")
public class ControladorNerea{
	@RequestMapping ("/")
	 String Hola(){
		 return "Nerea no está"; 
	 }
	 @RequestMapping ("/minombre")
	 String Nombre(){
		 return "Nerea Valdés Egocheaga"; 
	 }
}
