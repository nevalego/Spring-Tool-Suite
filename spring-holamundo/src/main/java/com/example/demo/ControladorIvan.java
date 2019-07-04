package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping ("/ivan")
public class ControladorIvan{
	 
	 @RequestMapping ("/")
	 String Hola(){
		 return "Iván no está"; 
	 }
	 
	 @RequestMapping ("/minombre")
	 String Nombre(){
		 return "Iván González Mahagamage"; 
	 }
}
