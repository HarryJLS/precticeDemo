package cn.tuling.nettyhttp.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author Mark老师
 * 类说明：
 */
public class HttpClientInboundHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpResponse httpResponse = (FullHttpResponse)msg;
        System.out.println(httpResponse.status());
        System.out.println(httpResponse.headers());
        ByteBuf buf = httpResponse.content();
        System.out.println(buf.toString(CharsetUtil.UTF_8));
        httpResponse.release();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        URI uri = new URI("/test");
        String msg = "Hello";
        DefaultFullHttpRequest request =
                new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                        HttpMethod.GET,
                        uri.toASCIIString(),
                        Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));

        // 构建http请求
        request.headers().set(HttpHeaderNames.HOST, HttpClient.HOST);
        request.headers().set(HttpHeaderNames.CONNECTION,
                HttpHeaderValues.KEEP_ALIVE);
        request.headers().set(HttpHeaderNames.CONTENT_LENGTH,
                request.content().readableBytes());
        // 发送http请求
        ctx.writeAndFlush(request);
    }
}
