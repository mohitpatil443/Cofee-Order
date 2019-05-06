package com.example.mohit.cofeeapp


import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.order_activity.*


class Order : AppCompatActivity() {



    var quantity = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_activity)


        decrement.setOnClickListener(View.OnClickListener

        {
            if (quantity > 0) {
                quantity--
                quantitytv.setText("" + quantity)
            }
        })

        increment.setOnClickListener(View.OnClickListener {

            quantity++
            quantitytv.setText("" + quantity)

        })

        order.setOnClickListener(View.OnClickListener {

            val price = calculatePrice()
            val message = displayMessage(price)
            val gmail = Intent(Intent.ACTION_SENDTO)
            gmail.setData(Uri.parse("mailto:coffeecafe@gmail.com"))
            gmail.putExtra(Intent.EXTRA_SUBJECT, "Order for " + name.text.toString())
            gmail.putExtra(Intent.EXTRA_TEXT, message+"\n")
            startActivity(gmail)


        })
    }

    private fun calculatePrice(): Int {
        var price = quantity * 5
        if (cream.isChecked) {
            price = price + 3 * quantity

        }
        if (chocolate.isChecked) {
            price = price + 2 * quantity

        }
        return price
    }

    private fun displayMessage(price: Int): String {
        var message: String
        message = "Order for " + name.text.toString() + "\n"
        message = message + quantity + " cups of Coffee" + "\n"
        if (cream.isChecked) {
            message = message + "With Whipped Cream topping" + "\n"
        }
        if (chocolate.isChecked) {
            message = message + "With Chocolate topping" + "\n"
        }

        message = message + "Total Price : " + price + "$"

        pricetv.setText("" + message)
        return message


    }






}










