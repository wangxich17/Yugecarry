package com.monflood;
import java.io.File;
import java.util.List;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Segmentation {
    //            按年分段
    public void SegmentationYear(List<TestData> list,File file,String outputpath){
        int count_year=0;
        String before_year=new String();
        for(int cnt_year=0;cnt_year<list.size();cnt_year++){
            TestData testdata_day=list.get(cnt_year);
            if(count_year==0){
                String item_year[]=testdata_day.getAttribute1().toString().split(" ");
                String t_before_year[]=item_year[0].split("-");
                before_year=t_before_year[0];
                ++count_year;
            }
            else{
                String item_year[]=testdata_day.getAttribute1().toString().split(" ");
                String t_before_year[]=item_year[0].split("-");
                if(!before_year.equals(t_before_year[0])) {
                    before_year = t_before_year[0];
                    ++count_year;
                }
            }
            String item_year[] = file.toString().split("\\\\");
            File file_month = new File(outputpath+"\\"+item_year[item_year.length-1]+"\\year");
            if(!file_month.exists()){
                file_month.mkdirs();
            }
            String output=new String(outputpath+"\\"+item_year[item_year.length-1]+"\\year\\"+before_year+".csv");
            try {
                File csv = new File(output); // CSV数据文件
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
                // 添加新的数据行
                bw.write(testdata_day.getAttribute0()+","+testdata_day.getAttribute1()+","+testdata_day.getAttribute2()+","+testdata_day.getAttribute3()+","+testdata_day.getAttribute4()+","+testdata_day.getAttribute5()+","+testdata_day.getAttribute6()+","+testdata_day.getAttribute7()+","+testdata_day.getAttribute8()+","+testdata_day.getAttribute9());
                bw.newLine();
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
    //            按月分段
    public void SegmentationMonth(List<TestData> list, File file, String outputpath){
        int count_month=0;
        String before_month=new String();
        String t_before_month[];
        for(int cnt_day=0;cnt_day<list.size();cnt_day++) {
            TestData testdata_day = list.get(cnt_day);
            if (count_month == 0) {
                String item_month[] = testdata_day.getAttribute1().toString().split(" ");
                t_before_month = item_month[0].split("-");
                before_month = t_before_month[1];
                ++count_month;
            } else {
                String item_month[] = testdata_day.getAttribute1().toString().split(" ");
                t_before_month = item_month[0].split("-");
                if (!before_month.equals(t_before_month[1])) {
                    before_month = t_before_month[1];
                    ++count_month;
                }
            }
            String item_year[] = file.toString().split("\\\\");
            File file_month = new File(outputpath + "\\" + item_year[item_year.length - 1] + "\\month\\" + t_before_month[0]);
            if (!file_month.exists()) {
                file_month.mkdirs();
            }
            String output = new String(outputpath + "\\" + item_year[item_year.length - 1] + "\\month\\" + t_before_month[0] + "\\" + before_month + ".csv");
            try {
                File csv = new File(output); // CSV数据文件
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
                // 添加新的数据行
                bw.write(testdata_day.getAttribute0() + "," + testdata_day.getAttribute1() + "," + testdata_day.getAttribute2() + "," + testdata_day.getAttribute3() + "," + testdata_day.getAttribute4() + "," + testdata_day.getAttribute5() + "," + testdata_day.getAttribute6() + "," + testdata_day.getAttribute7() + "," + testdata_day.getAttribute8() + "," + testdata_day.getAttribute9());
                bw.newLine();
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
    public void SegmentationDay(List<TestData> list, File file, String outputpath){
        //            按天分段
        int count_day=0;
        String before_day=new String();
        String item2[] = file.toString().split("\\\\");
        File file2 = new File(outputpath+"\\"+item2[item2.length-1]+"\\day");
        if(!file2.exists()){
            file2.mkdirs();
        }
        for(int cnt_day=0;cnt_day<list.size();cnt_day++){
            TestData testdata_day=list.get(cnt_day);
            if(count_day==0){
                String item_day[]=testdata_day.getAttribute1().toString().split(" ");
                before_day=item_day[0];
                String item_year[]=before_day.split("-");
                ++count_day;
            }
            else{
                String item_day[]=testdata_day.getAttribute1().toString().split(" ");
                if(!before_day.equals(item_day[0])) {
                    before_day = item_day[0];
                    ++count_day;
                }
            }
            String output=new String(outputpath+"\\"+item2[item2.length-1]+"\\day\\"+before_day+".csv");
            try {
                File csv = new File(output); // CSV数据文件
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
                // 添加新的数据行
                bw.write(testdata_day.getAttribute0()+","+testdata_day.getAttribute1()+","+testdata_day.getAttribute2()+","+testdata_day.getAttribute3()+","+testdata_day.getAttribute4()+","+testdata_day.getAttribute5()+","+testdata_day.getAttribute6()+","+testdata_day.getAttribute7()+","+testdata_day.getAttribute8()+","+testdata_day.getAttribute9());
                bw.newLine();
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
//    按小时分段
    public void SegmentationHour(List<TestData> list,File file,String outputpath){
        int count_hour=0;
        String before_hour=new String();
        String before_date=new String();
        for(int cnt_hour=0;cnt_hour<list.size();cnt_hour++) {
            TestData testdata_day = list.get(cnt_hour);
            if (count_hour == 0) {
                String item_hour[] = testdata_day.getAttribute1().toString().split(" ");
                before_date = item_hour[0];
                String t_item_hour[] = item_hour[1].split(":");
                before_hour = t_item_hour[0];
                ++count_hour;
//                System.out.printf("%s\n%s\n%s\n", before_date, item_hour[1], before_hour);
            } else {
                String item_hour[] = testdata_day.getAttribute1().toString().split(" ");
                String t_item_hour[] = item_hour[1].split(":");
                if (!before_hour.equals(t_item_hour[0])) {
                    before_hour = t_item_hour[0];
                    before_date = item_hour[0];
                    ++count_hour;
                }
            }
            String file_item_hour[] = file.toString().split("\\\\");
            File file_hour = new File(outputpath + "\\" + file_item_hour[file_item_hour.length - 1] + "\\hour\\" + before_date);
            if (!file_hour.exists()) {
                file_hour.mkdirs();
            }
            String output = new String(file_hour + "\\" + before_hour + ".csv");
            try {
                File csv = new File(output); // CSV数据文件
                BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); // 附加
                // 添加新的数据行
                bw.write(testdata_day.getAttribute0() + "," + testdata_day.getAttribute1() + "," + testdata_day.getAttribute2() + "," + testdata_day.getAttribute3() + "," + testdata_day.getAttribute4() + "," + testdata_day.getAttribute5() + "," + testdata_day.getAttribute6() + "," + testdata_day.getAttribute7() + "," + testdata_day.getAttribute8() + "," + testdata_day.getAttribute9());
                bw.newLine();
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
}
