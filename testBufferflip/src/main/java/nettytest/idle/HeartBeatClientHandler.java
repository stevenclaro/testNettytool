package nettytest.idle;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Date;
import java.util.logging.Logger;





/**
 * @author lilinfeng
 * @date 2014年2月14日
 * @version 1.0
 */
public class HeartBeatClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger
            .getLogger(HeartBeatClientHandler.class.getName());

    private int counter;

    private byte[] req;
    private long curxTime;
    private long beatTime;

    /**
     * Creates a client-side handler.
     */
    public HeartBeatClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 释放资源
        logger.warning("Unexpected exception from downstream : "
                + cause.getMessage());
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("客户端循环心跳监测发送: " + new Date());
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.WRITER_IDLE) {
                if (curxTime < beatTime) {
                    curxTime++;
                    ctx.writeAndFlush("biubiu");
                }
            }
        }
    }
}

