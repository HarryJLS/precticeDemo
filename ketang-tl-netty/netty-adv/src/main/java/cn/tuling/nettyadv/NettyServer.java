package cn.tuling.nettyadv;

import cn.tuling.nettyadv.server.ServerInit;
import cn.tuling.nettyadv.server.asyncpro.AsyncBusiProcess;
import cn.tuling.nettyadv.vo.NettyConstant;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mark老师
 * 类说明：服务端的主入口
 */
public class NettyServer {

    private static final Logger LOG = LoggerFactory.getLogger(NettyServer.class);

    public void bind() throws Exception {
        // 配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1,new DefaultThreadFactory("boss"));
        EventLoopGroup workerGroup = new NioEventLoopGroup(NettyRuntime.availableProcessors(),
                new DefaultThreadFactory("nt_worker"));
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG, 1024)
            .childHandler(new ServerInit());
        // 绑定端口，同步等待成功
        b.bind(NettyConstant.SERVER_PORT).sync();
            LOG.info("Netty server start : "
                + (NettyConstant.SERVER_IP + " : "
                    + NettyConstant.SERVER_PORT));
    }

    public static void main(String[] args) throws Exception {
	    new NettyServer().bind();
    }
}
