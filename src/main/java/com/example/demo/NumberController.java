package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NumberController {

    @PostMapping("/check")
    public String checkNumber(@RequestParam("number") String number, Model model) {
        String result;

        // Error Handling
        if (number.isEmpty()) {
            result = "Error: Please enter a number.";
            CsvLogger.logError(number, "Empty Input");
        } else if (!number.matches("\\d+")) {
            result = "Error: Invalid input. Only integer values are allowed.";
            CsvLogger.logError(number, "Non-integer Input or Special Character");
        } else {
            int num = Integer.parseInt(number);

            if (num % 2 == 0) {
                result = "The number " + num + " is Even.";
                CsvLogger.logValidEntry(number, "Even");
            } else {
                result = "The number " + num + " is Odd.";
                CsvLogger.logValidEntry(number, "Odd");
            }
        }

        model.addAttribute("result", result);
        return "index";  // Returning the view (Thymeleaf template) name
    }
}
