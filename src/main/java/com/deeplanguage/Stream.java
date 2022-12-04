package com.deeplanguage;

import java.io.*;
import java.net.URI;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * @Author: drainli
 **/
public class Stream {

    private static final Logger log = Logger.getLogger("Stream.test") ;

    public static void main(String[] args) {
//        String fromPath = "/home/drainli/hello.txt" ;
//        String toPath = "bar.txt" ;
//        move(fromPath,toPath);
        String rootPath = "/home/drainli/Videos" ;
       // String pattern = "*.zip" ;
       // listDir(rootPath,"*");
       // listFilesByTree(rootPath);
//
    //    listCharsets() ;
    }

    private static void move(String fromPath,String toPath) {
        FileSystem fs = FileSystems.getDefault() ;
        Path from = fs.getPath(fromPath) ;
        try {
            Path movePath = Files.move(from,from.resolveSibling(fs.getPath(toPath))) ;
            log.info(movePath.getFileName()+"");
        } catch (IOException e) {
            Logger.global.warning("error occured when moving the path to another path");
            e.printStackTrace();
        }
    }

    private static void print(){
        PrintStream printStream = System.out ;
        DataInputStream dataInputStream = new DataInputStream(System.in) ;
        try {
            File file = new File("/home/drainli/hello.txt") ;
            if (!file.exists()){
                //  InputStream
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file) ;
            PrintWriter printWriter = new PrintWriter(fileOutputStream) ;
            // 使用打印流的一个最大的好处就是免于遭受底层流抛出的异常
            printWriter.println("hello world");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listDir(String rootPath,String pattern) throws IOException {
        FileSystem fs = FileSystems.getDefault() ;
        // 开启一个文件共享锁
        FileLock lock = new RandomAccessFile(rootPath,"rw").getChannel().lock(0,100,true) ;
        File file = new File(rootPath) ;
        if (!file.isDirectory()){
            return;
        }
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(fs.getPath(rootPath),pattern) ;
            directoryStream.forEach(path -> {
                if (path.toFile().isDirectory()){
                    try {
                        listDir(path.toFile().getPath(),pattern);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                log.info(path+"");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  FileVisitor
     **/
    private static void listFilesByTree(String root){
        FileSystem fs = FileSystems.getDefault() ;
        try {
            Files.walkFileTree(fs.getPath(root), new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    log.info(file+"");
                    return FileVisitResult.CONTINUE ;
                }
            }) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void uriZip(String path){
        URI zipUri = URI.create("file:/home/drainli/file/zip.txt") ;
        Map<String,String> env = new ConcurrentHashMap<>() ;
        env.put("create","true") ;
        try(FileSystem fs = FileSystems.newFileSystem(zipUri,env)) {

            Path writePath = fs.getPath("/home/drainli/file/bar.txt") ;
            OutputStream out = Files.newOutputStream(writePath) ;
            try(PrintWriter writer = new PrintWriter(out)) {
                writer.println("hello batr.txt !");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listCharsets() {
         Map charsets = Charset.availableCharsets() ;
         charsets.keySet().forEach(charset -> {
             System.out.println(charset);
         }) ;
    }


}
