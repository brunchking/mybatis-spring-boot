package com.example.demo.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.demo.controller.MyRest;

@Component
public class JaxrsConfig extends ResourceConfig {
 public JaxrsConfig () {
   register(MyRest.class);
 }
}