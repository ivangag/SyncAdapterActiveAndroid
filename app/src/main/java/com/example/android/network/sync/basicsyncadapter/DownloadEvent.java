package com.example.android.network.sync.basicsyncadapter;

/**
 * Created by Ivan on 26/10/2014.
 */
public class DownloadEvent {
    private boolean status;
    private int valueEvent;

    public DownloadEvent(boolean status, int valueEvnt){
        this.status = status;
        this.valueEvent = valueEvnt;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getValueEvent() {
        return valueEvent;
    }

    public void setValueEvent(int valueEvent) {
        this.valueEvent = valueEvent;
    }

    public static class Builder{
        boolean status;
        private int valueEvnt;
        public Builder setStatus(boolean status){
            this.status = status;
            return this;
        }

        public Builder setValueEvnt(int valueEvnt){
            this.valueEvnt = valueEvnt;
            return this;
        }

        public DownloadEvent Build(){
            return new DownloadEvent(this.status,this.valueEvnt);
        }
    }

    @Override
    public String toString(){
        return "status:" + isStatus() + ";" + "valueEvent:" + this.valueEvent;
    }
}
