package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.SingleValueDataSet;
import com.anychart.charts.LinearGauge;
import com.anychart.enums.Anchor;
import com.anychart.enums.Layout;
import com.anychart.enums.MarkerType;
import com.anychart.enums.Orientation;
import com.anychart.enums.Position;
import com.anychart.scales.OrdinalColor;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class MessageFragmentReport extends Fragment {

    LineChart chart;
    Dialog mydialog1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_report, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//for on back pressed
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("forOnBack",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Back","OK");
        editor.apply();
//for on back pressed over

//      screen on
        SharedPreferences sharedPreferencesScreen = getActivity().getSharedPreferences("screen",MODE_PRIVATE);
        String screen= (String) sharedPreferencesScreen.getString("ON", String.valueOf(MODE_PRIVATE));
        if (screen.equals("True")){
            Toast.makeText(getActivity(), "ok screen on", Toast.LENGTH_SHORT).show();
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }else {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
//        screen on over
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        mydialog1= new Dialog(getActivity());

/***********for bmi value*************/
        final TextView bmiresult = getView().findViewById(R.id.textView12);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("BMI", MODE_PRIVATE);
        String valo= (String) sharedPreferences.getString("finishBMI", String.valueOf(MODE_PRIVATE));
        bmiresult.setText(valo);

//        height
        final TextView CurrentHeight = getView().findViewById(R.id.currentHeight);
        SharedPreferences sharedPreferencesHeight = this.getActivity().getSharedPreferences("HEIGHT", MODE_PRIVATE);
        String valoHeight= (String) sharedPreferencesHeight.getString("finishHEIGHT", String.valueOf(MODE_PRIVATE));
        CurrentHeight.setText(valoHeight);

//        weight
        final TextView CurrentWeight = getView().findViewById(R.id.currentweight);
        SharedPreferences sharedPreferencesWeight = this.getActivity().getSharedPreferences("WEIGHT", MODE_PRIVATE);
        String valoWeight= (String) sharedPreferencesWeight.getString("finishWEIGHT", String.valueOf(MODE_PRIVATE));
        CurrentWeight.setText(valoWeight);

//        unit
        Spanned BMIunit = Html.fromHtml("BMI(Kg/m<sup>2</sup>) :");
        TextView unit = getView().findViewById(R.id.BMIunit);
        unit.setText(BMIunit);
/*********for bmi value over*********/

//       *************** bar chart
        chart = (LineChart) getView().findViewById(R.id.linechart);

        chart.zoom(2f,1f,2f,1f);
        chart.setScaleEnabled(true);
        chart.setDragXEnabled(true);
        chart.setDragYEnabled(false);

        ArrayList<Entry> yvalues = new ArrayList<>();

        yvalues.add(new Entry(1, 60f));
        yvalues.add(new Entry(2, 50f));
        yvalues.add(new Entry(3, 40f));
        yvalues.add(new Entry(4, 30f));
        yvalues.add(new Entry(5, 20f));
        yvalues.add(new Entry(6, 10f));
        yvalues.add(new Entry(7, 5f));
        yvalues.add(new Entry(8, 0f));

        LineDataSet set1 = new LineDataSet(yvalues, "Data set 1");

        set1.setFillAlpha(110);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        chart.setData(data);

        int red = Color.parseColor("#000000");
        chart.setBorderColor(red);
        chart.setBorderWidth(1f);
        chart.setDrawBorders(true);
        set1.setColor(Color.RED);
        set1.setLineWidth(2f);
        set1.setValueTextSize(15f);
        set1.setValueTextColor(Color.BLACK);
        set1.setCircleHoleColor(Color.WHITE);
        set1.setCircleRadius(10f);
        set1.setCircleHoleRadius(5f);

        // the labels that should be drawn on the XAxis
        final String[] quarters = new String[] { "Q1", "Q2", "Q3", "Q4", "Q2", "Q3", "Q4", "Q2", "Q3", "Q4" };
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
        xAxis.setValueFormatter(formatter);

//        *************bar chart
//        ********************************************************************************************************************
        //        ********BMI BAR
        AnyChartView anyChartView = getView().findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(getView().findViewById(R.id.progress_bar));

        LinearGauge linearGauge = AnyChart.linear();
//      BMI index
        String nome = valo+"D";
//      BMI index
        linearGauge.data(new SingleValueDataSet(new Double[] {Double.valueOf(nome)}));

        linearGauge.layout(Layout.HORIZONTAL);

//        linearGauge.label(0)
//                .position(Position.LEFT_CENTER)
//                .anchor(Anchor.LEFT_CENTER)
//                .offsetY("-50px")
//                .offsetX("50px")
//                .fontColor("black")
//                .fontSize(17);
//        linearGauge.label(0).text("Total Rainfall");

        linearGauge.label(1)
                .position(Position.CENTER)
                .anchor(Anchor.CENTER)
                .offsetY("45px")
                .offsetX("0px").fontOpacity(0.7).fontWeight(600)
                .fontSize(17);

        Double BMIvalo = Double.valueOf(valo);
        if (BMIvalo>=15&&BMIvalo<=16){
            linearGauge.label(1).text("Severely underweight");
            linearGauge.label(1).fontColor("cyan");
        }else if (BMIvalo>16&&BMIvalo<=18.5){
            linearGauge.label(1).text("Underweight");
            linearGauge.label(1).fontColor("blue");
        }else if (BMIvalo>18.5&&BMIvalo<=25){
            linearGauge.label(1).text("Healthy weight");
            linearGauge.label(1).fontColor("green");
        }else if (BMIvalo>25&&BMIvalo<=30){
            linearGauge.label(1).text("Obese");
            linearGauge.label(1).fontColor("YELLOW");
        }else if (BMIvalo>30&&BMIvalo<=35){
            linearGauge.label(1).text("Moderaately obese");
            linearGauge.label(1).fontColor("orange");
        }else if (BMIvalo>35&&BMIvalo<=40){
            linearGauge.label(1).text("Severely obese");
            linearGauge.label(1).fontColor("red");
        }else {
            linearGauge.label(1).text("None");
            linearGauge.label(1).fontColor("Black");
        }



        OrdinalColor scaleBarColorScale = OrdinalColor.instantiate();
        scaleBarColorScale.ranges(new String[]{
                "{ from: 15, to: 16, color: ['cyan 0.7'] }",
                "{ from: 16, to: 18.5, color: ['blue 0.7'] }",
                "{ from: 18.5, to: 25, color: ['green 0.7'] }",
                "{ from: 25, to: 30, color: ['YELLOW 0.7'] }",
                "{ from: 30, to: 35, color: ['orange 0.7'] }",
                "{ from: 35, to: 40, color: ['red 0.7']}"
        });

        linearGauge.scaleBar(0)
                .width("30%")
                .colorScale(scaleBarColorScale);

        linearGauge.marker(0)
                .type(MarkerType.LINE)
                .color("black")
                .offset("-3.5%")
                .zIndex(10).width("10");

        linearGauge.scale()
                .minimum(15)
                .maximum(40);
//        linearGauge.scale().ticks

        linearGauge.axis(0)
                .minorTicks(false)
                .width("1%");
        linearGauge.axis(0)
                .offset("-1.5%")
                .orientation(Orientation.TOP)
                .labels("top");

        linearGauge.padding(0, 20, 0, 20);

        anyChartView.setChart(linearGauge);
//        ***********BMI BAR
        edit();
    }



    public void edit(){
        Button open15 = getActivity().findViewById(R.id.textView15);
        open15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog1.setContentView(R.layout.weight_height_cal);
                mydialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mydialog1.show();

                loadData1();
            }
        });

    }



    //    *********************loaddata for BMI popup height and weight
    int kgno = 1;
    int lbno = 2;
    int cmno = 1;
    int inno = 2;

    int no1=0;
    int no2=0;
    int no3=0;
    int no4=0;
    public void loadData1(){
        final EditText weight = mydialog1.findViewById(R.id.edit1);
        final EditText height = mydialog1.findViewById(R.id.edit2);
        final TextView bmiresult = getView().findViewById(R.id.textView12);
        final Button kg = (Button)mydialog1.findViewById(R.id.kg);
        final Button lb =(Button) mydialog1.findViewById(R.id.lb);
        final Button cm = (Button)mydialog1.findViewById(R.id.cm);
        final Button in = (Button)mydialog1.findViewById(R.id.in);
        Button save = mydialog1.findViewById(R.id.save);
        Button cancel = mydialog1.findViewById(R.id.cancel);

        if (kgno==1&&cmno==1){
            kg.setBackgroundResource(R.drawable.but_bl);
            kg.setTextColor(Color.WHITE);
            cm.setBackgroundResource(R.drawable.but_bl);
            cm.setTextColor(Color.WHITE);
            no1=1;
            no3=1;
            no4=0;
            no2=0;
        }



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog1.dismiss();

//        BMI formula lb*703 + height(in*in)
//        kg/m*m

                Double hei = Double.valueOf(String.valueOf(height.getText()));
                Double wei = Double.valueOf(String.valueOf(weight.getText()));
                final TextView currentHeight = getView().findViewById(R.id.currentHeight);
                final TextView currentweight = getView().findViewById(R.id.currentweight);


                if (hei <= 0 || wei <= 0) {

                    String result = "0.0";
                    bmiresult.setText(result);
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BMI", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("finishBMI",result);
                    editor.apply();

                    SharedPreferences sharedPreferencesHeight = getActivity().getSharedPreferences("HEIGHT", MODE_PRIVATE);
                    SharedPreferences.Editor editorHeight = sharedPreferencesHeight.edit();
                    editorHeight.putString("finishHEIGHT","None");
                    editorHeight.apply();
                    currentHeight.setText("NONE");

                    SharedPreferences sharedPreferencesWeight = getActivity().getSharedPreferences("WEIGHT", MODE_PRIVATE);
                    SharedPreferences.Editor editorWeight = sharedPreferencesWeight.edit();
                    editorWeight.putString("finishWEIGHT","None");
                    editorWeight.apply();
                    currentweight.setText("NONE");
                } else {
//                 kg and cm
                    if (no1 == 1 && no3 == 1) {

                        Double heire = hei / 100;
                        Double bmi = wei / (heire * heire);
                        Double finalbmi = BigDecimal.valueOf(bmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        bmiresult.setText(finalbmi.toString());

                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BMI", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("finishBMI",finalbmi.toString());
                        editor.apply();

                        SharedPreferences sharedPreferencesHeight = getActivity().getSharedPreferences("HEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorHeight = sharedPreferencesHeight.edit();
                        editorHeight.putString("finishHEIGHT",hei.toString()+" CM");
                        editorHeight.apply();
                        currentHeight.setText(hei+" CM");

                        SharedPreferences sharedPreferencesWeight = getActivity().getSharedPreferences("WEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorWeight = sharedPreferencesWeight.edit();
                        editorWeight.putString("finishWEIGHT","NONE");
                        editorWeight.apply();
                        currentweight.setText(wei+" Kg");

                    }
//                 kg and in
                    if (no1 == 1 && no4 == 1) {
                        Double heire = hei * 0.0254;
                        Double bmi = wei / (heire * heire);
                        Double finalbmi = BigDecimal.valueOf(bmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        bmiresult.setText(finalbmi.toString());

                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BMI", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("finishBMI",finalbmi.toString());
                        editor.apply();

                        SharedPreferences sharedPreferencesHeight = getActivity().getSharedPreferences("HEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorHeight = sharedPreferencesHeight.edit();
                        editorHeight.putString("finishHEIGHT",hei.toString()+" CM");
                        editorHeight.apply();
                        currentHeight.setText(hei+" IN");

                        SharedPreferences sharedPreferencesWeight = getActivity().getSharedPreferences("WEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorWeight = sharedPreferencesWeight.edit();
                        editorWeight.putString("finishWEIGHT","NONE");
                        editorWeight.apply();
                        currentweight.setText(wei+" Kg");
                    }
//                 lb and cm
                    if (no2 == 1 && no3 == 1) {
                        Double heire = hei * 0.394;
                        Double bmi = 703 * wei / (heire * heire);
                        Double finalbmi = BigDecimal.valueOf(bmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        bmiresult.setText(finalbmi.toString());

                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BMI", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("finishBMI",finalbmi.toString());
                        editor.apply();

                        SharedPreferences sharedPreferencesHeight = getActivity().getSharedPreferences("HEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorHeight = sharedPreferencesHeight.edit();
                        editorHeight.putString("finishHEIGHT",hei.toString()+" CM");
                        editorHeight.apply();
                        currentHeight.setText(hei+" CM");

                        SharedPreferences sharedPreferencesWeight = getActivity().getSharedPreferences("WEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorWeight = sharedPreferencesWeight.edit();
                        editorWeight.putString("finishWEIGHT","NONE");
                        editorWeight.apply();
                        currentweight.setText(wei+" lbs");
                    }
//                 lb and in
                    if (no2 == 1 && no4 == 1) {
                        Double heire = hei;
                        Double bmi = wei * 703 / (heire * heire);
                        Double finalbmi = BigDecimal.valueOf(bmi).setScale(2, RoundingMode.HALF_UP).doubleValue();
                        bmiresult.setText(finalbmi.toString());

                        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("BMI", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("finishBMI",finalbmi.toString());
                        editor.apply();

                        SharedPreferences sharedPreferencesHeight = getActivity().getSharedPreferences("HEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorHeight = sharedPreferencesHeight.edit();
                        editorHeight.putString("finishHEIGHT",hei.toString()+" CM");
                        editorHeight.apply();
                        currentHeight.setText(hei+" IN");

                        SharedPreferences sharedPreferencesWeight = getActivity().getSharedPreferences("WEIGHT", MODE_PRIVATE);
                        SharedPreferences.Editor editorWeight = sharedPreferencesWeight.edit();
                        editorWeight.putString("finishWEIGHT","NONE");
                        editorWeight.apply();
                        currentweight.setText(wei+" lbs");
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog1.dismiss();
            }
        });



        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (kgno==0||kgno%2==0){
                    kgno++;
                    no1=0;
                    kg.setBackgroundResource(R.drawable.but_wh);
                    kg.setTextColor(Color.BLACK);
                }
                if (kgno==1||kgno%2!=0){
                    no1=1;
                    no2=0;
                    kg.setBackgroundResource(R.drawable.but_bl);
                    kg.setTextColor(Color.WHITE);
                }
                lb.setTextColor(Color.BLACK);
                lb.setBackgroundResource(R.drawable.but_wh);
                Toast.makeText(getActivity(), "kgno = "+kgno+"lbno = "+lbno, Toast.LENGTH_SHORT).show();
            }
        });

        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lbno==0||lbno%2==0){
                    no2=1;
                    no1=0;
                    lb.setBackgroundResource(R.drawable.but_bl);
                    lb.setTextColor(Color.WHITE);
                }
                if (lbno==1||lbno%2!=0){
                    lbno++;
                    no2=0;
                    lb.setBackgroundResource(R.drawable.but_wh);
                    lb.setTextColor(Color.BLACK);
                }
                kg.setBackgroundResource(R.drawable.but_wh);
                kg.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), "lbno = "+lbno, Toast.LENGTH_SHORT).show();
            }
        });
        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cmno==0||cmno%2==0){
                    cmno++;
                    no3=0;
                    cm.setBackgroundResource(R.drawable.but_wh);
                    cm.setTextColor(Color.BLACK);
                }
                if (cmno==1||cmno%2!=0){
                    no3=1;
                    no4=0;
                    cm.setBackgroundResource(R.drawable.but_bl);
                    cm.setTextColor(Color.WHITE);
                }
                in.setBackgroundResource(R.drawable.but_wh);
                in.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), "cmno = "+cmno, Toast.LENGTH_SHORT).show();
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inno==0||inno%2==0){
                    no4=1;
                    no3=0;
                    in.setBackgroundResource(R.drawable.but_bl);
                    in.setTextColor(Color.WHITE);
                }
                if (inno==1||inno%2!=0){
                    inno++;
                    no4=0;
                    in.setBackgroundResource(R.drawable.but_wh);
                    in.setTextColor(Color.BLACK);
                }
                cm.setBackgroundResource(R.drawable.but_wh);
                cm.setTextColor(Color.BLACK);
                Toast.makeText(getActivity(), "inno = "+inno, Toast.LENGTH_SHORT).show();
            }
        });


    }
//    *********************Loaddata for popup height and weight over


}
