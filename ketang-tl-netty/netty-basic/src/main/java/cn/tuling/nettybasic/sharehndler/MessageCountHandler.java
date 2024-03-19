package cn.tuling.nettybasic.sharehndler;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：Mark老师
 * @description ：统计服务器接受到和发出的业务报文总数
 */
@ChannelHandler.Sharable
public class MessageCountHandler extends ChannelDuplexHandler {
    private static final Logger LOG = LoggerFactory.getLogger(MessageCountHandler.class);

    private AtomicLong inCount = new AtomicLong(0);
    private AtomicLong outCount = new AtomicLong(0);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        LOG.info("收到报文总数："+inCount.incrementAndGet());
        super.channelRead(ctx, msg);
    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        LOG.info("发出报文总数："+outCount.incrementAndGet());
        super.flush(ctx);
    }
}
