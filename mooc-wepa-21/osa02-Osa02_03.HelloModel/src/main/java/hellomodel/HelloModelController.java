package hellomodel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloModelController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String story(@RequestParam String title, @RequestParam String person, Model model) {
        model.addAttribute("title", title);
        model.addAttribute("person", person);
        return "index";
    }
}
