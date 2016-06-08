package download.anishhegde.com.downloaddata.Receiver;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by anishhegde on 08/06/16.
 */
@SuppressLint("ParcelCreator")
public class FeedReceiver extends ResultReceiver{
    private Receiver mReceiver;
    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public FeedReceiver(Handler handler) {
        super(handler);
    }

    public interface Receiver{
        public void onResultReceived(int resultCode,Bundle resultData);
    }

    public void setReceiver(Receiver receiver){
        mReceiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if(mReceiver != null){
            mReceiver.onResultReceived(resultCode,resultData);
        }
    }
}
