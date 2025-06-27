package com.vinhnd.ung_dung_muon_sach.util;

public class GenerateCodeUtil {
    public static Long getCode(){
        return (long) (Math.random() * 90000) + 10000;
    }
}
