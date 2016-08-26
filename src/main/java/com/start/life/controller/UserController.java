package com.start.life.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @date 2016年7月14日
 * @author hzhubingxin@corp.netease.com
 */
@RestController
@RequestMapping("/user")
public class UserController {

  Logger logger = LoggerFactory.getLogger(UserController.class);

  @ApiOperation(value = "测试Swagger," + "Owner:Bingxin,状态：正在开发中", response = String.class)
  @RequestMapping(value = "/springboot", method = RequestMethod.POST)
  public String index(@ApiParam(name = "userName", value = "用户名",
      required = true) @RequestParam(value = "userName") String userName) {
    return userName + ", 后台团队欢迎你!";
  }
  
  
}
