package com.mytest.pattern;

public class BuilderPattern implements Builder<BuilderPattern> {

    private final int int1;
    private final int int2;
    private final String str1;
    private final String str2;
    private final long long1;
    private final long long2;

    public static class Builder {
        // Required parameters
        private final int int1;
        private final int int2;

        // Optional parameters - initialized to default values
        private String str1 = "default1";
        private String str2 = "default2";
        private long long1 = 1;
        private long long2 = 2;

        public Builder(int int1, int int2) {
            this.int1 = int1;
            this.int2 = int2;
        }

        public Builder str1(String val) {
            str1 = val;
            return this;
        }

        public Builder str2(String val) {
            str2 = val;
            return this;
        }

        public Builder long1(long val) {
            long1 = val;
            return this;
        }

        public Builder long2(long val) {
            long2 = val;
            return this;
        }

        public BuilderPattern builder() {
            return new BuilderPattern(this);
        }
    }

    private BuilderPattern(Builder builder) {
        int1 = builder.int1;
        int2 = builder.int2;
        str1 = builder.str1;
        str2 = builder.str2;
        long1 = builder.long1;
        long2 = builder.long2;
    }

    @Override
    public BuilderPattern build() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern.Builder(1, 2).str1("str1").str2("str2").long1(1).long2(2).builder();

    }

}

interface Builder<T> {
    public T build();
}
