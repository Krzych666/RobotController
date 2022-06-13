package com.company.builders;

import com.company.abstracts.RoomFloor;
import com.company.implememtations.RoomFloorImpl;

public class RoomFloorBuilder {

    private int width;
    private int depth;

    public RoomFloorBuilder width(int width) {
        this.width = width;
        return this;
    }

    public RoomFloorBuilder depth(int depth) {
        this.depth = depth;
        return this;
    }


    public RoomFloor build() {
        return new RoomFloorImpl(width, depth);
    }
}
