package download.anishhegde.com.downloaddata.Services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import download.anishhegde.com.downloaddata.Controllers.DataDownloader;
import download.anishhegde.com.downloaddata.Utils.Constants;

/**
 * Created by anishhegde on 08/06/16.
 */
public class DownloadService extends IntentService
{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ResultReceiver rec =  intent.getParcelableExtra(Constants.TAG_RECEIVER);
        String url = intent.getStringExtra(Constants.TAG_URL);
        DataDownloader downloader = new DataDownloader();
        String jsonString = downloader.downloadData(url);

        Bundle bundle = new Bundle();
        bundle.putString(Constants.TAG_JSON_DATA,jsonString);
        rec.send(0,bundle);

    }
}
