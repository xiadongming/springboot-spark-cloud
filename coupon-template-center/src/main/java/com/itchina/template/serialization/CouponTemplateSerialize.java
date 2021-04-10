package com.itchina.template.serialization;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.itchina.template.entity.CouponTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * <h1>优惠券模板实体类自定义序列化器</h1>
 */
public class CouponTemplateSerialize extends JsonSerializer<CouponTemplate> {

    @Override
    public void serialize(CouponTemplate template,
                          JsonGenerator generator,
                          SerializerProvider serializerProvider)
            throws IOException {

        // 开始序列化对象
        generator.writeStartObject();

        generator.writeStringField("id", template.getId().toString());
        generator.writeStringField("name", template.getName());
        generator.writeStringField("logo", template.getLogo());
        //generator.writeStringField("desc", template.getDesc());
        generator.writeStringField("category",  template.getCategory());
        generator.writeStringField("productLine",  template.getProductLine());
        generator.writeStringField("count", template.getCouponCount().toString());
        generator.writeStringField("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(template.getCreateTime()));
        generator.writeStringField("userId", template.getUserId().toString());
        generator.writeStringField("key", template.getTemplateKey() + String.format("%04d", template.getId()));
        generator.writeStringField("target", String.valueOf(template.getTarget()));
        generator.writeStringField("rule", JSON.toJSONString(template.getRule()));

        // 结束序列化对象
        generator.writeEndObject();
    }
}
