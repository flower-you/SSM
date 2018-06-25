package com.yan.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yan.biz.IUserServ;
import com.yan.common.BaseController;
import com.yan.entity.UserBean;
import com.yan.group.UserGroup;

@Controller
@RequestMapping("/user")
@SessionAttributes("loginUser")
public class UserController extends BaseController {
	@Autowired
	private IUserServ userv;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
		model.addAttribute("user",new UserBean());
		return "user/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") @Validated(UserGroup.LoginGroup.class) UserBean user,
			BindingResult errors, Model model) throws Exception {
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "user/login";
		}
		boolean bb = userv.login(user);
		if (bb) {
			model.addAttribute("loginUser", user);
			return "user/welcome";
		} else {
			model.addAttribute("msg", "登录失败，请重新登录");
			return "user/login";
		}
	}
}
