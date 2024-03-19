package cn.tuling.nettybasic.checkread;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*观察channelRead和channelReadComplete*/
public class EchoServerCRHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServerCRHandler.class);
    private int readCount = 0;
    private int readCompleteCount = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ByteBuf in = (ByteBuf)msg;
        LOG.info("channelRead执行了"+(++readCount)+"次");
        //ctx.writeAndFlush(in);
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        LOG.info("channelReadComplete执行了"+(++readCompleteCount)+"次");
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
