package download.anishhegde.com.downloaddata.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import download.anishhegde.com.downloaddata.Models.PoliticianModelItem;
import download.anishhegde.com.downloaddata.R;

/**
 * Created by anishhegde on 09/05/16.
 */
public class PoliticianListAdapter extends ArrayAdapter{
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<PoliticianModelItem> mData;
    public PoliticianListAdapter(Context context, int resource, ArrayList<PoliticianModelItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mData = objects;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder {
        public TextView politicianName;
        public TextView party;
        public TextView state;
        public TextView district;
        public TextView phone;
        public TextView office;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View  v = convertView;
        ViewHolder viewHolder;

        if(v == null){
            v = mInflater.inflate(R.layout.item_politicians,null);
            viewHolder = new ViewHolder();
            viewHolder.politicianName = (TextView) v.findViewById(R.id.text_name);
            viewHolder.party = (TextView) v.findViewById(R.id.text_party_value);
            viewHolder.state = (TextView) v.findViewById(R.id.text_state_value);
            viewHolder.district = (TextView) v.findViewById(R.id.text_disctrict_value);
            viewHolder.phone = (TextView) v.findViewById(R.id.text_phone_value);
            viewHolder.office = (TextView) v.findViewById(R.id.text_office_value);
            v.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) v.getTag();
        }
        if(mData.size() <= 0) {
            viewHolder.politicianName.setText("No Data");
        } else {
            viewHolder.politicianName.setText(mData.get(position).getName());
            viewHolder.party.setText(mData.get(position).getParty());
            viewHolder.state.setText(mData.get(position).getState());
            viewHolder.district.setText(mData.get(position).getDistrict());
            viewHolder.phone.setText(mData.get(position).getPhone());
            viewHolder.office.setText(mData.get(position).getOffice());
        }
        return v;
    }
}
