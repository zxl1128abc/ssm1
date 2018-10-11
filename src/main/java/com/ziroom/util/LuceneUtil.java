package com.ziroom.util;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class LuceneUtil {
    private static IndexWriter indexWriter;
    private static String indexUrl="";
    private static IndexReader indexReader;

    public static IndexWriter getIndexWriter(String path) throws IOException {
        //指定索引库的路径并获得Directory
        //如果索引地址发生变化 重新 创建indexWriter 如果索引库没有发生变化并且indexWriter已经创建直接返回
        boolean flag = path.equals(indexUrl);
        if(indexWriter==null||!flag){
            FSDirectory fsDirectory = FSDirectory.open(Paths.get(path));
            indexUrl=path;

            //indexWriter = new IndexWriter(fsDirectory,new IndexWriterConfig(new IKAnalyzer(true)));

        }
        return indexWriter;
    }

    public static  IndexReader getIndexReader(String path) throws IOException {
       //1.indexReader为NULL
        //2.indexReader不为null 但是地址发生变化
        //3.当索引发生变化时
        boolean flag=path.equals(indexUrl);
        if(indexReader==null||!flag){
            FSDirectory fsDirectory = FSDirectory.open(Paths.get(path));
            indexUrl=path;
            indexReader= DirectoryReader.open(fsDirectory);
        }else{
            //只有发生变化时  reader 才不会为null
            DirectoryReader directoryReader = DirectoryReader.openIfChanged((DirectoryReader) indexReader);
            if(directoryReader!=null){
                indexReader=directoryReader;
            }
        }
        return indexReader;
    }


}
