package cn.tuling.nettyadv.client;

import cn.tuling.nettyadv.vo.MessageType;
import cn.tuling.nettyadv.vo.MsgHeader;
import cn.tuling.nettyadv.vo.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark老师
 * 类说明：发起登录请求
 */
public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(LoginAuthReqHandler.class);

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*发出认证请求*/
        MyMessage loginMsg = buildLoginReq();
        LOG.info("请求服务器认证 : " + loginMsg);
        ctx.writeAndFlush(loginMsg);
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        MyMessage message = (MyMessage) msg;
        /*是不是握手成功的应答*/
        if(message.getMyHeader()!=null
                &&message.getMyHeader().getType()==MessageType.LOGIN_RESP.value()){
            LOG.info("收到认证应答报文，服务器是否验证通过？");
            byte loginResult = (byte) message.getBody();
            if (loginResult != (byte) 0) {
                /*握手失败，关闭连接*/
                LOG.warn("未通过认证，关闭连接: " + message);
                ctx.close();
            } else {
                LOG.info("通过认证，移除本处理器，进入业务通信 : " + message);
                ctx.pipeline().remove(this);
                ReferenceCountUtil.release(msg);
            }
        }else{
            ctx.fireChannelRead(msg);
        }
    }

    private MyMessage buildLoginReq() {
        MyMessage message = new MyMessage();
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setType(MessageType.LOGIN_REQ.value());
        message.setMyHeader(msgHeader);
        return message;
    }

}
