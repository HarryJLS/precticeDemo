package cn.tuling.nettybasic.checkread;

import cn.tuling.nettybasic.NettyConst;
import cn.tuling.nettybasic.sharehndler.MessageCountHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * 作者：Mark
 * 类说明：基于Netty的服务器
 */

public class EchoServerCR {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServerCR.class);

    private final int port;

    public EchoServerCR(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        int port = NettyConst.ECHO_PORT;
        EchoServerCR echoServer = new EchoServerCR(port);
        echoServer.start();
        LOG.info("服务器关闭");
    }

    public void start() throws InterruptedException {
        /*线程组*/
        EventLoopGroup group  = new NioEventLoopGroup();
        try {
            /*服务端启动必备*/
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
            .channel(NioServerSocketChannel.class)/*指定使用NIO的通信模式*/
            .localAddress(new InetSocketAddress(port))/*指定监听端口*/
                    //.childOption()
            //.handler();
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LineBasedFrameDecoder(5000));
                    ch.pipeline().addLast(new EchoServerCRHandler());
                }
            });
            ChannelFuture f = b.bind().sync();/*异步绑定到服务器，sync()会阻塞到完成*/
            LOG.info("服务器启动完成。");
            f.channel().closeFuture().sync();/*阻塞当前线程，直到服务器的ServerChannel被关闭*/
        } finally {
            group.shutdownGracefully().sync();

        }


    }


}
