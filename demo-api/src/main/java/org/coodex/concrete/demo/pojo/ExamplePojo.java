package org.coodex.concrete.demo.pojo;

import lombok.Data;
import org.coodex.concrete.api.pojo.StrID;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExamplePojo {
    private String x1 = "随便什么吧";

    private List<StrID<String>> example = new ArrayList<StrID<String>>() {{
        for (int i = 0; i < 3; i++) {
            StrID<String> stringStrID = new StrID<>();
            stringStrID.setId("id" + i);
            stringStrID.setPojo("我是POJO_" + i);
            add(stringStrID);
        }
    }};
}