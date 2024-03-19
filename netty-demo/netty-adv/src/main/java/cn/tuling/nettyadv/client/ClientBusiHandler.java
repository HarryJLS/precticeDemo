package cn.tuling.nettyadv.client;

import cn.tuling.nettyadv.vo.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark老师
 * 类说明：接收业务应答消息并处理
 */
public class ClientBusiHandler extends SimpleChannelInboundHandler<MyMessage> {

    private static final Logger LOG = LoggerFactory.getLogger(ClientBusiHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyMessage msg) throws Exception {
        LOG.info("业务应答消息："+msg.toString());
    }
}
