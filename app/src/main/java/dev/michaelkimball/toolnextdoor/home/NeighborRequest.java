package dev.michaelkimball.toolnextdoor.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NeighborRequest {
    @SerializedName("requestId")
    @Expose
    private int requestId;

    @SerializedName("body")
    @Expose
    private String body;

    public NeighborRequest(int requestId, String body) {
        this.requestId = requestId;
        this.body = body;
    }

    public NeighborRequest() {
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
