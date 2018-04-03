package com.monflood;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadWrite {
    public List Read(String inputpath) {
        List<TestData> list = new ArrayList<TestData>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputpath));
            String line = null;
            while((line=reader.readLine())!=null){
                String item[] = line.split(",");
                StringBuffer temp=new StringBuffer("");
                for(int j=9;j<item.length;j++){
                    temp.append(item[j]);
                    if(j!=item.length-1){
                        temp.append(",");
                    }
                }
                list.add(new TestData(item[0],item[1],item[2],item[3],item[4],item[5],item[6],item[7],item[8],temp.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void Write(String outputpath, List<TestData> list, String inputpath){
        String item_file[] = inputpath.split("\\\\");
        File file_sort = new File(outputpath+"\\sort");
            if(!file_sort.exists()){
                file_sort.mkdirs();
            }
            try {
                File csv = new File(outputpath+"\\sort\\sort_"+item_file[item_file.length-1]); // CSV数据文件
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
                // 添加新的数据行
                for(int j=0;j<list.size();j++){
                    TestData testdata=list.get(j);
                    bw.write(testdata.getAttribute0()+","+testdata.getAttribute1()+","+testdata.getAttribute2()+","+testdata.getAttribute3()+","+testdata.getAttribute4()+","+testdata.getAttribute5()+","+testdata.getAttribute6()+","+testdata.getAttribute7()+","+testdata.getAttribute8()+","+testdata.getAttribute9());
                    bw.newLine();
                }
                bw.close();
            } catch (FileNotFoundException e) {
                // File对象的创建过程中的异常捕获
                e.printStackTrace();
            } catch (IOException e) {
                // BufferedWriter在关闭对象捕捉异常
                e.printStackTrace();
            }
    }
}
