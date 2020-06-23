package com.maple.enumeration.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maple.enumeration.enums.FastJsonStatusEnum;
import com.maple.enumeration.enums.StatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 测试表 注释部分为mybatis-plus版本
 * </p>
 *
 * @author maple
 * @since 2020-06-21
 */
//@Data
//@Accessors(chain = true)
//@TableName("test")
//public class TestDO {
//
//    private Integer id;
//
//    private String username;
//
//    private StatusEnum status;
//}

@Data
@Accessors(chain = true)
public class TestDO {

    private Integer id;

    private String username;

    //    @JsonDeserialize(using = JacksonEnumConverter.class)
    //    @JsonSerialize(using = JacksonEnumSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private StatusEnum status;

    //    @JSONField(deserializeUsing = FastJsonEnumDeserializer.class)
//    @JSONField(serializeUsing = FastJsonEnumSerializer.class)
    private FastJsonStatusEnum fastJsonStatusEnum;
}
