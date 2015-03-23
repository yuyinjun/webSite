package com.lm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lm.entity.UserEntity;
import com.lm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable String id, ModelMap modelMap,
			HttpServletRequest request) {
		UserEntity u = userService.getUserEntityById(id);

		if (u == null) {
			u = new UserEntity();
			u.setEmail("");
			u.setUserId("");
		}
		modelMap.put("user", u);
		return "/user/showUser";
	}

	@RequestMapping("showUser")
	public String showUserEntity(String id, ModelMap modelMap,
			HttpServletRequest request) {
		UserEntity u = userService.getUserEntityById(id);
		if (u == null) {
			u = new UserEntity();
			u.setEmail("");
			u.setUserId("");
		}
		modelMap.put("user", u);
		return "/user/showUser";
	}

	@RequestMapping("/showUserExample")
	public String showUsers(Model model) {
		return "redirect:/1/showUser";
	}

	@RequestMapping(value = "/userList")
	public String list(HttpServletRequest request, Model model,@RequestParam(defaultValue= "1")  int page) {
		System.out.println("userList login");
		RequestContext requestContext = new RequestContext(request);
		System.out.println(requestContext.getMessage("info.page.email"));
		System.out.println(LocaleContextHolder.getLocale());
		
		PageHelper.startPage(page, 1);
		List<UserEntity> list =  userService.getUserEntities();
		PageInfo<UserEntity> pager = new PageInfo<UserEntity>(list);
		model.addAttribute("pager", pager);
		return "/user/list";
	}

	@RequestMapping("/user/{id}")
	public String detail(@PathVariable(value = "id") String id, ModelMap model) {
		model.put("user", userService.getUserEntityById(id));
		return "/user/detail";
	}

}