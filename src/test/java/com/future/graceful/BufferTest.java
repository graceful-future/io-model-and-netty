package com.future.graceful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author chenkun
 * @version 1.0
 * @description 缓冲区测试类
 * @date 2022/1/6 15:34
 */
@RunWith(JUnit4.class)
public class BufferTest {

    @Test
    public void bufferTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] data = "hello".getBytes(StandardCharsets.UTF_8);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.put(data);
        System.out.println("---------put---------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.flip();
        System.out.println("---------flip---------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] result = new byte[1024];
        byteBuffer.get(result,0,byteBuffer.limit());
        System.out.println("---------get---------");
        System.out.println(new String(result));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.rewind();
        System.out.println("---------rewind---------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.get(result,0,byteBuffer.limit());
        System.out.println("---------get---------");
        System.out.println(new String(result));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }

    @Test
    public void bufferTest2() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] data = "hello".getBytes(StandardCharsets.UTF_8);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.put(data);
        System.out.println("---------put---------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.flip();
        System.out.println("---------flip---------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byte[] dist = new byte[byteBuffer.limit()];
        byteBuffer.get(dist,0,3);
        System.out.println("---------get---------");
        System.out.println(new String(dist));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.mark();

        byte[] result = new byte[byteBuffer.limit()];
        if(byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.remaining());
            byteBuffer.get(result,byteBuffer.position(),byteBuffer.remaining());
        }
        System.out.println("---------get---------");
        System.out.println(new String(result).trim());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.reset();
        System.out.println("---------reset---------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.get(result,byteBuffer.position(),byteBuffer.remaining());
        System.out.println("---------get---------");
        System.out.println(new String(result).trim());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        byteBuffer.clear();
        System.out.println("--------clear--------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
}
