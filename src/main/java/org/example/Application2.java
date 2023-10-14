package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Application2  {
    public static void main(String[] args) throws Exception {
        Configuration cf=new Configuration();
        cf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fileSystem=FileSystem.get(cf);
        Path path=new Path("/home/soufiane/hadoop/file");
        FSDataOutputStream fsDataOutputStream = fileSystem.create(path,true);
//        FSDataOutputStream fsDataOutputStream = fileSystem.append(path,true);
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));
        writer.write("SDIA 2");
        writer.newLine();
        writer.write("SDIA 2");
        writer.newLine();
        writer.close();
        fileSystem.close();
        fsDataOutputStream.close();
    }
}
