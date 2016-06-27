package custom_view.bpn.com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dipesh on 6/27/16.
 */
public class CustomView extends LinearLayout {

    private String leftLabel = "";
    private String rightLabel = "";
    private TextView leftTextView;
    private TextView rightTextView;
    private int leftStyle ;
    private int rightStyle;

    public CustomView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.key_value_layout, this);

    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context, attrs);
    }

    private void initViews(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomView, 0, 0);

        try {
            // get the text and colors specified using the names in attrs.xml
            leftLabel = a.getString(R.styleable.CustomView_leftLabel);
            rightLabel = a.getString(R.styleable.CustomView_rightLabel);
            leftStyle = a.getResourceId(R.styleable.CustomView_leftLabelStyle, android.R.style.TextAppearance_DeviceDefault);
            rightStyle = a.getResourceId(R.styleable.CustomView_rightLabelStyle, android.R.style.TextAppearance_DeviceDefault);

        } finally {
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.key_value_layout, this);

        //left text view
        leftTextView = (TextView) this.findViewById(R.id.textView1);
        leftTextView.setText(leftLabel);
        leftTextView.setTextAppearance(context, leftStyle);

        //right text view
        rightTextView = (TextView) this.findViewById(R.id.textView2);
        rightTextView.setText(rightLabel);
        rightTextView.setTextAppearance(context, rightStyle);
    }


    public void setLeftLabel(String leftLabel) {
        this.leftLabel = leftLabel;
        if(leftTextView!=null){
            leftTextView.setText(leftLabel);
        }
    }


    public void setRightLabel(String rightLabel) {
        this.rightLabel = rightLabel;
        if(rightTextView!=null){
            rightTextView.setText(rightLabel);
        }
    }

}
