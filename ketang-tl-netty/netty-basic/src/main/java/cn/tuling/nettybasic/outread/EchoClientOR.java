package cn.tuling.nettybasic.outread;

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
public class EchoClientOR {

    private final int port;
    private final String host;

    public EchoClientOR(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public void start() throws InterruptedException {

        /*线程组*/
        EventLoopGroup group  = new NioEventLoopGroup();
        try {
            /*客户端启动必备，和服务器的不同点*/
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)/*指定使用NIO的通信模式*/
                    /*指定服务器的IP地址和端口，和服务器的不同点*/
                    .remoteAddress(new InetSocketAddress(host,port))
                    /*和服务器的不同点*/
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new EchoClientORHandler());

                        }
                    });
            /*异步连接到服务器，sync()会阻塞到完成，和服务器的不同点*/
            ChannelFuture f = b.connect().sync();
            f.channel().closeFuture().sync();/*阻塞当前线程，直到客户端的Channel被关闭*/
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new EchoClientOR(9999,"127.0.0.1").start();
    }
}
