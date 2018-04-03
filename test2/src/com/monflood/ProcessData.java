package com.monflood;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ProcessData {
    public void ProcessDataCsv(String inputpath) {
        List<TestData> list = new ArrayList<TestData>();
        List list5 = new ArrayList<String>();
        List list6 = new ArrayList<String>();
        List list7 = new ArrayList<String>();
        List list8 = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputpath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                StringBuffer line_tail = new StringBuffer("");
                for (int j = 9; j < item.length; j++) {
                    line_tail.append(item[j]);
                    if (j != item.length - 1) {
                        line_tail.append(",");
                    }
                }
                list5.add(item[5]);
                list6.add(item[6]);
                list7.add(item[7]);
                list8.add(item[8]);
                list.add(new TestData(item[0], item[1], item[2], item[3], item[4], item[5], item[6], item[7], item[8], line_tail.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        GetAverageandVariance avg_var=new GetAverageandVariance();
//        计算均值和方差
        double avg5=avg_var.getAverage(list5);
        double var5=avg_var.getVariance(list5);
        double avg6=avg_var.getAverage(list6);
        double var6=avg_var.getVariance(list6);
        double avg7=avg_var.getAverage(list7);
        double var7=avg_var.getVariance(list7);
        double avg8=avg_var.getAverage(list8);
        double var8=avg_var.getVariance(list8);
        String item_file[] =inputpath.split("\\\\");
        StringBuffer outputpath=new StringBuffer();
        for(int i=0;i<item_file.length-1;i++){
            outputpath.append(item_file[i]);
            outputpath.append("\\");
        }
        outputpath.append("avg_var_");
        outputpath.append(item_file[item_file.length-1]);
        try {
            File csv = new File(outputpath.toString()); // CSV数据文件
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
            // 添加新的数据行
            for(int j=0;j<list.size();j++){
                TestData testdata=list.get(j);
                bw.write(testdata.getAttribute0()+","+testdata.getAttribute1()+","+testdata.getAttribute2()+","+testdata.getAttribute3()+","+testdata.getAttribute4()+","+testdata.getAttribute5()+","+testdata.getAttribute6()
                        +","+testdata.getAttribute7()+","+testdata.getAttribute8()+"," +testdata.getAttribute9()+","+String.valueOf(avg5)+","+String.valueOf(var5)+","+String.valueOf(avg6)+","+String.valueOf(var6)
                        +","+String.valueOf(avg7)+","+String.valueOf(var7) +","+String.valueOf(avg8)+","+String.valueOf(var8));
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
