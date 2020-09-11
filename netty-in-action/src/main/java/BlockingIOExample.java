//import org.jboss.netty.channel.Channel;
//import org.jboss.netty.channel.ChannelFuture;
//import org.jboss.netty.channel.ChannelFutureListener;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.InetSocketAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.ByteBuffer;
//import java.nio.charset.Charset;
//
///**
// * 描述:
// *
// * @author chenjiehao
// * @create 2020-09-09
// */
//public class BlockingIOExample {
//
//    public void example() throws IOException {
//        int pornNumber = 80;
//        ServerSocket serverSocket = new ServerSocket(pornNumber);
//        Socket clientSocket = serverSocket.accept();
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(clientSocket.getInputStream()));
//        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
//
//        String request,response;
//        while ((request = in.readLine()) != null){
//            if ("Done".equals(request)){
//                break;
//            }
//            response = processRequest(request);
//            out.println(response);
//        }
//
//
//    }
//
//    private String processRequest(String request) {
//        return null;
//    }
//
//    public void example3(){
//        Channel channel ;
//        ChannelFuture future = channel.connect(new InetSocketAddress("192.168.1.1",25));
//    }
//
//    public void example4(){
//        Channel channel ;
//
//        ChannelFuture future = channel.connect(new InetSocketAddress("192.168.1.1",25));
//        future.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture future) throws Exception {
//                if (future.isSuccess()){
//                    ByteBuffer buffer = Unpooled.copiedBuffer("hello", Charset.defaultCharset());
//                    ChannelFuture wf = future.cancel()
//                            .writeAndFlush(buffer);
//                }else {
//                    Throwable cause = future.getCause();
//                    cause.printStackTrace();
//                }
//            }
//        });
//    }
//}
