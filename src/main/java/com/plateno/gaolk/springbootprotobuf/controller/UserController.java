package com.plateno.gaolk.springbootprotobuf.controller;

import com.googlecode.protobuf.format.JsonFormat;
import com.googlecode.protobuf.format.XmlFormat;
import com.plateno.gaolk.springbootprotobuf.generated.domain.user.UserInfoProto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate  ;

    // produces = "application/x-protobuf"
    @RequestMapping( value = "proto/user" , consumes = "application/x-protobuf")
    public UserInfoProto.UserInfo userInfo(){

        UserInfoProto.UserInfo user = UserInfoProto.UserInfo.newBuilder()
                .setName("gao")
                .setLastName("ling kong")
                .setCompany(" plateno ")
                .setAge(39)
                .build() ;

        return user  ;

    }

    @RequestMapping( value = "/xml/user" )
    public String xmlUserInfo(){


        UserInfoProto.UserInfo userInfo = restTemplate.getForObject( "http://localhost:8080/proto/user" , UserInfoProto.UserInfo.class) ;

        XmlFormat xmlFormat = new XmlFormat();

        return  xmlFormat.printToString(userInfo)   ;

    }

    @RequestMapping( value = "/json/user" )
    public String jsonUserInfo(){


        UserInfoProto.UserInfo userInfo = restTemplate.getForObject( "http://localhost:8080/proto/user" , UserInfoProto.UserInfo.class) ;

        JsonFormat jsonFormat = new JsonFormat();
        return  jsonFormat.printToString(userInfo) ;

    }

}
