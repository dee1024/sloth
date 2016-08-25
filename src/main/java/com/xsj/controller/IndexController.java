package com.xsj.controller;

import com.xsj.generate.Generator;
import com.xsj.parameter.WebBuildParameters;
import org.json.JSONObject;
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
        JSONObject result = Generator.execute(webBuildParameters.getBuildParams());
        return result.toString();
    }

}
