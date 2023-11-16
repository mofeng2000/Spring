package com.luoli.anno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    public void save() {
//        int i=1/0;
        System.out.println("save running....");
    }
}
