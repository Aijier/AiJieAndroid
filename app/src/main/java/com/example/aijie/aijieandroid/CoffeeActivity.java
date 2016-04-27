package com.example.aijie.aijieandroid;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CoffeeActivity extends Activity {
    int quantity = 1;
    int priceOfCoffees = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffee);
    }

    public void submitOrder(View view) {

        EditText nameFiled = (EditText) findViewById(R.id.name_filed);
        String name = nameFiled.getText().toString();
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name,price, hasWhippedCream, hasChocolate);
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT,"Just java order for"+name);
        intent.putExtra(intent.EXTRA_TEXT,priceMessage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void increment(View view) {
        if(quantity==100){
            Toast.makeText(CoffeeActivity.this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity==1){

            Toast.makeText(CoffeeActivity.this, "You cannot have less than 1 coffees", Toast.LENGTH_SHORT).show();
            return;

        }
        quantity = quantity - 1;
        display(quantity);
    }

    private int calculatePrice(boolean addWhippedCream,boolean addChocolate) {
        int basePrice=5;
        if(addWhippedCream){
            basePrice=basePrice+1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        return quantity*basePrice;
    }

    private String createOrderSummary(String name,int price, boolean addWhippedCream, boolean hasChocolate) {

        String priceMessage = "Name: "+name;
        priceMessage = priceMessage + "\nAdd whipped cream ? " + addWhippedCream;
        priceMessage = priceMessage + "\nAdd chocolate ? " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTatol: $" + price;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}
