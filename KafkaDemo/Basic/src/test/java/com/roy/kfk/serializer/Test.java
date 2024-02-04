package com.roy.kfk.serializer;

import com.alibaba.fastjson.JSON;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @auth roykingw
 */
public class Test {
    public static void main(String[] args) {
        User user = new User(1L,"loulan",1);
//        byte[] bytes = JSON.toJSON(user).toString().getBytes(StandardCharsets.UTF_8);
//        System.out.println(bytes);
//        System.out.println(JSON.parseObject(bytes, User.class).toString());

//        byte[] nameBytes = user.getName().getBytes(StandardCharsets.UTF_8);
//        //id: long 8byte + 4: int name的长度 +  name:string 不定长 + sex: int 4byte
//        int cap = 8 + 4 + nameBytes.length+4;
//        ByteBuffer byteBuffer = ByteBuffer.allocate(cap);
//        byteBuffer.putLong(user.getId());
//        byteBuffer.putInt(nameBytes.length);
//        byteBuffer.put(nameBytes);
//        byteBuffer.putInt(user.getSex());
//        byte[] data = byteBuffer.array();
//        System.out.println("userBytes:" + data);
//
//        ByteBuffer dataBuffer = ByteBuffer.allocate(data.length);
//        dataBuffer.put(data);
//        dataBuffer.flip();
//        System.out.println(dataBuffer.array().length);
//        long id = dataBuffer.getLong();
//        System.out.println(id);
//        int nameLength = dataBuffer.getInt();
//        System.out.println(nameLength);
//        String name = new String(dataBuffer.get(data, 12, nameLength).array(), StandardCharsets.UTF_8).trim();
//        int sex = dataBuffer.getInt();
//
//        System.out.println(new User(id, name, sex));


    }
}
