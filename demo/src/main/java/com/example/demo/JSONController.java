package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class JSONController {
    private String tem;
    private static final Log log = LogFactory.getLog(JSONController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/json")
    @ResponseBody
    public PostJSON json(@RequestBody PostJSON input){
        tem = input.getContent();
        input.setContent(null);
        log.info("Showing the JSON content on next line");
        log.info(tem);
        input.setContent(tem);
        return input;
    }
}
