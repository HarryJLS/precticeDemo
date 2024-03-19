package cn.tuling.nettyadv;

import cn.tuling.nettyadv.client.ClientInit;
import cn.tuling.nettyadv.vo.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark老师
 * 类说明：Netty客户端的主入口
 */
public class NettyClient implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(NettyClient.class);

    /*负责重连的线程池*/
    private ScheduledExecutorService executor = Executors
            .newScheduledThreadPool(1);
    private Channel channel;
    private EventLoopGroup group = new NioEventLoopGroup();

    /*是否用户主动关闭连接的标志值*/
    private volatile boolean userClose = false;
    /*连接是否成功关闭的标志值*/
    private volatile boolean connected = false;

    public boolean isConnected() {
        return connected;
    }

    /*连接服务器*/
    public void connect(int port,String host) throws InterruptedException {
        try {
            /*客户端启动必备*/
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)/*指定使用NIO的通信模式*/
            .handler(new ClientInit());
            ChannelFuture future = b.connect(new InetSocketAddress(host,port)).sync();
            LOG.info("已连接服务器");
            channel = future.channel();
            synchronized (this){
                this.connected = true;
                this.notifyAll();
            }
            channel.closeFuture().sync();
        } finally {
            if(!userClose){
                /*非正常关闭，有可能发生了网络问题，进行重连*/
                LOG.warn("需要进行重连");
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            /*给操作系统足够的时间，去释放相关的资源*/
                            TimeUnit.SECONDS.sleep(1);
                            connect(NettyConstant.SERVER_PORT,
                                    NettyConstant.SERVER_IP);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }else{
                /*正常关闭*/
                channel = null;
                group.shutdownGracefully().sync();
                synchronized (this){
                    this.connected = false;
                    this.notifyAll();
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            connect(NettyConstant.SERVER_PORT,NettyConstant.SERVER_IP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*------------测试NettyClient--------------------------*/
    public static void main(String[] args) throws Exception {
        NettyClient nettyClient = new NettyClient();
        nettyClient.connect(NettyConstant.SERVER_PORT
                , NettyConstant.SERVER_IP);
        nettyClient.send("v");
        nettyClient.close();
    }

    /*------------以下方法供业务方使用--------------------------*/
    public void send(Object message) {
        if(channel==null||!channel.isActive()){
            throw new IllegalStateException("和服务器还未未建立起有效连接！" +
                    "请稍后再试！！");
        }
        MyMessage msg = new MyMessage();
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setMsgID(MakeMsgID.getID());
        msgHeader.setType(MessageType.SERVICE_REQ.value());
        msgHeader.setMd5(EncryptUtils.encryptObj(message));
        msg.setMyHeader(msgHeader);
        msg.setBody(message);
        channel.writeAndFlush(msg);
    }

    public void sendOneWay(Object message) {
        if(channel==null||!channel.isActive()){
            throw new IllegalStateException("和服务器还未未建立起有效连接！" +
                    "请稍后再试！！");
        }
        MyMessage msg = new MyMessage();
        MsgHeader msgHeader = new MsgHeader();
        msgHeader.setMsgID(MakeMsgID.getID());
        msgHeader.setType(MessageType.ONE_WAY.value());
        msgHeader.setMd5(EncryptUtils.encryptObj(message));
        msg.setMyHeader(msgHeader);
        msg.setBody(message);
        channel.writeAndFlush(msg);
    }

    public void close() {
        userClose = true;
        channel.close();
    }


}
