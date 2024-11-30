package co.edu.uptc.Prueba.controller;

import org.springframework.web.bind.annotation.RestController;

import models.Person;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController


public class DemoController {
    @GetMapping("/info")
    public String getNumber(String number) {
        String input = "<label for=\"\">Ingrese el número</label> " + "<input type=\"text\">" + "<button>Enviar</button>";
        return input;
    }
    
    
}
