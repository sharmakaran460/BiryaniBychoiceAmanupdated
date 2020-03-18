package com.example.test.ViewHolder;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.ItemDetails.ItemDetails;
import com.example.test.Model.CartModal;
import com.example.test.Model.FoodModel;
import com.example.test.OrderCart.Cart;
import com.example.test.R;
import com.example.test.Sqldirectory.DatabaseHelper;
import com.example.test.Sqldirectory.MyDatabse;

import java.util.ArrayList;
import java.util.HashMap;

public class Adapter_for_product_gride extends RecyclerView.Adapter<Adapter_for_product_gride.ViewHolder> {
    View view;
    ArrayList<FoodModel> food_list;
    DatabaseHelper data_base;
    MyDatabse myDatabse;
    Context context;
    TextView cart_amout,items_total ,firstprice,secondprice,thirdprice, add_new_serv_name,add_new_serving_size, bottom_sheet_view_cart_btn;
    LinearLayout bottom_sheet_layout;
    Toolbar toolbar;
    Button biryaniquantitybtn;
    Dialog dialog;
    RadioButton btn1,btn2,btn3;
    RelativeLayout add_new_serv_layout;
    Button add_new_serv_btn,repeat_last_serv_btn,close_new_serv_layout_btn;
    RecyclerView recyclerView;
    ArrayList<CartModal> cartModalArrayList=new ArrayList<>();


    ArrayList<HashMap<String,String>> cat_list_product_details;

    public Adapter_for_product_gride(Context context, ArrayList<HashMap<String,String>> cat_list_product_details)
    {
        this.context = context;
         myDatabse=new MyDatabse(context);
        data_base = new DatabaseHelper(context);
        this.cat_list_product_details = cat_list_product_details;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        view=inflater.inflate(R.layout.new_food_card,parent,false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position)
    {
        String id = cat_list_product_details.get(position).get("id");
        String type = cat_list_product_details.get(position).get("type");
        final String name = cat_list_product_details.get(position).get("name");
        String slug = cat_list_product_details.get(position).get("slug");
        String sku = cat_list_product_details.get(position).get("sku");
        final String description = cat_list_product_details.get(position).get("description");
        String statuss = cat_list_product_details.get(position).get("statuss");
        String in_stock = cat_list_product_details.get(position).get("in_stock");
        final String price = cat_list_product_details.get(position).get("price");

        holder.food_desc.setText(description);
        holder.food_name.setText(name);
        holder.food_price.setText(price);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ItemDetails.class);
                i.putExtra("name",name);
                i.putExtra("desc",description);
                i.putExtra("price",price);
                context.startActivity(i);
            }
        });

        if(type.equalsIgnoreCase("BASIC"))
        {
            holder.cat_icon_image.setImageResource(R.drawable.veg);
        }
        else {
            holder.cat_icon_image.setImageResource(R.drawable.nonveg);
        }

    }

    @Override
    public int getItemCount()
    {
        return cat_list_product_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, cat_icon_image;
        TextView food_name, food_price, food_desc, counter_text;
        Button add_btn;
        ImageButton  add_counter, min_counter;
        LinearLayout linearLayout, linearLayout_btn;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            cat_icon_image=itemView.findViewById(R.id.new_c_cat_icon);
            food_desc=itemView.findViewById(R.id.new_c_desc);
            imageView=itemView.findViewById(R.id.new_c_image);
            food_name=itemView.findViewById(R.id.new_c_f_name);
            food_price=itemView.findViewById(R.id.new_c_price);
            add_btn=itemView.findViewById(R.id.new_c_add_btn);
            linearLayout=itemView.findViewById(R.id.new_c_counter_layout);
            add_counter=itemView.findViewById(R.id.new_c_count_plus);
            min_counter=itemView.findViewById(R.id.new_c_count_min);
            counter_text=itemView.findViewById(R.id.new_c_count_num);
            linearLayout_btn= itemView.findViewById(R.id.linear_layout_button);

        }
    }
}
