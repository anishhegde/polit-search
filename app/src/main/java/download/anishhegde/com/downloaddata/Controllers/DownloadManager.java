package download.anishhegde.com.downloaddata.Controllers;

import android.os.AsyncTask;

import download.anishhegde.com.downloaddata.Models.BaseModel;

/**
 * Created by anishhegde on 03/05/16.
 */
public class DownloadManager {

    static DownloadManager mDownloadManager = null;
    DownloadEventListener mListener;

    public DownloadManager(){
    }

    public static DownloadManager Instance(){
        if(mDownloadManager == null){
            mDownloadManager = new DownloadManager();
        }
        return mDownloadManager;
    }

    public void downloadData(String inUrl, BaseModel inModel, DownloadEventListener listener){
        new DownloadDataTask().execute(inUrl,inModel);
        mListener = listener;
    }

    private class DownloadDataTask extends AsyncTask<Object,Void,Void> {

        @Override
        protected Void doInBackground(Object... params) {
            DataDownloader downloader = new DataDownloader();
            if(params[0] != null && params[1] != null && params[0] instanceof String) {
                String url = (String) params[0];
                String jsonString = downloader.downloadData(url);
                if(params[1] instanceof BaseModel){
                    BaseModel model = (BaseModel) params[1];
                    model.parse(jsonString);
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mListener.dataDidDownload();
        }
    }
}
