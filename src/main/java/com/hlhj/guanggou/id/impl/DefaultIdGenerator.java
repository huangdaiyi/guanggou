package com.hlhj.guanggou.id.impl;

import com.hlhj.guanggou.id.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * ID 生成器接口默认实现
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
@Component
public class DefaultIdGenerator implements IdGenerator {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public List<String> generateIdList(int count) {
        List<String> idList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            idList.add(generateId());
        }
        return idList;
    }
}
