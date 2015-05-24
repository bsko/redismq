package com.test.redis;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by Пользователь on 24.05.2015.
 */
@Singleton
@Startup
public class Utils {

    @PostConstruct
    public void init() {
        System.out.println("preved!");
    }
}
