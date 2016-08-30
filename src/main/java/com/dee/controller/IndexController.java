package com.dee.controller;

import com.dee.generate.Generator;
import com.dee.parameter.WebBuildParameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index");
        return mav;
    }

    @RequestMapping(value="/build", method= RequestMethod.POST)
    public String build(WebBuildParameters webBuildParameters) throws Exception {
        Generator.execute(webBuildParameters.getBuildParams());
        return "";
    }

}
