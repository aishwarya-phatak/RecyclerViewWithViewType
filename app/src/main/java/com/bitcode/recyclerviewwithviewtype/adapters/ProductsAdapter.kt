package com.bitcode.recyclerviewwithviewtype.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.recyclerviewwithviewtype.R
import com.bitcode.recyclerviewwithviewtype.models.Advertisement
import com.bitcode.recyclerviewwithviewtype.models.Product

class ProductsAdapter(
    private var products : ArrayList<Product>,
    private var advertisements : ArrayList<Advertisement>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val VIEW_TYPE_PRODUCT = 1
    val VIEW_TYPE_ADVERTISEMENT = 2

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imgProduct: ImageView
        var txtProductTitle: TextView
        var txtProductPrice: TextView

        init {
            imgProduct = view.findViewById(R.id.imgProduct)
            txtProductTitle = view.findViewById(R.id.txtProductTitle)
            txtProductPrice = view.findViewById(R.id.txtProductPrice)
        }
    }

    class AdvertisementViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imgAdvertisement: ImageView
        var txtAdvertisementTitle: TextView

        init {
            imgAdvertisement = view.findViewById(R.id.imgAdvertisement)
            txtAdvertisementTitle = view.findViewById(R.id.txtAdvertisementTitle)
        }
    }


    override fun getItemCount(): Int {
        return products.size + advertisements.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var layoutInflater = LayoutInflater.from(parent.context)

        if(viewType == VIEW_TYPE_PRODUCT) {
            var productView = layoutInflater.inflate(R.layout.product_view, null)
            return ProductViewHolder(productView)
        }

        var advertisementView = layoutInflater.inflate(R.layout.advertisement_view, null)
        return AdvertisementViewHolder(advertisementView)

    }

    override fun getItemViewType(position: Int): Int {
        if((position + 1) % 3 == 0){
            return VIEW_TYPE_ADVERTISEMENT
        }
        return VIEW_TYPE_PRODUCT
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ProductViewHolder){
            var product = products[position - position/3]

            holder.txtProductTitle.text = product.title
            holder.txtProductPrice.text = "Rs. ${product.price}"
            holder.imgProduct.setImageResource(product.imageId)
        }

        if(holder is AdvertisementViewHolder){
            var advertisementPosition = (position+1)/3 - 1
            if(advertisementPosition >= advertisements.size){
                advertisementPosition = advertisementPosition % 5
            }

            var advertisement = advertisements[advertisementPosition]

            holder.txtAdvertisementTitle.text = advertisement.title
            holder.imgAdvertisement.setImageResource(advertisement.imageId)
        }
    }

}
