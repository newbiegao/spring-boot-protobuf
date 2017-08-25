package com.plateno.gaolk.springbootprotobuf;

import com.googlecode.protobuf.format.XmlFormat;
import com.plateno.gaolk.springbootprotobuf.generated.domain.user.UserInfoProto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



public class ProtobufJavaFormatTest {


    @Test
    public void xmlOutTest() {

        UserInfoProto.UserInfo userInfo = UserInfoProto.UserInfo.getDefaultInstance() ;

        XmlFormat cc = new XmlFormat();
        System.out.println(cc.printToString(userInfo) );

    }

    public void inputXmlTest(){


    }


}
