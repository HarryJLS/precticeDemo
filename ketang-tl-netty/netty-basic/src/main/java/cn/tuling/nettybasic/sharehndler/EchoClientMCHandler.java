package cn.tuling.nettybasic.sharehndler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.Random;

public class EchoClientMCHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private Random r = new Random();

    /*读取到网络数据后进行业务处理*/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("client Accept"+msg.toString(CharsetUtil.UTF_8));
        //ctx.close();

    }

    /*channel活跃后，做业务处理*/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        String request = "Hello"
                + System.getProperty("line.separator");
        int sendCount = r.nextInt(10) + 1;
        for(int i=0; i<sendCount; i++ ){
            msg = Unpooled.buffer(request.length());
            msg.writeBytes(request.getBytes());
            ctx.writeAndFlush(msg);
        }
    }
}
