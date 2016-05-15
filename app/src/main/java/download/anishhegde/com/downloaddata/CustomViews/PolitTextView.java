package download.anishhegde.com.downloaddata.CustomViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by anishhegde on 15/05/16.
 */
public class PolitTextView extends TextView {

    private static Typeface mTypeFace;

    public PolitTextView(Context context) {
        super(context);
        applyTypeFace(context);

    }

    public PolitTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyTypeFace(context);
    }

    public PolitTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyTypeFace(context);
    }

    private void applyTypeFace(Context context){
        if(mTypeFace == null){
            mTypeFace = Typeface.createFromAsset(context.getAssets(),"Montserrat-Regular.ttf");
        }
        setTypeface(mTypeFace);
    }
}
