package cn.tuling.nettybasic.outread;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * 作者：Mark
 * 类说明：基于Netty的服务器
 */

public class EchoServerOR {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServerOR.class);

    private final int port;

    public EchoServerOR(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 9999;
        EchoServerOR echoServerOR = new EchoServerOR(port);
        LOG.info("服务器即将启动");
        echoServerOR.start();
        LOG.info("服务器关闭");
    }

    public void start() throws InterruptedException {
        /*线程组*/
        EventLoopGroup group  = new NioEventLoopGroup();
        try {
            /*服务端启动必备*/
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoServerORHandler());
                            ch.pipeline().addLast(new ServerOutReadHandler());
                        }
                    });

            /*异步绑定到服务器，sync()会阻塞到完成*/
            ChannelFuture f = b.bind().sync();
            LOG.info("服务器启动完成。");
            /*阻塞当前线程，直到服务器的ServerChannel被关闭*/
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }


}
