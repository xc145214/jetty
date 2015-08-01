package com.xc.jetty.socket.protocol;

import java.io.IOException;

/**
 * Created by Administrator on 2015/8/1.
 */
public interface VoteMsgCoder {
    byte[] toWire(VoteMsg msg) throws IOException;

    VoteMsg fromWire(byte[] input) throws IOException;
}
