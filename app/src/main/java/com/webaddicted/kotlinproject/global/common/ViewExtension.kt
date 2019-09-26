package com.android.boxlty.global.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.DrawableTypeRequest
import com.bumptech.glide.Glide
import com.webaddicted.kotlinproject.R
import java.io.File

/**
 * visible view
 */
fun View.visible() {
    visibility = View.VISIBLE
}

/**
 * invisible view
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * gone view
 */
fun View.gone() {
    visibility = View.GONE
}
//    {START SHOW IMAGE USING GLIDE}
/**
 * show remote image using glide
 *
 * @param imgUrl       remote image url
 * @param imageLoaderType type of place holder show which is define in string
 */
fun ImageView.showImage(imgUrl: String, imageLoaderType: String) {
    val drawableTypeRequest = Glide.with(context)
        .load(imgUrl)
    getPlaceHolder(context, drawableTypeRequest, imageLoaderType).into(this)
}

/**
 * show local image using glide
 *
 * @param filePath          local image file path
 * @param imageLoaderType type of place holder show which is define in string
 */
fun ImageView.showImage(filePath: File, imageLoaderType: String) {
    val drawableTypeRequest = Glide.with(context)
        .load(Uri.fromFile(filePath))
    getPlaceHolder(context, drawableTypeRequest, imageLoaderType).into(this)
}


/**
 * apply different type of place holder
 *
 * @param drawableTypeRequest
 * @param imageLoaderType     type of place holder show
 * @param <T>
 * @return
</T> */
fun <T> getPlaceHolder(
    context: Context,
    drawableTypeRequest: DrawableTypeRequest<T>,
    imageLoaderType: String
): DrawableTypeRequest<T> {
    val imageLoadersArray = context.getResources().getStringArray(R.array.image_loader)
    if (imageLoadersArray[0] == imageLoaderType) {
        drawableTypeRequest.error(R.drawable.logo)
        drawableTypeRequest.placeholder(R.drawable.logo)
    } else if (imageLoadersArray[1] == imageLoaderType) {
        drawableTypeRequest.error(R.drawable.logo)
        drawableTypeRequest.placeholder(R.drawable.logo)
    } else {
        drawableTypeRequest.error(R.color.app_color)
        drawableTypeRequest.placeholder(R.color.app_color)
    }
    return drawableTypeRequest
}
//    {END SHOW IMAGE USING GLIDE}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * Gets network state.
 *
 * @return the network state
 */
fun Context.isNetworkAvailable(): Boolean {
    val connMgr =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connMgr?.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isAvailable && activeNetwork.isConnected
}

/**
 * show internet connection toast
 */
fun Context.showNoNetworkToast() {
    val msg = getResources().getString(R.string.no_network_msg)
    showToast(msg)
}
/**
 * show internet connection toast
 */
fun Context.getResString() {
    val msg = getResources().getString(R.string.no_network_msg)
    showToast(msg)
}
