package cn.tuling.nettybasic.sharehndler;

import cn.tuling.nettybasic.NettyConst;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * 作者：Mark
 * 类说明：基于Netty的客户端
 */
public class EchoClientMC {

    private final int port;
    private final String host;

    public EchoClientMC(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void start() throws InterruptedException {

        /*线程组*/
        EventLoopGroup group  = new NioEventLoopGroup();
        try {
            /*客户端启动必备*/
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)/*指定使用NIO的通信模式*/
                    .remoteAddress(new InetSocketAddress(host,port))/*指定服务器的IP地址和端口*/
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientMCHandler());

                        }
                    });
            ChannelFuture f = b.connect().sync();/*异步连接到服务器，sync()会阻塞到完成*/
            f.channel().closeFuture().sync();/*阻塞当前线程，直到客户端的Channel被关闭*/
        } finally {
            group.shutdownGracefully().sync();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClientMC(NettyConst.ECHO_PORT,"127.0.0.1").start();
    }
}
