package phx.em.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class AppController {

	@RequestMapping(method = RequestMethod.GET, value = "/{client}/{app}")
	public String enter(@PathVariable String client, @PathVariable String app) {
		return client + "/" + app;
	}
}
