package com.hlhj.guanggou.po;

import java.util.ArrayList;
import java.util.List;

public class CombinationTopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CombinationTopicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCombinationIdIsNull() {
            addCriterion("combination_id is null");
            return (Criteria) this;
        }

        public Criteria andCombinationIdIsNotNull() {
            addCriterion("combination_id is not null");
            return (Criteria) this;
        }

        public Criteria andCombinationIdEqualTo(String value) {
            addCriterion("combination_id =", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdNotEqualTo(String value) {
            addCriterion("combination_id <>", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdGreaterThan(String value) {
            addCriterion("combination_id >", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdGreaterThanOrEqualTo(String value) {
            addCriterion("combination_id >=", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdLessThan(String value) {
            addCriterion("combination_id <", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdLessThanOrEqualTo(String value) {
            addCriterion("combination_id <=", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdLike(String value) {
            addCriterion("combination_id like", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdNotLike(String value) {
            addCriterion("combination_id not like", value, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdIn(List<String> values) {
            addCriterion("combination_id in", values, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdNotIn(List<String> values) {
            addCriterion("combination_id not in", values, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdBetween(String value1, String value2) {
            addCriterion("combination_id between", value1, value2, "combinationId");
            return (Criteria) this;
        }

        public Criteria andCombinationIdNotBetween(String value1, String value2) {
            addCriterion("combination_id not between", value1, value2, "combinationId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(String value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(String value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(String value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(String value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(String value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(String value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLike(String value) {
            addCriterion("topic_id like", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotLike(String value) {
            addCriterion("topic_id not like", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<String> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<String> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(String value1, String value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(String value1, String value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}