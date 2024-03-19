package cn.tuling.nettybasic.serializable.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Mark老师
 * 类说明：
 */
public class ProtoBufClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
       System.out.println("Prepare to make data........");
       PersonProto.Person.Builder builder = PersonProto.Person.newBuilder();
        builder.setName("Mark");
        builder.setId(1);
        builder.setEmail("Mark@enjoyedu.com");
        System.out.println("send data........");
        ctx.writeAndFlush(builder.build());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
