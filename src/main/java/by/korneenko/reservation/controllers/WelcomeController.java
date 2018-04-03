package by.korneenko.reservation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = { "/*", "/*/*" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        String welcome = new String("Welcome");
        return welcome;
    }


}
