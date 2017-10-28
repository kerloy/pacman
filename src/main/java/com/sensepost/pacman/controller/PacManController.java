package com.sensepost.pacman.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Controller
public class PacManController {

    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public ModelAndView indexController(HttpServletResponse response) {
        LOG.info("INDEX CONTROLLER");
        ModelMap map = new ModelMap();
        return new ModelAndView("index", map);
    }


    @RequestMapping(value = {"/getIpByHostname"}, method = RequestMethod.GET)
    public
    @ResponseBody
    String getIpByHostnameController(@RequestParam() final String hostname) throws UnknownHostException {
        LOG.info("Get IP by Hostname: " + hostname);
        InetAddress address = InetAddress.getByName(hostname);
        return address.getHostAddress();
    }


    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    public String getMeAString(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

}