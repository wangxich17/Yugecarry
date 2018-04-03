package com.monflood;
import java.util.List;
public class GetAverageandVariance {
    public double getAverage(List list) {
        double sum=0;
        for(int i=0;i<list.size();i++){
            sum=sum+Double.parseDouble(list.get(i).toString());
        }
        return sum/list.size();
    }
    public double getVariance(List list) {
        double avg=getAverage(list);
        double sd=0;
        for(int i=0;i<list.size();i++){
            sd=(avg-Double.parseDouble(list.get(i).toString()))*(avg-Double.parseDouble(list.get(i).toString()));
        }
        return sd/list.size();
    }
}

