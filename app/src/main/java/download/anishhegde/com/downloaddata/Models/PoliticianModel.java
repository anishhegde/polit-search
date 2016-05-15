package download.anishhegde.com.downloaddata.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by anishhegde on 08/05/16.
 */
public class PoliticianModel extends BaseModel{

    private final String TAG_RESULT = "results";
    private final String TAG_NAME = "name";
    private final String TAG_PARTY = "party";
    private final String TAG_STATE = "state";
    private final String TAG_DISTRICT = "district";
    private final String TAG_PHONE = "phone";
    private final String TAG_OFFICE = "office";
    private final String TAG_LINK = "link";

    private ArrayList<PoliticianModelItem> mModel;

    public PoliticianModel(){
        mModel = new ArrayList<PoliticianModelItem>();
    }

    public ArrayList<PoliticianModelItem> getmModel() {
        return mModel;
    }

    /**
     * Parses data from the input string and populates the models
     * @param inData String data
     */
    @Override
    public void parse(String inData){

        try {
            JSONObject rootObject = new JSONObject(inData);
            JSONArray rootArray = rootObject.getJSONArray(TAG_RESULT);

            for(int i = 0; i < rootArray.length(); i++) {
                JSONObject innerObject = rootArray.getJSONObject(i);
                PoliticianModelItem innerModel = new PoliticianModelItem();

                if(innerObject.has(TAG_NAME))innerModel.setName(innerObject.getString(TAG_NAME));
                if(innerObject.has(TAG_PARTY))innerModel.setParty(innerObject.getString(TAG_PARTY));
                if(innerObject.has(TAG_STATE))innerModel.setState(innerObject.getString(TAG_STATE));
                if(innerObject.has(TAG_DISTRICT))innerModel.setDistrict(innerObject.getString(TAG_DISTRICT));
                if(innerObject.has(TAG_PHONE))innerModel.setPhone(innerObject.getString(TAG_PHONE));
                if(innerObject.has(TAG_OFFICE))innerModel.setOffice(innerObject.getString(TAG_OFFICE));
                if(innerObject.has(TAG_LINK))innerModel.setLink(innerObject.getString(TAG_LINK));

                mModel.add(innerModel);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
