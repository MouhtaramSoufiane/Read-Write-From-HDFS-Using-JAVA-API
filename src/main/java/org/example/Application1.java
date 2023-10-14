package org.example;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Application1 {
    public static void main(String[] args) throws IOException {
        Configuration cf=new Configuration();
        cf.set("fs.defaultFS","hdfs://localhost:9000");
        FileSystem fileSystem=FileSystem.get(cf);
        Path path=new Path("/home/soufiane/hadoop/file");
        FSDataInputStream fsDataInputStream=fileSystem.open(path);
        BufferedReader reader=new BufferedReader(new InputStreamReader(fsDataInputStream, StandardCharsets.UTF_8));
        String ligne=null;
        fileSystem.open(path);
        while ((ligne=reader.readLine())!=null){
            System.out.println(ligne);
        }
        fsDataInputStream.close();
        fileSystem.close();
    }
}
