//package sheridan.wrimicha.assignment3.binding
//
//import android.widget.ImageView
//import androidx.databinding.BindingAdapter
//
//@BindingAdapter("int")
//fun bindImage(imgView: ImageView, imgUrl: String?) {
//    if(imgUrl is String){
//        Glide.with(imgView.context)
//            .load(imgUrl)
//            .apply(RequestOptions()
//                .placeholder(R.drawable.loading_animation)
//                .error(R.drawable.ic_broken_image))
//            .into(imgView)
//    }
//}