package cn.tuling.nettyadv.server;

import cn.tuling.nettyadv.server.asyncpro.AsyncBusiProcess;
import cn.tuling.nettyadv.server.asyncpro.ITaskProcessor;
import cn.tuling.nettyadv.vo.EncryptUtils;
import cn.tuling.nettyadv.vo.MessageType;
import cn.tuling.nettyadv.vo.MsgHeader;
import cn.tuling.nettyadv.vo.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark老师
 * 类说明：业务处理类
 */
public class ServerBusiHandler
        extends SimpleChannelInboundHandler<MyMessage> {
    private static final Logger LOG = LoggerFactory.getLogger(ServerBusiHandler.class);
    private ITaskProcessor taskProcessor;

    public ServerBusiHandler(ITaskProcessor taskProcessor) {
        super();
        this.taskProcessor = taskProcessor;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyMessage msg)
            throws Exception {
        /*检查MD5*/
        String headMd5 = msg.getMyHeader().getMd5();
        String calcMd5 = EncryptUtils.encryptObj(msg.getBody());
        if(!headMd5.equals(calcMd5)){
            LOG.error("报文md5检查不通过："+headMd5+" vs "+calcMd5+"，关闭连接");
            ctx.writeAndFlush(buildBusiResp("报文md5检查不通过，关闭连接"));
            ctx.close();
        }
        LOG.info(msg.toString());
        if(msg.getMyHeader().getType() == MessageType.ONE_WAY.value()){
            LOG.debug("ONE_WAY类型消息，异步处理");
            AsyncBusiProcess.submitTask(taskProcessor.execAsyncTask(msg));
        }else{
            LOG.debug("TWO_WAY类型消息，应答");
            ctx.writeAndFlush(buildBusiResp("OK"));
        }
    }

    private MyMessage buildBusiResp(String result) {
        MyMessage message = new MyMessage();
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setType(MessageType.SERVICE_RESP.value());
        message.setMyHeader(msgHeader);
        message.setBody(result);
        return message;
    }
}
