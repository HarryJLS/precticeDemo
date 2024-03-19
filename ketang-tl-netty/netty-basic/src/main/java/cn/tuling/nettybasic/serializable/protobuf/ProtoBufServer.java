package cn.tuling.nettybasic.serializable.protobuf;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * @author Mark老师
 * 类说明：
 */
public class ProtoBufServer {
    public void bind(int port) throws Exception {
        // 配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            /*去除消息长度部分，同时根据这个消息长度读取实际的数据*/
                            ch.pipeline().addLast(
                                    new ProtobufVarint32FrameDecoder());
                            ch.pipeline().addLast(new ProtobufDecoder(
                                    PersonProto.Person.getDefaultInstance()
                            ));
                            ch.pipeline().addLast(new ProtoBufServerHandler());
                }
            });

            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();

            System.out.println("init start");
            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        new ProtoBufServer().bind(port);
    }
}
