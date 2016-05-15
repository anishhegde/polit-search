package download.anishhegde.com.downloaddata.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import download.anishhegde.com.downloaddata.Controllers.DownloadEventListener;
import download.anishhegde.com.downloaddata.Controllers.DownloadManager;
import download.anishhegde.com.downloaddata.Models.PoliticianModel;
import download.anishhegde.com.downloaddata.Adapters.PoliticianListAdapter;
import download.anishhegde.com.downloaddata.R;
import download.anishhegde.com.downloaddata.Utils.Utils;

public class ListingActivity extends AppCompatActivity {

    PoliticianModel mPoliticianModel;
    protected ListView mPolList;
    protected PoliticianListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        setUpViews();
        loadData();
    }

    private void setUpViews(){
        mPoliticianModel = new PoliticianModel();
        mPolList = (ListView)findViewById(R.id.list_politician);
        mAdapter = new PoliticianListAdapter(this,R.layout.item_politicians,mPoliticianModel.getmModel());
        mPolList.setAdapter(mAdapter);
    }

    private void loadData(){
        DownloadManager.Instance().downloadData(Utils.url,mPoliticianModel,new DownloadEventListener(){

            @Override
            public void dataDidDownload() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
