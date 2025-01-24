package com.example.tictactoefb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Cell {
    static int Xval = 0;
    static int Oval = 1;
    static int EmptyVal = 2;
    private final int x;
    private final int y;
    private final int cellWidth;
    Bitmap bitmapX, bitmapO;
    private int val;



    public Cell(int x, int y, int cellWidth, Bitmap bitmapX, Bitmap bitmapO) {
        this.x = x;
        this.y = y;
        this.cellWidth = cellWidth;
        this.bitmapX = bitmapX;
        this.bitmapO = bitmapO;
        this.val = EmptyVal;
    }

    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setStrokeWidth(30);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawRect(x,y,x+cellWidth,y+cellWidth, p);
        if(val == Xval)
            canvas.drawBitmap(bitmapX,x+10,y+10,null);
        if(val == Oval)
            canvas.drawBitmap(bitmapO,x+10,y+10,null);

    }

    public boolean setVal(int val) {
        if(this.val == EmptyVal)
        {
            this.val = val;
            return true;
        }
        return false;
    }

    public int getVal() {
        return val;
    }

    public boolean isEmpty() {
        return this.val == EmptyVal;
    }
}
