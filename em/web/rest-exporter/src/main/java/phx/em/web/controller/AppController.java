package phx.em.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/angular")
public class AppController {

	@RequestMapping(method = RequestMethod.GET)
	public String enter() {
		return "angular/app";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/partials/{fragment}")
	public String partials(@PathVariable String fragment) {
		return "angular/partials/" + fragment;
	}
}
