package com.coderbd.sqlietdbex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText id, name, qty;
    MyDbAdapter helper;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.productID);
        name = (EditText) findViewById(R.id.productName);
        qty = (EditText) findViewById(R.id.productQuantity);
        helper = new MyDbAdapter(this);
        getProductlist();

    }

    public void saveProduct(View view) {
        Product product = new Product(name.getText().toString(), Integer.parseInt(qty.getText().toString()));
        long i = helper.insertData(product);
        if (i < 0) {
            Message.message(this, "Unsuccessful");
        } else {
            getProductlist();
            Message.message(this, "Successful");
        }
    }

    public void getProductByProductId(View view) {
        int pid = Integer.parseInt(id.getText().toString().trim());
        Product p = helper.findProductById(pid);
        if (p != null) {
            name.setText(p.getProductname());
            qty.setText(String.valueOf(p.getQuantity()));
        } else {
            Toast.makeText(this, "No Data Exists", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteProductByProductId(View view) {
        int pid = Integer.parseInt(id.getText().toString().trim());
        helper.deleteProduct(pid);
        getProductlist();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    public void getProductlist() {
        ///////////////Display List
        listView = (ListView) findViewById(R.id.listviews);
        List<Product> list = helper.getList();
        ProductAdapter adapter = new ProductAdapter(this, list);
        listView.setAdapter(adapter);
    }
}
