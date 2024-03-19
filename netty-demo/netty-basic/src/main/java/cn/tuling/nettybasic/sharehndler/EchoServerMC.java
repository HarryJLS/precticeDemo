package cn.tuling.nettybasic.sharehndler;

import cn.tuling.nettybasic.NettyConst;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
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

public class EchoServerMC {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServerMC.class);


    private final int port;

    public EchoServerMC(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        int port = NettyConst.ECHO_PORT;
        EchoServerMC echoServer = new EchoServerMC(port);
        echoServer.start();
        LOG.info("服务器关闭");
    }

    public void start() throws InterruptedException {
        final MessageCountHandler messageCountHandler = new MessageCountHandler();
        /*线程组*/
        EventLoopGroup boss  = new NioEventLoopGroup();
        EventLoopGroup work  = new NioEventLoopGroup();
        try {
            /*服务端启动必备*/
            ServerBootstrap b = new ServerBootstrap();
            b.group(boss,work)
            .channel(NioServerSocketChannel.class)/*指定使用NIO的通信模式*/
                    //.option(ChannelOption.SO_BACKLOG)
            .localAddress(new InetSocketAddress(port))/*指定监听端口*/
                   // .childOption(ChannelOption.SO_RCVBUF)
                    //.childOption()
            //.handler();
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                    ch.pipeline().addLast(messageCountHandler);
                    ch.pipeline().addLast(new EchoServerMCHandler());
                }
            });
            ChannelFuture f = b.bind().sync();/*异步绑定到服务器，sync()会阻塞到完成*/
            LOG.info("服务器启动完成");
            f.channel().closeFuture().sync();/*阻塞当前线程，直到服务器的ServerChannel被关闭*/
        } finally {
            boss.shutdownGracefully().sync();
            work.shutdownGracefully().sync();

        }


    }


}
