package com.immoc.zb666

class ReleaseInfoExt{
    String versionCode
    String versionName
    String fileName
    String versionInfo

    ReleaseInfoExt(){

    }

    @Override
    public String toString() {
        return "com.immoc.zb666.ReleaseInfoExt{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", versionInfo='" + versionInfo + '\'' +
                '}';
    }
}