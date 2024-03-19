package cn.tuling.nettybasic.checkread;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class EchoClientCRHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger LOG = LoggerFactory.getLogger(EchoClientCRHandler.class);

    /*读取到网络数据后进行业务处理*/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        LOG.info("client Accept "+msg.toString(CharsetUtil.UTF_8));
        ctx.close();

    }

    /*channel活跃后，做业务处理*/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf msg = null;
        /*发送较小报文多次*/
        String requestSmall = "small" + System.getProperty("line.separator");
        for(int i = 0; i<100; i++ ){
            msg = Unpooled.buffer(requestSmall.length());
            msg.writeBytes(requestSmall.getBytes());
            ctx.writeAndFlush(msg);
        }
        LOG.info("client send small message.");

        //ctx.close();
    }
}
