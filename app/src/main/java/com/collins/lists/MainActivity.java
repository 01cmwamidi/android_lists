package com.collins.lists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView mylist;
    BaseAdapter adapter;
    ArrayList<Account> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = findViewById(R.id.myList);


        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = getLayoutInflater().inflate(R.layout.list_item,null,true);
                TextView txtNames = v.findViewById(R.id.textViewName);
                TextView txtAccNumber = v.findViewById(R.id.textViewAccNumber);
                TextView txtBalance = v.findViewById(R.id.textViewAccBalance);

                Account x = arrayList.get(position);
                txtNames.setText(x.getName());
                txtAccNumber.setText(x.getAccNumber());

                Locale locale = new Locale("en", "KE");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                String balance=currencyFormatter.format(x.getBalance());

                txtBalance.setText(balance);
                return v;

            }
        };
        mylist.setAdapter(adapter);

        Account ac1 = new Account("Jim","ACOO1",120000);
        Account ac2 = new Account("Mary","ACOO2",564534);
        Account ac3 = new Account("John","ACOO3",56757);
        Account ac4 = new Account("James","ACOO4",45000);
        Account ac5 = new Account("John","ACOO5",654747);
        Account ac6 = new Account("Peter","ACOO6",4564554);

        arrayList.add(ac1);
        arrayList.add(ac2);
        arrayList.add(ac3);
        arrayList.add(ac4);
        arrayList.add(ac5);
        arrayList.add(ac6);

        //refresh
        adapter.notifyDataSetChanged();

        //format
    }
}
