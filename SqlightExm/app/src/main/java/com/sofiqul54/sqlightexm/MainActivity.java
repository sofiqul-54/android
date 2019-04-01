package com.sofiqul54.sqlightexm;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText id, name, qty;
MyDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.productID);
        name = (EditText) findViewById(R.id.productName);
        qty = (EditText) findViewById(R.id.productQuantity);
        helper= new MyDbAdapter(this);
    }

    public void saveProduct(View view){
        Product product = new Product(name.getText().toString(), Integer.parseInt(qty.getText().toString()));
        long i = helper.insertData(product);
        if (i < 0){
            Message.message(this, "Unsuccessful");
        }else {
            Message.message(this, "Successful");
        }
    }

    public  void getProductByProductId(View view){
        int pid = Integer.parseInt(id.getText().toString().trim());
        Product p = helper.findProductById(pid);
        if (p != null){
            name.setText(p.getProductName());
            qty.setText(String.valueOf(p.getQuantity()));
        }else {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteProductByProductId(View view){
        int pid = Integer.parseInt(id.getText().toString().trim());
        helper.deleteProduct(pid);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
    public void getProductlist(){
        List<Product> p = helper.getlist();
        system.out.println(p.size());
    }
}
