package cn.tuling.nettybasic.serializable.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.IOException;

/**
 * @author Mark老师
 * 类说明：
 */
public class ProtoBufServerHandler  extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        PersonProto.Person req = (PersonProto.Person)msg;
        System.out.println("get data name = "+req.getName());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        if(cause instanceof IOException){
            System.out.println("远程客户端强迫关闭了一个现有的连接。");
        }
        ctx.close();
    }
}
