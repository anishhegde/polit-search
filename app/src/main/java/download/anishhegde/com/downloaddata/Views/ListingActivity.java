package download.anishhegde.com.downloaddata.Views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import download.anishhegde.com.downloaddata.Controllers.DownloadEventListener;
import download.anishhegde.com.downloaddata.Controllers.DownloadManager;
import download.anishhegde.com.downloaddata.Models.PoliticianModel;
import download.anishhegde.com.downloaddata.Adapters.PoliticianListAdapter;
import download.anishhegde.com.downloaddata.R;
import download.anishhegde.com.downloaddata.Receiver.FeedReceiver;
import download.anishhegde.com.downloaddata.Services.DownloadService;
import download.anishhegde.com.downloaddata.Utils.Constants;
import download.anishhegde.com.downloaddata.Utils.Utils;

public class ListingActivity extends AppCompatActivity implements FeedReceiver.Receiver{

    PoliticianModel mPoliticianModel;
    protected ListView mPolList;
    protected PoliticianListAdapter mAdapter;
    protected ProgressDialog mProgressDialog;
    public FeedReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        mReceiver = new FeedReceiver(new Handler());
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
        mProgressDialog = new ProgressDialog(ListingActivity.this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Loading..");
        mProgressDialog.show();
//        DownloadManager.Instance().downloadData(Utils.url,mPoliticianModel,new DownloadEventListener(){
//
//            @Override
//            public void dataDidDownload() {
//                mAdapter.notifyDataSetChanged();
//                if(mProgressDialog.isShowing())
//                    mProgressDialog.dismiss();
//            }
//        });

        Intent intent = new Intent(this, DownloadService.class);
        intent.putExtra(Constants.TAG_URL,Utils.url);
        intent.putExtra(Constants.TAG_RECEIVER,mReceiver);
        startService(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mReceiver.setReceiver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mReceiver.setReceiver(null);
    }

    @Override
    public void onResultReceived(int resultCode, Bundle resultData) {
        if(mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        String data = resultData.getString(Constants.TAG_JSON_DATA);
        mPoliticianModel.parse(data);
        mAdapter.notifyDataSetChanged();
    }
}
