package com.ivar.enterprise.context.service;

import com.ivar.enterprise.context.bean.Context;

/**
 * Created by ONC50886 on 8/15/2016.
 */
public interface ContextService {
    Context getContext(String userId);
}
