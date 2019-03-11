package com.kien.web.controller;

import com.kien.model.user.User;
import com.kien.service.user.UserService;
import com.kien.util.IOUtils;
import com.kien.util.Message;
import com.kien.util.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

@Controller()
@RequestMapping(value = "/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("Listing users");
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        logger.info("No. of users: " + users.size());
        return "users/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        logger.info("Getting an user and display!!!!!!!!!!!");
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "users/show";
    }

    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(@Valid User user, BindingResult bindingResult, Model model,
                         HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {

        logger.info("Updating singer!!!!");
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("user_save_fail", new Object[]{}, locale)));
            model.addAttribute("user", user);
            return "users/update";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("user_save_success", new Object[]{}, locale)));
        userService.save(user);
        return "redirect:/users/" + UrlUtil.enocdeUrlPathSegment(user.getId().toString(), httpServletRequest);
    }

    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/update";
    }

    public String create(@Valid User user, BindingResult bindingResult, Model model,
                         HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes,
                         Locale locale, @RequestParam(value = "file", required = false) Part file) {
        logger.info("Creating user");
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("user_save_fail", new Object[]{}, locale)));
            model.addAttribute("user", user);
            return "users/create";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("user_save_success", new Object[]{}, locale)));
        logger.info("User id : " + user.getId());
        if (file != null) {
            logger.info("File name : " + file.getName());
            logger.info("File size : " + file.getSize());
            logger.info("File content type: " + file.getContentType());
            byte[] fileContent = null;
            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null) logger.info("File inputstream is null");
                fileContent = IOUtils.toByteArray(inputStream);
            } catch (IOException e) {
                logger.error("Error saving uploanded file", e);
            }
            user.setAvatar(fileContent);
        }
        userService.save(user);
        return "redirect:/users/";
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "users/create";
    }

}
