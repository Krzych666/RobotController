package com.company.implememtations;

import com.company.abstracts.RoomFloor;

public class RoomFloorImpl implements RoomFloor {

    private int width;
    private int depth;

    public RoomFloorImpl(int width, int depth) {
        this.width = width;
        this.depth = depth;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public void setDepth(int newDepth) {
        this.depth = newDepth;
    }
}
