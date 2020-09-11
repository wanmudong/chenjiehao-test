package 第三章;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.channels.Channel;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2020-09-11
 */
public class example5 {
    public static void main(String[] args) {
        Channel channel = new C ;

        ByteBuf buf = Unpooled.copiedBuffer("data ", CharsetUtil.UTF_8);
        Channel cf = channel.writeAndFlush(buf);
    }
}
