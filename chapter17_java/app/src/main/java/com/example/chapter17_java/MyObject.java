package com.example.chapter17_java;

import java.util.List;

public class MyObject {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {

        private List<Record> records;

        public List<Record> getRecords() {
            return records;
        }

        public void setRecords(List<Record> records) {
            this.records = records;
        }

        public static class Record {

            private String SiteName;
            private String Status;

            public String getSiteName() {
                return SiteName;
            }

            public void setSiteName(String siteName) {
                SiteName = siteName;
            }

            public String getStatus() {
                return Status;
            }

            public void setStatus(String status) {
                Status = status;
            }
        }
    }
}
