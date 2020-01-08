/*
package com.nr.fierce_tribe.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
@Setter
@ToString
@Slf4j
public class GlobalConfig {

    @Value("${global.url.notify}")
    private String notifyUrl;

    @PostConstruct
    public void declareSelf() {
        log.info(this.toString());
    }

}
*/
