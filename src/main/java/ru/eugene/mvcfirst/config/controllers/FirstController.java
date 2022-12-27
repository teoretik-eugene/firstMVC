package ru.eugene.mvcfirst.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println(name + " " + surname + " from request_param");
        model.addAttribute("message", name + " " + surname + " from model");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a") String a,
                            @RequestParam(value = "b") String b,
                            @RequestParam(value = "action") String action,
                            Model model){

        try{
            int aInt = Integer.parseInt(a);
            int bInt = Integer.parseInt(b);
            String operation = "_";
            float result = 0;
            switch (action){
                case "addition":{
                    result = aInt + bInt;
                    operation = "+";
                    break;
                }
                case "subtraction":{
                    result = aInt - bInt;
                    operation = "-";
                    break;
                }
                case "multiplication":{
                    result = aInt * bInt;
                    operation = "*";
                    break;
                }
                case "division":{
                    result = (float) aInt /(float) bInt;
                    operation = "/";
                    break;
                }
            }
            model.addAttribute("calculation", String.valueOf(a) + operation +
                    String.valueOf(b) + " = " +
                    String.valueOf(result));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            return "first/calculation";
        }

        return "first/calculation";
    }

}
