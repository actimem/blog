package com.actimem.blog.nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferExampleTest {

    @Test
    public void putBytes() {
        // Create the buffer
        ByteBuffer buffer = ByteBuffer.allocate(6);

        // Add three bytes
        buffer.put((byte) 10).put((byte) 11).put((byte) 12);

        // Add another byte
        buffer.put((byte) 13);

        buffer.flip();

        buffer.get(4);

        System.out.println(buffer.get());
        while (buffer.hasRemaining())
            System.out.println(buffer.get());

        buffer.clear();

        System.out.println(buffer);
    }

    @Test
    public void putBytesBuild() {
        ByteBuffer buffer = ByteBuffer.allocate(6);

        byte[] data = new byte[] {(byte) 10, (byte) 11, (byte) 12};
        buffer.put(data);

        buffer.flip();

        byte[] readData = new byte[buffer.remaining()];
        buffer.get(readData);

    }

    @Test
    public void putFlipAndRead() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        System.out.println("Empty:  " + toDetails(byteBuffer));

        byteBuffer.put((byte) 0).put((byte) 1).put((byte) 2);
        System.out.println("Put 3:  " + toDetails(byteBuffer));

        // Flip to get buffer ready for reading
        byteBuffer.flip();
        System.out.println("Flip:   " + toDetails(byteBuffer));

        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println("Read 3:  " + toDetails(byteBuffer));
    }

    @Test
    public void rewind() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        System.out.println("Empty:  " + toDetails(byteBuffer));

        byteBuffer.put((byte) 0).put((byte) 1).put((byte) 2);
        System.out.println("Put 3:  " + toDetails(byteBuffer));

        // Flip to get buffer ready for reading
        byteBuffer.flip();
        System.out.println("Flip:   " + toDetails(byteBuffer));

        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println("Read 3:  " + toDetails(byteBuffer));

        // Rewinding to read again
        byteBuffer.rewind();
        System.out.println("Rewind:  " + toDetails(byteBuffer));
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println("Re-read: " + toDetails(byteBuffer));

    }

    @Test
    public void flipTwice() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        System.out.println("Empty:  " + toDetails(byteBuffer));

        byteBuffer.put((byte) 0).put((byte) 1).put((byte) 2);
        System.out.println("Put 3:  " + toDetails(byteBuffer));

        // Flip to get buffer ready for reading
        byteBuffer.flip();
        System.out.println("Flip:   " + toDetails(byteBuffer));

        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println("Read 2:  " + toDetails(byteBuffer));

        // Flip again - limit set to 2 (current position). Not what we want
        byteBuffer.flip();
        System.out.println("Flip:    " + toDetails(byteBuffer));

        byteBuffer.put((byte) 0).put((byte) 1);
        System.out.println("Flip:    " + toDetails(byteBuffer));

        byteBuffer.put((byte) 2);
    }

    @Test
    public void clear() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        System.out.println("Empty:  " + toDetails(byteBuffer));

        byteBuffer.put((byte) 0).put((byte) 1).put((byte) 2);
        System.out.println("Put 3:  " + toDetails(byteBuffer));

        // Flip to get buffer ready for reading
        byteBuffer.flip();
        System.out.println("Flip:   " + toDetails(byteBuffer));

        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println("Read 2: " + toDetails(byteBuffer));

        // Clear buffer, limit set to capacity, buffer ready for new cycle.
        byteBuffer.clear();
        System.out.println("Flip:   " + toDetails(byteBuffer));
    }

    @Test
    public void allocateDirect() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6);
        System.out.println(toDetails(byteBuffer));

        byteBuffer.put((byte) 0).put((byte) 1).put((byte) 2);
        System.out.println(toDetails(byteBuffer));
    }

    @Test
    public void wrapByteArray() {
        byte[] bytes = new byte[6];
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);

        byteBuffer.put((byte) 10).put((byte) 11).put((byte) 12);

        System.out.println(bytes[0]);
        System.out.println(bytes[1]);
        System.out.println(bytes[2]);
    }

    @Test
    public void wrapByteArrayOffset() {
        byte[] bytes = new byte[10];
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes, 2, 5);
        System.out.println(toDetails(byteBuffer));

        byteBuffer.put((byte) 10).put((byte) 11).put((byte) 12);
        System.out.println(toDetails(byteBuffer));

        byteBuffer.flip();
        System.out.println(toDetails(byteBuffer));

        System.out.println(bytes[0]);
        System.out.println(bytes[1]);
        System.out.println(bytes[2]);
    }

    @Test
    public void markAndReset() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.put((byte) 10).put((byte) 11).put((byte) 12).put((byte) 13).put((byte) 14);

        byteBuffer.flip().position(1).mark().position(3);
        System.out.println("After Mark:  " + toDetails(byteBuffer));
        while (byteBuffer.hasRemaining())
            System.out.println(byteBuffer.get());


        byteBuffer.reset();
        System.out.println("After Reset:  " + toDetails(byteBuffer));
        while (byteBuffer.hasRemaining())
            System.out.println(byteBuffer.get());
    }

    @Test
    public void duplicate() {
        
    }

    private String toDetails(Buffer buffer) {
        return String.format("pos=%d lim=%d cap=%d remaining=%d",
                buffer.position(), buffer.limit(), buffer.capacity(), buffer.remaining());
    }

}