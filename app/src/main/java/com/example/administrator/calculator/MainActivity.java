package com.example.administrator.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button number_clean,number_delete,number_plus,number_one,number_two,number_three,number_subtract;
    Button number_four,number_five,number_six,number_multiply,number_seven,number_eight,number_nine;
    Button number_divid,number_zero,number_dot,number_equal;
    EditText number_preview,number_previewL1,number_previewL2;
    boolean clr_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //number_preview.setKeyListener(null);
       // number_previewL1.setKeyListener(null);
        //number_previewL2.setKeyListener(null);

        number_clean = (Button) findViewById(R.id.clean);
        number_delete = (Button) findViewById(R.id.delete);
        number_plus = (Button) findViewById(R.id.Plus);
        number_divid = (Button) findViewById(R.id.Divid);
        number_subtract = (Button) findViewById(R.id.Subtract);
        number_multiply = (Button) findViewById(R.id.Multiply);
        number_dot = (Button) findViewById(R.id.Dot);
        number_equal = (Button) findViewById(R.id.Equal);
        number_one = (Button) findViewById(R.id.numberOne);
        number_two = (Button) findViewById(R.id.numberTwo);
        number_three = (Button) findViewById(R.id.numberThree);
        number_four = (Button) findViewById(R.id.numberFour);
        number_five = (Button) findViewById(R.id.numberFive);
        number_six = (Button) findViewById(R.id.numberSix);
        number_seven = (Button) findViewById(R.id.numberSeven);
        number_eight = (Button) findViewById(R.id.numberEight);
        number_nine = (Button) findViewById(R.id.numberNine);
        number_zero = (Button) findViewById(R.id.numberZero);
        number_preview = (EditText) findViewById(R.id.numberPreview);//主显示
        number_previewL1=(EditText)findViewById(R.id.numberPreviewL1);//副显示1
        number_previewL2=(EditText)findViewById(R.id.numberPreviewL2); //副显示2

        number_clean.setOnClickListener(this);
        number_delete.setOnClickListener(this);
        number_plus.setOnClickListener(this);
        number_subtract.setOnClickListener(this);
        number_divid.setOnClickListener(this);
        number_multiply.setOnClickListener(this);
        number_dot.setOnClickListener(this);
        number_equal.setOnClickListener(this);
        number_one.setOnClickListener(this);
        number_two.setOnClickListener(this);
        number_three.setOnClickListener(this);
        number_four.setOnClickListener(this);
        number_five.setOnClickListener(this);
        number_six.setOnClickListener(this);
        number_seven.setOnClickListener(this);
        number_eight.setOnClickListener(this);
        number_nine.setOnClickListener(this);
        number_zero.setOnClickListener(this);
    }

    //setContentView(R.layout.activity_main);
    //得到按钮实例
    //Button hellobtn = (Button)findViewById(R.id.hellobutton);
    //设置监听按钮点击事件
    //hellobtn.setOnClickListener(new View.OnClickListener() {

    @Override

    public void onClick(View v) {

        String str=number_preview.getText().toString();
        switch (v.getId()){
            case R.id.numberOne:
            case R.id.numberTwo:
            case R.id.numberThree:
            case R.id.numberFour:
            case R.id.numberFive:
            case R.id.numberSix:
            case R.id.numberSeven:
            case R.id.numberEight:
            case R.id.numberNine:
            case R.id.numberZero:
            case R.id.Dot:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    number_preview.setText("");
                }
                number_preview.setText(str+((Button)v).getText());
                break;
            case R.id.Plus:
            case R.id.Multiply:
            case R.id.Subtract:
            case R.id.Divid:
                //if(clr_flag){
                //    clr_flag=false;
                 //   str="";
                  //  number_preview.setText("");
              //  }
                if(str.contains("+")||str.contains("-")||str.contains("*")||str.contains("/")){
                    str=str.substring(0,str.indexOf(" "));
                }
                number_preview.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.clean://清零
                //if(clr_flag){
                 //   clr_flag=false;
                 //   str="";
                    number_preview.setText("");
                    number_previewL2.setText("");
                //}
                break;
            case R.id.delete://删除
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    number_preview.setText("");
                }
                if (str.equals(null) || str.equals("")) {
                number_preview.setText("");
                } else {
                    number_preview.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.Equal:
               getResult();
                break;
        }
        //if(str.length()>8){
        //    str=str.substring(0,7);
       // }
        //得到textview实例
        //TextView hellotv = (TextView)findViewById(R.id.hellotextView);
        //弹出Toast提示按钮被点击了
        //Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_SHORT).show();
        //读取strings.xml定义的interact_message信息并写到textview上
        //hellotv.setText(R.string.interact_message);
    }
    private void getResult(){
        String exp=number_preview.getText().toString();
        if(exp==null||exp.equals(""))return;
        if(!exp.contains(" ")){
            return;
        }
        if(clr_flag){
            clr_flag=false;
            return;
        }
        clr_flag=true;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        double cnt=0;
        //if(!op.equals("")&&!(!s1.equals("")&&!s2.equals(""))){
        //    number_preview.setText("Error!!");
       // }
        //else
            if(!op.equals("")&&(s1.equals(".")||s2.equals("."))){
            number_preview.setText("Error!!");
        }
         else if(!s1.equals("")&&!s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                cnt = d1 + d2;
            }
            if (op.equals("-")) {
                cnt = d1 - d2;
            }
            if (op.equals("*")) {
                cnt = d1 * d2;
            }
            if (op.equals("/")) {
                if(d2==0) cnt=0;
                else cnt = d1 / d2;
            }
            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {
                int res = (int) cnt;
                number_preview.setText(res + "");
            } else {
                number_preview.setText(cnt + "");
            }
        }
        else if(!s1.equals("")&&s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            if (op.equals("+")) {
                cnt = d1;
            }
            if (op.equals("-")) {
                cnt = d1;
            }
            if (op.equals("*")) {
                cnt = 0;
            }
            if (op.equals("/")) {
                cnt = 0;
            }
            if (!s1.contains(".")) {
                int res = (int) cnt;
                number_preview.setText(res + "");
            } else {
                number_preview.setText(cnt + "");
            }
        }
        else if(s1.equals("")&&!s2.equals("")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                cnt = d2;
            }
            if (op.equals("-")) {
                cnt = 0 - d2;
            }
            if (op.equals("*")) {
                cnt = 0;
            }
            if (op.equals("/")) {
                cnt = 0;
            }
            if (!s2.contains(".")) {
                int res = (int) cnt;
                number_preview.setText(res + "");
            } else {
                number_preview.setText(cnt + "");
            }
        }

        else{
            number_preview.setText("");
        }
        number_previewL2.setText(exp);

    }
}
// });
