package com.witcher.androidrss.api.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultResponse<T> {

    @SerializedName("data")
    @Expose
    private T data;

    @SerializedName("meta")
    @Expose
    private Meta meta;

    public class Meta {

        @SerializedName("message")
        @Expose
        private String message;

        @SerializedName("status")
        @Expose
        private Status status;

        public Meta() {
        }

        public Meta(String message, Status status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public Status getStatus() {
            return status;
        }
    }

    public enum Status {
        OK, ERROR
    }

    public T getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }
}
