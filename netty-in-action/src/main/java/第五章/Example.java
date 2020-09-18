package 第五章;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2020-09-14
 */
public class Example {
    public void example1(){
        ByteBuf heapBuf = ...;
        if (heapBuf.hasArray()){
            byte[]array = heapBuf.array();
            int offset = heapBuf.arrayOffset()+heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
            handlerArray(array,offset,length);
        }
    }

    private void handlerArray(byte[] array, int offset, int length) {

    }

    public  void example2() {
        ByteBuf directBuf = ..;
        if (!directBuf.hasArray()){
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(),array);
            handlerArray(array,0,length);
        }
    }

    public void example3(){
        ByteBuffer [] message = new ByteBuffer[]{header,body};
        ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaing);
        message2.put(header);
        message2.put(body);
        message2.flip();
    }

    public void example4(){
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf ;
        ByteBuf bodyBuf ;
        messageBuf.addComponent(headerBuf,bodyBuf);
        for (ByteBuf byteBuf : messageBuf){
            System.out.println(byteBuf.toString());
        }
    }

    public void example5(){
        CompositeByteBuf comBuf = Unpooled.compositeBuffer();
        int length = comBuf.readableBytes();
        byte[]array =new byte[length];
        comBuf.getBytes(comBuf.readerIndex(),array);
        handlerArray(array,0,length);
    }

    public void example6(){
        ByteBuf byteBuf ;
        for (int i =0; i< byteBuf.capacity();i++){
            byte b = byteBuf.getByte(i);
            System.out.println((char) b);
        }
    }

    public void example9(){
        ByteBuf buffer ;
        int index = buffer.forEachByte(ByteProcessor.FIND_CR);
    }

    public void example10(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        ByteBuf sliced = buf.slice(0,15);
        System.out.println(sliced.toString(utf8));
        buf.setByte(0,(byte)'J');
        assert buf.getByte(0) == sliced.getByte(0);
    }

    public void example11(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        ByteBuf copy = buf.copy(0,15);
        System.out.println(copy.toString(utf8));
        buf.setByte(0,(byte)'J');
        assert buf.getByte(0) != copy.getByte(0);
    }

    public void example12(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        System.out.println(buf.getByte(0));
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.setByte(0,(byte)'B');
        System.out.println(buf.getByte(0));
        assert readerIndex == buf.readerIndex();
        assert writerIndex == buf.writerIndex();
    }
    public void example13(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!",utf8);
        System.out.println(buf.readByte());
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.writeByte((byte)'B');
        System.out.println(buf.getByte(0));
        assert readerIndex == buf.readerIndex();
        assert writerIndex != buf.writerIndex();
    }
}
