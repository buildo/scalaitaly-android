package io.buildo.scalaitaly.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by andreaascari on 24/04/15.
 */
public class SemiCircleDrawable extends Drawable {

    private final int mBackgroundColor;
    private final Paint mBackgroundPaint;
    private Paint paint;
    private RectF rectF;
    private int circleColor;
    private Direction angle;

    public enum Direction {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    public SemiCircleDrawable() {
        this(Color.BLUE, Color.BLACK, Direction.LEFT);
    }

    public SemiCircleDrawable(int circleColor, int backgroundColor, Direction angle) {
        this.circleColor = circleColor;
        this.mBackgroundColor = backgroundColor;
        this.angle = angle;
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(mBackgroundColor);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        paint = new Paint();
        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        rectF = new RectF();
    }

    public int getCircleColor() {
        return circleColor;
    }

    /**
     * A 32bit circleColor not a circleColor resources.
     *
     * @param circleColor
     */
    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
        paint.setColor(circleColor);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();



        Rect bounds = getBounds();

        if (angle == Direction.LEFT || angle == Direction.RIGHT) {
            canvas.scale(2, 1);
            if (angle == Direction.RIGHT) {
                canvas.translate(-(bounds.right / 2), 0);
            }
        } else {
            canvas.scale(1, 2);
            if (angle == Direction.BOTTOM) {
                canvas.translate(0, -(bounds.bottom / 2));
            }
        }


        rectF.set(bounds);

        canvas.drawPaint(mBackgroundPaint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        if (angle == Direction.LEFT)
            canvas.drawArc(rectF, 90, 180, true, paint);
        else if (angle == Direction.TOP)
            canvas.drawArc(rectF, -180, 180, true, paint);
        else if (angle == Direction.RIGHT)
            canvas.drawArc(rectF, 270, 180, true, paint);
        else if (angle == Direction.BOTTOM)
            canvas.drawArc(rectF, 0, 180, true, paint);

    }

    @Override
    public void setAlpha(int alpha) {
        // Has no effect
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        // Has no effect
    }

    @Override
    public int getOpacity() {
        // Not Implemented
        return 0;
    }

}
