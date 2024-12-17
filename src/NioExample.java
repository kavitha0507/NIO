import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {
    public static void main(String[] args)  throws IOException
    {
        String[] inputFiles = {"C:\\Users\\kavit\\Downloads\\NIO.txt ",
                "C:\\Users\\kavit\\Downloads\\NIO.txt"};

        String outputFile = "C:\\Users\\kavit\\Downloads\\NioOutput.txt";
        FileOutputStream fos = new FileOutputStream(outputFile);
        FileChannel targetChannel = fos.getChannel();
        for (int i = 0; i < inputFiles.length; i++) {
            // Get channel for inputFiles
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputchannel = fis.getChannel();
            long size = inputchannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int) size);
            System.out.print((char) buf.get());
            while (inputchannel.read(buf) > 0) {
                buf.flip();
                while (buf.hasRemaining()) {
                     System.out.print((char) buf.get());
                    targetChannel.write(buf);
                }
            }

        }
    }
}

