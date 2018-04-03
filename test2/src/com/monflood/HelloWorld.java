package com.monflood;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class HelloWorld {
    public static void main(String[] args) {
        String inputpath=new String("D:\\jinfeng\\");
        String outputpath=new String("D:\\new_jinfeng\\");
        System.out.printf("The currently processed data is located:%s\n",inputpath);
        File dir = new File(inputpath);
        File[] files = dir.listFiles();
        for(int i=0;i<files.length;i++){
            System.out.printf("The file path that is being processed:%s\n",files[i]);
            System.out.printf("Read:%s\n",files[i]);
            ReadWrite readwrite=new ReadWrite();
            List<TestData> list=readwrite.Read(files[i].toString());
            System.out.printf("sort:%s\n",files[i]);
            SortClass sortClass = new SortClass();
            Collections.sort(list, sortClass);
            System.out.printf("Write:%s after sorting\n",files[i]);
            readwrite.Write(outputpath,list,files[i].toString());
            System.out.printf("segmenting the:%s by hour,day,month,year\n",files[i]);
            Segmentation test_seg=new Segmentation();
            test_seg.SegmentationYear(list,files[i],outputpath);
            test_seg.SegmentationMonth(list,files[i],outputpath);
            test_seg.SegmentationDay(list,files[i],outputpath);
            test_seg.SegmentationHour(list,files[i],outputpath);
        }
        System.out.printf("TraverseFolder and .GetFlilesPath\n");
        TraverseFolder traversefolder=new TraverseFolder();
        List listfiles=traversefolder.GetFlilesPath(outputpath);
        System.out.printf("Processing each of the files in listfies\n");
        ProcessData precessdata=new ProcessData();
        for(int i=0;i<listfiles.size();i++){
            System.out.printf("Processing the file:%s\n",listfiles.get(i));
            precessdata.ProcessDataCsv(listfiles.get(i).toString());
        }
    }
}
