package org.ssl.boot.day01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Demo1Controller {
    @GetMapping("/demol")
    public String  Hello(@RequestParam(name = "name") String name,Model model){
        model.addAttribute("name",name);
        return "model";
    }
}
