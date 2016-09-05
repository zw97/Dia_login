package com.example.w.dia_login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.w.dia_login.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) this.findViewById(R.id.buttonTest);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("你好 提示对话框")//显示的消息内容
                        .setTitle("对话框");//对话框标题

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();

                    }

                });
                builder.show();
            }
        });


        //登陆对话框


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button = (Button) findViewById(R.id.buttonLoad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater inflater = getLayoutInflater();
                final View dia=inflater.inflate(R.layout.dialog_login,null);
                builder.setView(dia)
                        .setTitle("Login")
                        // Add action buttons
                        .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int id) {


                                EditText inputText=(EditText)dia.findViewById(R.id.editTextUserId);
                                EditText inputTxt=(EditText)dia.findViewById(R.id.editTextPwd);
                                String account=inputText.getText().toString();
                                String passord=inputTxt.getText().toString();


                                if(account.equals("abc")&&passord.equals("123")){

                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();

                                }else{

                                    Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();

                                }// login
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();//cancel
                            }
                        });
                builder.show();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
