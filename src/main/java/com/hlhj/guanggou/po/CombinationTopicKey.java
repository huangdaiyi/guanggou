package com.hlhj.guanggou.po;

public class CombinationTopicKey {
    private String combinationId;

    private String topicId;

    public String getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(String combinationId) {
        this.combinationId = combinationId == null ? null : combinationId.trim();
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }
}