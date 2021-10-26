package zjou.gxy.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import zjou.gxy.demo.bean.User;
import zjou.gxy.demo.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
	private UserService userService;


	@RequestMapping(value = "/login")
    public String  login(@ModelAttribute("user")  User u, Map<String,Object> map, HttpSession session, Model model) {

		User login = userService.validate(u);

		if(login!=null){
			session.setAttribute("login", login);
			return "index";
		}else{
			map.put("msg","登录错误");
			return "login";
		}

	}
}
