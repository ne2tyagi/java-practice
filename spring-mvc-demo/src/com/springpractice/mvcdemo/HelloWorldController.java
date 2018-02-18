package com.springpractice.mvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller //Controller extends Component to include in component scan
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showHelloWorldForm(){
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processHelloWorldForm(@RequestParam("studentName") String theName/*HttpServletRequest request*/, Model model){
		//String theName = request.getParameter("studentName").toUpperCase();
		model.addAttribute("message", "Yo! "+theName);
		return "helloworld";
	}
}
