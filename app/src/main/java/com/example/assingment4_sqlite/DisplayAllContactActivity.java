package com.example.assingment4_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import static com.example.assingment4_sqlite.MainActivity.db;

public class DisplayAllContactActivity extends AppCompatActivity {

    List<Contact> contacts;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_contact);

        recyclerView = findViewById(R.id.my_recycler_view);

        contacts = db.getAllContacts();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter
        mAdapter = new MyAdapter(contacts);
        recyclerView.setAdapter(mAdapter);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private List<Contact> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        class MyViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            TextView name,ph_no;
            ImageView editContact;
            ImageView deleteContact;

            MyViewHolder(View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.contact_name);
                ph_no = itemView.findViewById(R.id.ph_no);
                editContact = itemView.findViewById(R.id.edit_contact);
                deleteContact = itemView.findViewById(R.id.delete_contact);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        MyAdapter(List<Contact> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view, parent, false);

            return new MyViewHolder(v);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            final Contact contact = mDataset.get(position);
            holder.name.setText(contact.getName());
            holder.ph_no.setText(contact.getPhoneNumber());
            holder.editContact.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent editIntent = new Intent(getApplicationContext(), AddContactActivity.class);
                    editIntent.putExtra("ContactInfo", contact);
                    startActivity(editIntent);
                }
            });
            holder.deleteContact.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    db.deleteContact(contact);
                    Intent deleteIntent = new Intent(getApplicationContext(), DisplayAllContactActivity.class);
                    startActivity(deleteIntent);
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }
    }

    public void buttonMain_OnClick(View v){
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
    }
}
