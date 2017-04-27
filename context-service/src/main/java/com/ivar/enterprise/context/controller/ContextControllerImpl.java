package com.ivar.enterprise.context.controller;

import com.ivar.enterprise.context.bean.Context;
import com.ivar.enterprise.context.service.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ONC50886 on 8/15/2016.
 */
@RestController
public class ContextControllerImpl implements ContextController {
    @Autowired
    @Qualifier("ContextServiceImpl")
    ContextService contextService;
    @RequestMapping("/context/{userId}")
    public Context getContext(String userId){
        return contextService.getContext(userId);
    }
    
    @RequestMapping("/context")
    public String toString(){
		return "Context Resource";
    	
    }
}
