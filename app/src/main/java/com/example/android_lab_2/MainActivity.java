package com.example.android_lab_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> shoppingList;
    private ShoppingListAdapter adapter;

    private EditText newItemEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoppingList = new ArrayList<>();
        adapter = new ShoppingListAdapter(shoppingList, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newItemEditText = findViewById(R.id.new_item_edit_text);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = newItemEditText.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    adapter.addItem(newItem);
                    newItemEditText.setText("");
                }
            }
        });
    }
}

