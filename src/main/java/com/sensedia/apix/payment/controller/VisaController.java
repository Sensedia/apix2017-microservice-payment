package com.sensedia.apix.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VisaController {

	@RequestMapping(name = "/paymentvisa/{id}")
    public String createVisaPayment(@RequestParam(value="id", required=false) String id, Model model) {
        model.addAttribute("id", id);
        return "paymentvisa";
    }
}
