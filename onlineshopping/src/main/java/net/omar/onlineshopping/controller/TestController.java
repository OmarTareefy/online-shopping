package net.omar.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping(value = { "/jo7a"})
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("testPage");
		mv.addObject("testKey", "ValueOfTheMapTestKey");
		return mv;
	}
}
