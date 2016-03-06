package wenqianguo.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wguo on 3/5/2016.
 */
public class InstagramPhotosAdaptor extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotosAdaptor(Context context, List<InstagramPhoto> objects) {
        super(context,android.R.layout.simple_list_item_1, objects);
    }
    //use the template to display the photos
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get the data item for this postion
        //check if we are using a recycled view, if not we need to inflate
        //lookup the iews for populating the data into each of the view items
        //Return the created item as a view
        InstagramPhoto photo = getItem(position);
        if(convertView == null){
            //create a new view from template
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo,parent,false);
        }
        TextView tvCaption = (TextView)convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        //insert the model data into the view
        tvCaption.setText(photo.caption);
        //clear out the imageview because we might be using a recycled view
        ivPhoto.setImageResource(0);
        //insert the imageview using picassio
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);
        return convertView;

    }
}
