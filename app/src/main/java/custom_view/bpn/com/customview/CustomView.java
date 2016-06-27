package custom_view.bpn.com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dipesh on 6/27/16.
 */
public class CustomView extends View {

    private Paint paintColorStyle;
    private String circleText;
    private int circleColor , circleTextColor;
    private float circleTextSize;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintColorStyle = new Paint();
        TypedArray attributeValuesArray = context.getTheme().obtainStyledAttributes(attrs , R.styleable.CustomView , 0 , 0);

        try {
            circleText = attributeValuesArray.getString(R.styleable.CustomView_circleText);
            circleColor = attributeValuesArray.getInteger(R.styleable.CustomView_circleColor , 0);
            circleTextColor = attributeValuesArray.getInteger(R.styleable.CustomView_circleTextColor , 0);
            circleTextSize = attributeValuesArray.getFloat(R.styleable.CustomView_circle_textSize , 40);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            attributeValuesArray.recycle();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paintColorStyle.setStyle(Paint.Style.FILL);
        paintColorStyle.setAntiAlias(true);
        paintColorStyle.setColor(circleColor);

        int centerX = this.getMeasuredHeight()/2;
        int centerY = this.getMeasuredHeight()/2;
        int radius = 150;

        canvas.drawCircle(centerX , centerY , radius , paintColorStyle);

        paintColorStyle.setColor(circleTextColor);
        paintColorStyle.setTextAlign(Paint.Align.CENTER);

        canvas.drawText(circleText , centerX , centerY , paintColorStyle);

    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        invalidate();
        requestLayout();
    }

    public void setCircleTextColor(int circleTextColor) {
        this.circleTextColor = circleTextColor;
        invalidate();
        requestLayout();
    }

    public void setCircleTextSize(float circleTextSize) {
        this.circleTextSize = circleTextSize;
        invalidate();
        requestLayout();
    }

}
